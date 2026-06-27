import requests
from fastapi import APIRouter, Request, Response
from starlette.responses import JSONResponse

router = APIRouter()

SOFASCORE_BASE_URL = "https://api.sofascore.com/api/v1"

HUMAN_HEADERS = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36",
    "Accept": "*/*",
    "Accept-Language": "it-IT,it;q=0.9,en-US;q=0.8,en;q=0.7",
    "Cache-Control": "max-age=0",
    "Origin": "https://www.sofascore.com",
    "Referer": "https://www.sofascore.com/",
}

@router.get("/{path:path}")
async def proxy_sofascore(path: str, request: Request):
    query_params = request.query_params
    url = f"{SOFASCORE_BASE_URL}/{path}"
    if query_params:
        url += f"?{query_params}"

    try:
        response = requests.get(url, headers=HUMAN_HEADERS, timeout=10)
        return Response(
            content=response.content,
            status_code=response.status_code,
            headers={"Content-Type": response.headers.get("Content-Type", "application/json")}
        )
    except Exception as e:
        return JSONResponse(status_code=500, content={"error": str(e)})
