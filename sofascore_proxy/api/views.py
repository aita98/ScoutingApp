import asyncio
import json
import os
import re
import traceback
import unicodedata
import urllib.parse
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt
from playwright.async_api import async_playwright
from playwright_stealth import Stealth
import requests
from bs4 import BeautifulSoup
import bs4

# Risolve il warning "Proactor event loop..." su Windows
if os.name == 'nt':
    asyncio.set_event_loop_policy(asyncio.WindowsSelectorEventLoopPolicy())

USER_DATA_DIR = r"D:\Progetti\FootballScouting\chrome-profile"

def normalize_name(name: str) -> str:
    # Decodifica eventuali %20 o + rimasti dall'URL di Django
    name = urllib.parse.unquote(name).replace("+", " ")

    # Rimuove accenti e caratteri strani, riduce spazi
    clean = unicodedata.normalize('NFKD', name)
    clean = clean.encode('ascii', 'ignore').decode('ascii')
    clean = re.sub(r"[^a-zA-Z0-9 ]", " ", clean)
    clean = re.sub(r"\s+", " ", clean).strip()
    return clean

@csrf_exempt
def resolve_player(request, name):
    if request.method != "GET":
        return JsonResponse({"error": "Method not allowed"}, status=405)

    decoded_name = urllib.parse.unquote(name).replace("+", " ")
    print(f"\n[SEARCH SOLVER] Cerco sui motori indicizzati: '{decoded_name}'")

    # Costruiamo la query perfetta per beccare subito la pagina FBref
    search_query = f"{decoded_name} fbref players"

    # Usiamo l'endpoint di HTML-Search leggero di DuckDuckGo che non usa JS ed è gratis
    search_url = f"https://html.duckduckgo.com/html/?q={urllib.parse.quote(search_query)}"

    headers = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
        "Accept-Language": "en-US,en;q=0.9"
    }

    try:
        # Interroghiamo DuckDuckGo (che ha già indicizzato FBref per noi)
        resp = requests.get(search_url, headers=headers, timeout=10)

        if resp.status_code == 200:
            html = resp.text

            # Cerchiamo i link di FBref iniettati nei risultati di ricerca di DDG
            # Il pattern cerca URL del tipo: fbref.com/en/players/ID/Nome
            matches = re.findall(r"fbref\.com/en/players/([a-f0-9]{8})/([a-zA-Z0-9\-]+)", html)

            if matches:
                # Prendiamo il primo risultato utile
                player_id, slug = matches[0]
                print(f"[SEARCH SOLVER] Successo! Trovato tramite indice: ID={player_id}, Slug={slug}")

                return JsonResponse({
                    "id": player_id,
                    "name": slug,
                    "source": "search_index_provider"
                })

            # Se DDG fa i capricci, proviamo il piano B di riserva (Regex flessibile sull'intero testo)
            m = re.search(r"/players/([a-f0-9]{8})/([^\"'&>]+)", html)
            if m:
                found_id = m.group(1)
                found_slug = m.group(2).split("/")[-1].split("?")[0]
                print(f"[SEARCH SOLVER] Trovato tramite fallback regex: {found_id} ({found_slug})")
                return JsonResponse({
                    "id": found_id,
                    "name": found_slug,
                    "source": "search_index_fallback"
                })

            return JsonResponse({"error": "Giocatore non trovato nei risultati di ricerca"}, status=404)
        else:
            return JsonResponse({"error": f"Il motore di ricerca ha risposto con status {resp.status_code}"}, status=500)

    except Exception as e:
        print(f"[SEARCH SOLVER] Errore critico: {e}")
        return JsonResponse({"error": str(e)}, status=500)

