package com.scoutapp.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/fbref")
public class PlayerStatsController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/stats/combined/{tmId}/{fbrefId}/{slug}")
    public ResponseEntity<?> getCombinedStats(
            @PathVariable String tmId,
            @PathVariable String fbrefId,
            @PathVariable String slug) {

        System.out.println("\n==================================================");
        System.out.println("[HYBRID STATS] Avvio fusione dati per: " + slug);
        System.out.println("[HYBRID STATS] IDs ricevuti -> TM: " + tmId + " | FBref: " + fbrefId);
        System.out.println("==================================================");

        // Mappa finale con valori di fallback sicuri per Android
        Map<String, Object> stats = new HashMap<>();
        stats.put("season", "24/25");
        stats.put("minutes", 0);
        stats.put("goals", 0);
        stats.put("assists", 0);
        stats.put("apps", 0);
        stats.put("xG", 0.0);
        stats.put("xA", 0.0);
        stats.put("key_passes", 0);
        stats.put("progressive_passes", 0);
        stats.put("progressive_carries", 0);
        stats.put("pressures", 0);

        // =========================================================================
        // STEP 1: SOLUZIONE AGGRESSIVA PER LEISTUNGSDATEN (GESTIONE REDIRECT)
        // =========================================================================
        // Usiamo l'URL numerico diretto. Jsoup seguirà il redirect allo slug corretto.
        String tmUrl = "https://www.transfermarkt.com/player/leistungsdaten/spieler/" + tmId + "/plus/0?saison=2024";
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36";

        try {
            System.out.println("[TM FETCH] Richiesta con follow-redirect forzato su ID: " + tmId);
            
            Document doc = Jsoup.connect(tmUrl)
                                .userAgent(userAgent)
                                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                                .header("Accept-Language", "it-IT,it;q=0.9,en-US;q=0.8,en;q=0.7")
                                .header("Cache-Control", "no-cache")
                                .header("Pragma", "no-cache")
                                .followRedirects(true)
                                .timeout(15000)
                                .get();
            
            System.out.println("[TM FETCH] Arrivato all'URL reale dopo redirect: " + doc.location());

            Element table = doc.selectFirst("table.items");
            if (table == null) {
                table = doc.selectFirst("table[class*=items]");
            }

            if (table != null) {
                Element tfoot = table.selectFirst("tfoot");
                if (tfoot != null) {
                    Elements rows = tfoot.select("tr");
                    Element targetRow = null;
                    
                    for (Element row : rows) {
                        String rowText = row.text().toLowerCase();
                        if (rowText.contains("totale") || rowText.contains("total") || rowText.contains("bilancio")) {
                            targetRow = row;
                            break;
                        }
                    }

                    if (targetRow != null) {
                        Elements cells = targetRow.select("td");
                        
                        java.util.function.Function<String, String> cleanStat = (text) -> {
                            String clean = text.trim().replace("-", "0").replace(".", "").replace("'", "").replaceAll("\\s+", "");
                            return clean.isEmpty() ? "0" : clean;
                        };

                        if (cells.size() >= 4) {
                            String mpText = cleanStat.apply(cells.get(1).text());
                            String gText = cleanStat.apply(cells.get(2).text());
                            String aText = cleanStat.apply(cells.get(3).text());
                            String minsText = cleanStat.apply(cells.get(cells.size() - 1).text());

                            stats.put("apps", Integer.parseInt(mpText));
                            stats.put("goals", Integer.parseInt(gText));
                            stats.put("assists", Integer.parseInt(aText));
                            stats.put("minutes", Integer.parseInt(minsText));

                            System.out.println("[TM FETCH] SUCCESS! apps: " + stats.get("apps") + 
                                               " | goals: " + stats.get("goals") + " | assists: " + stats.get("assists") +
                                               " | mins: " + stats.get("minutes"));
                        }
                    } else {
                        System.out.println("[TM FETCH] Errore: Riga riassuntiva non trovata nel tfoot.");
                    }
                }
            } else {
                System.out.println("[TM FETCH] ERRORE: La tabella dei dati è ancora assente.");
            }
        } catch (Exception e) {
            System.out.println("[TM FETCH] Eccezione intercettata: " + e.getMessage());
        }

        // =========================================================================
        // STEP 2: RACCOLTA DATI AVANZATI DA PROXY / WAYBACK FBREF
        // =========================================================================
        // Qui interroghiamo il tuo proxy Django locale per evitare blocchi Cloudflare
        String djangoProxyUrl = "http://127.0.0.1:9100/fbref/stats/" + fbrefId + "/" + slug;
        
        try {
            System.out.println("[FBREF FETCH] Richiesta dati avanzati al proxy Django: " + djangoProxyUrl);
            
            // Usiamo Jsoup per leggere il JSON emesso da Django
            String jsonResponse = Jsoup.connect(djangoProxyUrl).ignoreContentType(true).timeout(10000).execute().body();
            
            Map<String, Object> map = objectMapper.readValue(jsonResponse, Map.class);
            if (map.containsKey("stats")) {
                Map<String, Object> fbrefStats = (Map<String, Object>) map.get("stats");
                
                // Helper per gestire conversioni sicure da JSON (che spesso legge numeri come Double)
                java.util.function.Function<Object, Integer> toInt = (obj) -> {
                    if (obj == null) return 0;
                    if (obj instanceof Number) return ((Number) obj).intValue();
                    try { return Integer.parseInt(obj.toString()); } catch (Exception e) { return 0; }
                };

                java.util.function.Function<Object, Double> toDouble = (obj) -> {
                    if (obj == null) return 0.0;
                    if (obj instanceof Number) return ((Number) obj).doubleValue();
                    try { return Double.parseDouble(obj.toString()); } catch (Exception e) { return 0.0; }
                };

                // Uniamo i dati avanzati (xG, xA, passaggi chiave, ecc.)
                if (fbrefStats.containsKey("xG")) stats.put("xG", toDouble.apply(fbrefStats.get("xG")));
                if (fbrefStats.containsKey("xA")) stats.put("xA", toDouble.apply(fbrefStats.get("xA")));
                if (fbrefStats.containsKey("key_passes")) stats.put("key_passes", toInt.apply(fbrefStats.get("key_passes")));
                if (fbrefStats.containsKey("progressive_passes")) stats.put("progressive_passes", toInt.apply(fbrefStats.get("progressive_passes")));
                if (fbrefStats.containsKey("progressive_carries")) stats.put("progressive_carries", toInt.apply(fbrefStats.get("progressive_carries")));
                if (fbrefStats.containsKey("pressures")) stats.put("pressures", toInt.apply(fbrefStats.get("pressures")));
                if (fbrefStats.containsKey("minutes")) stats.put("minutes", toInt.apply(fbrefStats.get("minutes")));
                if (fbrefStats.containsKey("season")) stats.put("season", fbrefStats.get("season").toString());
            }
            
            System.out.println("[FBREF FETCH] SUCCESS! Dati avanzati uniti.");
            
        } catch (Exception e) {
            System.out.println("[FBREF FETCH] ERRORE durante il recupero da FBref Proxy: " + e.getMessage());
        }

        // Risposta finale strutturata per Android Studio
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("player_id", fbrefId);
        responseBody.put("transfermarkt_id", tmId);
        responseBody.put("stats", stats);

        System.out.println("[HYBRID STATS] Risposta inviata ad Android con successo.\n");
        return ResponseEntity.ok(responseBody);
    }
}
