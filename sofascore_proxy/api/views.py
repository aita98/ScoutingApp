from django.http import JsonResponse
from curl_cffi import requests

BASE = "https://api.sofascore.com/api/v1"

HEADERS = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
    "Accept": "application/json",
    "Accept-Language": "en-US,en;q=0.9",
    "Referer": "https://www.sofascore.com/",
}

def proxy(endpoint):
    url = f"{BASE}{endpoint}"
    try:
        # impersonate="chrome" simulates a real browser to bypass Cloudflare
        r = requests.get(url, headers=HEADERS, impersonate="chrome")
        return JsonResponse(r.json(), safe=False, status=r.status_code)
    except Exception as e:
        return JsonResponse({"error": str(e)}, status=500)

def search_player(request):
    query = request.GET.get("query")
    return proxy(f"/search/all?q={query}")

def get_player(request, player_id):
    return proxy(f"/player/{player_id}")

def get_player_stats(request, player_id):
    return proxy(f"/player/{player_id}/statistics/overall")

def get_player_events(request, player_id):
    return proxy(f"/player/{player_id}/events/last/0")

def get_player_per90(request, player_id):
    # Logic to get latest season ID first
    try:
        seasons_url = f"{BASE}/player/{player_id}/statistics/seasons"
        r = requests.get(seasons_url, headers=HEADERS, impersonate="chrome")
        seasons = r.json().get("seasons", [])
        if not seasons:
            return JsonResponse({"per90": {}}, status=200)

        latest_season_id = seasons[0].get("season", {}).get("id")
        return proxy(f"/player/{player_id}/season/{latest_season_id}/statistics/per90")
    except Exception as e:
        return JsonResponse({"error": str(e)}, status=500)