@csrf_exempt
def get_fbref_stats(request, fbref_id, slug):
    if request.method != "GET":
        return JsonResponse({"error": "Method not allowed"}, status=405)

    print(f"\n[STATS SOLVER] Estrazione analitica avanzata per: {fbref_id} ({slug})")
    target_url = f"https://fbref.com/en/players/{fbref_id}/{slug}"
    html_content = None
    source_used = None

    # --- STRATEGIA 1: WAYBACK MACHINE ---
    try:
        archive_api = f"https://archive.org/wayback/available?url={target_url}"
        archive_resp = requests.get(archive_api, timeout=7).json()
        snapshots = archive_resp.get("archived_snapshots", {})
        if snapshots and "closest" in snapshots and snapshots["closest"].get("available", False):
            cached_url = snapshots["closest"]["url"]
            print(f"[STATS SOLVER] Cache Wayback trovata: {cached_url}")
            html_resp = requests.get(cached_url, timeout=10)
            if html_resp.status_code == 200:
                html_content = html_resp.text
                source_used = "wayback_machine"
    except Exception as e:
        print(f"[STATS SOLVER] Errore su Wayback: {e}")

    # --- STRATEGIA 2: FALLBACK GOOGLE CACHE ---
    if not html_content:
        print("[STATS SOLVER] Wayback non disponibile. Tento il Fallback su Google Cache...")
        try:
            google_cache_url = f"https://webcache.googleusercontent.com/search?q=cache:{target_url}&strip=0&vwsrc=0"
            headers = {"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"}
            html_resp = requests.get(google_cache_url, headers=headers, timeout=10)
            if html_resp.status_code == 200:
                html_content = html_resp.text
                source_used = "google_cache"
                print("[STATS SOLVER] Cache di Google recuperata con successo!")
        except Exception as e:
            print(f"[STATS SOLVER] Errore su Google Cache: {e}")

    if not html_content:
        return JsonResponse({"error": "Impossibile recuperare i dati dai motori di cache"}, status=404)

    # --- PARSING DETTAGLIATO FBREF ---
    try:
        soup = BeautifulSoup(html_content, "html.parser")

        # Struttura dati finale pulita richiesta per la UI dello scouting
        stats_data = {
            "season": "N/A",
            "squad": "N/A",
            "matches_played": "0",
            "goals": "0",
            "assists": "0",
            "xg": "0.0",
            "xa": "0.0",
            "key_passes": "0",
            "progressive_passes": "0",
            "progressive_carries": "0",
            "minutes": "0",
            "pressures": "0"
        }

        def get_text_by_stat(row, stat_name, default="0"):
            cell = row.find(["td", "th"], {"data-stat": stat_name})
            return cell.get_text().strip() if cell and cell.get_text().strip() else default

        # Tabella Standard (Contiene: Stagione, Squadra, Presenze, Gol, Assist, xG, xA, Minuti)
        standard_table = soup.find("table", id="stats_standard_dom_lg")
        if standard_table and standard_table.find("tbody"):
            rows = standard_table.find("tbody").find_all("tr", class_=lambda x: x != "partial_table")
            if rows:
                last_row = rows[-1]
                stats_data["season"] = get_text_by_stat(last_row, "year", "N/A")
                stats_data["squad"] = get_text_by_stat(last_row, "team", "N/A")
                stats_data["matches_played"] = get_text_by_stat(last_row, "games")
                stats_data["goals"] = get_text_by_stat(last_row, "goals")
                stats_data["assists"] = get_text_by_stat(last_row, "assists")
                stats_data["xg"] = get_text_by_stat(last_row, "xg")
                stats_data["xa"] = get_text_by_stat(last_row, "xg_assist")
                stats_data["minutes"] = get_text_by_stat(last_row, "minutes")

        # Parsing tabelle aggiuntive o Scouting Report
        # Proviamo a scansionare tutte le tabelle per i dati mancanti
        import bs4
        all_tables = soup.find_all('table')
        comments = soup.find_all(string=lambda text: isinstance(text, bs4.Comment))
        for comment in comments:
            if "<table" in comment:
                comment_soup = BeautifulSoup(str(comment), 'html.parser')
                all_tables.extend(comment_soup.find_all('table'))

        for table in all_tables:
            t_id = table.get('id', '')

            # Cerca nello Scouting Report (spesso la fonte migliore per metriche avanzate)
            if "scouting_report" in t_id:
                for row in table.find_all("tr"):
                    stat_name_cell = row.find("th", {"data-stat": "statistic"})
                    if stat_name_cell:
                        text_label = stat_name_cell.get_text().lower()
                        value_cell = row.find("td", {"data-stat": "per90"}) or row.find("td", {"data-stat": "value"})
                        if value_cell:
                            val = value_cell.get_text().strip()
                            if "key passes" in text_label: stats_data["key_passes"] = val
                            elif "progressive passes" in text_label: stats_data["progressive_passes"] = val
                            elif "progressive carries" in text_label: stats_data["progressive_carries"] = val
                            elif "pressures" in text_label: stats_data["pressures"] = val

            # Cerca nelle tabelle specifiche se i dati non sono ancora stati popolati
            if "stats_passing_dom_lg" in t_id:
                rows = table.select("tbody tr")
                if rows:
                    last_row = rows[-1]
                    if stats_data["key_passes"] == "0": stats_data["key_passes"] = get_text_by_stat(last_row, "assisted_shots")
                    if stats_data["progressive_passes"] == "0": stats_data["progressive_passes"] = get_text_by_stat(last_row, "progressive_passes")

            if "stats_possession_dom_lg" in t_id:
                rows = table.select("tbody tr")
                if rows:
                    last_row = rows[-1]
                    if stats_data["progressive_carries"] == "0": stats_data["progressive_carries"] = get_text_by_stat(last_row, "progressive_carries")

        # Helper conversioni per garantire numeri reali e non stringhe
        def to_int(s):
            if not s: return 0
            try: return int(re.sub(r"[^0-9]", "", str(s)))
            except: return 0

        def to_float(s):
            if not s: return 0.0
            try: return float(str(s).replace("%", "").strip())
            except: return 0.0

        # Mappatura finale per pareggiare il DTO Kotlin
        final_stats = {
            "season": stats_data.get("season", "N/A"),
            "minutes": to_int(stats_data.get("minutes") or stats_data.get("matches_played")),
            "goals": to_int(stats_data.get("goals")),
            "assists": to_int(stats_data.get("assists")),
            "apps": to_int(stats_data.get("matches_played")),
            "xG": to_float(stats_data.get("xg")),
            "xA": to_float(stats_data.get("xa")),
            "key_passes": to_int(stats_data.get("key_passes")),
            "progressive_passes": to_int(stats_data.get("progressive_passes")),
            "progressive_carries": to_int(stats_data.get("progressive_carries")),
            "pressures": to_int(stats_data.get("pressures"))
        }

        print(f"[STATS SOLVER] Successo! Invio JSON a Spring. xG={final_stats['xG']}, Goals={final_stats['goals']}")

        return JsonResponse({
            "player_id": fbref_id,
            "slug": slug,
            "provider": source_used,
            "stats": final_stats
        })

    except Exception as e:
        print(f"[STATS SOLVER] Errore nel parsing: {e}")
        traceback.print_exc()
        return JsonResponse({"error": f"Errore nel parsing: {str(e)}"}, status=500)

@csrf_exempt
def get_combined_player_stats(request, tm_id, fbref_id, fbref_slug):
    if request.method != "GET":
        return JsonResponse({"error": "Method not allowed"}, status=405)

    print(f"\n[HYBRID STATS] Avvio fusione dati per ID TM: {tm_id}, FBref: {fbref_id}")

    # Inizializziamo il dizionario unico con tutti i campi richiesti nella UI
    combined_stats = {
        "season": "24/25",
        "matches_played": 0,
        "goals": 0,
        "assists": 0,
        "xg": 0.0,
        "xa": 0.0,
        "key_passes": 0,
        "progressive_passes": 0,
        "progressive_carries": 0,
        "minutes": 0,
        "pressures": 0
    }

    # =========================================================================
    # BLOCCO 1: LOGICA LIVE DA TRANSFERMARKT (Presenze, Gol, Assist)
    # =========================================================================
    tm_url = f"https://www.transfermarkt.com/player/leistungsdaten/spieler/{tm_id}"
    tm_headers = {"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"}

    try:
        tm_resp = requests.get(tm_url, headers=tm_headers, timeout=10)
        if tm_resp.status_code == 200:
            tm_soup = BeautifulSoup(tm_resp.text, "html.parser")
            tm_table = tm_soup.find("table", class_="items")
            if tm_table and tm_table.find("tfoot"):
                total_row = tm_table.find("tfoot").find("tr")
                cells = total_row.find_all("td")
                if len(cells) >= 4:
                    def clean_tm_val(s):
                        return re.sub(r"[^0-9]", "", s.get_text().strip().replace("-", "0")) or "0"

                    combined_stats["matches_played"] = int(clean_tm_val(cells[1]))
                    combined_stats["goals"] = int(clean_tm_val(cells[2]))
                    combined_stats["assists"] = int(clean_tm_val(cells[3]))
                    print("[HYBRID STATS] Dati standard prelevati da Transfermarkt (LIVE)")
    except Exception as e:
        print(f"[HYBRID STATS] Errore su Transfermarkt: {e}")

    # =========================================================================
    # BLOCCO 2: LOGICA DA CACHE FBREF (xG, xA, Key Passes, Prog. Passes/Carries)
    # =========================================================================
    fbref_target_url = f"https://fbref.com/en/players/{fbref_id}/{fbref_slug}"
    fbref_html = None
    source_used = None

    # Tentiamo prima Wayback
    try:
        archive_api = f"https://archive.org/wayback/available?url={fbref_target_url}"
        archive_resp = requests.get(archive_api, timeout=5).json()
        snapshots = archive_resp.get("archived_snapshots", {})
        if snapshots and "closest" in snapshots and snapshots["closest"].get("available", False):
            cached_url = snapshots["closest"]["url"]
            html_resp = requests.get(cached_url, timeout=7)
            if html_resp.status_code == 200:
                fbref_html = html_resp.text
                source_used = "wayback_machine"
                print("[HYBRID STATS] Dati avanzati trovati su Wayback Machine")
    except Exception as e:
        print(f"[HYBRID STATS] Errore cache FBref: {e}")

    # Se abbiamo l'HTML di FBref, estraiamo solo le metriche avanzate
    if fbref_html:
        try:
            fb_soup = BeautifulSoup(fbref_html, "html.parser")

            def to_int(s):
                if not s: return 0
                try: return int(re.sub(r"[^0-9]", "", str(s)))
                except: return 0

            def to_float(s):
                if not s: return 0.0
                try: return float(str(s).replace("%", "").strip())
                except: return 0.0

            # Estraiamo tabelle visibili e quelle nei commenti
            all_tables = fb_soup.find_all('table')
            comments = fb_soup.find_all(string=lambda text: isinstance(text, bs4.Comment))
            for comment in comments:
                if "<table" in comment:
                    comment_soup = BeautifulSoup(str(comment), 'html.parser')
                    all_tables.extend(comment_soup.find_all('table'))

            for table in all_tables:
                t_id = table.get('id', '')

                # Scouting Report
                if "scouting_report" in t_id:
                    for row in table.find_all("tr"):
                        stat_name_cell = row.find("th", {"data-stat": "statistic"})
                        if stat_name_cell:
                            label = stat_name_cell.get_text().lower()
                            value_cell = row.find("td", {"data-stat": "per90"}) or row.find("td", {"data-stat": "value"})
                            if value_cell:
                                val = value_cell.get_text().strip()
                                if "key passes" in label: combined_stats["key_passes"] = to_int(val)
                                elif "progressive passes" in label: combined_stats["progressive_passes"] = to_int(val)
                                elif "progressive carries" in label: combined_stats["progressive_carries"] = to_int(val)
                                elif "pressures" in label: combined_stats["pressures"] = to_int(val)

                # Standard Table (per xG, xA)
                if "stats_standard_dom_lg" in t_id:
                    rows = table.select("tbody tr")
                    if rows:
                        last_row = rows[-1]
                        xg_val = last_row.find(["td", "th"], {"data-stat": "xg"})
                        xa_val = last_row.find(["td", "th"], {"data-stat": "xg_assist"})
                        if xg_val: combined_stats["xg"] = to_float(xg_val.get_text())
                        if xa_val: combined_stats["xa"] = to_float(xa_val.get_text())

            print("[HYBRID STATS] Dati avanzati uniti con successo")
        except Exception as e:
            print(f"[HYBRID STATS] Errore nel parsing dei dati avanzati: {e}")

    # Mappatura finale per pareggiare il DTO Kotlin (Nomi campi)
    final_response = {
        "transfermarkt_id": tm_id,
        "fbref_id": fbref_id,
        "provider": source_used,
        "stats": {
            "season": combined_stats["season"],
            "minutes": combined_stats["minutes"],
            "goals": combined_stats["goals"],
            "assists": combined_stats["assists"],
            "apps": combined_stats["matches_played"],
            "xG": combined_stats["xg"],
            "xA": combined_stats["xa"],
            "key_passes": combined_stats["key_passes"],
            "progressive_passes": combined_stats["progressive_passes"],
            "progressive_carries": combined_stats["progressive_carries"],
            "pressures": combined_stats["pressures"]
        }
    }

    return JsonResponse(final_response)

@csrf_exempt
def bridge(request):
    return JsonResponse({"status": "bridge active"})
