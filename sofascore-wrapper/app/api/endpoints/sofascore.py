from fastapi import APIRouter, HTTPException, Query
from sofascore_wrapper.api import SofascoreAPI
from sofascore_wrapper.search import Search
from sofascore_wrapper.player import Player
import asyncio

router = APIRouter()
_api_instance = None

async def get_api():
    global _api_instance
    if _api_instance is None:
        _api_instance = SofascoreAPI()
    return _api_instance

@router.get("/search")
async def search_players(query: str = Query(...)):
    """Search for players by name using Playwright wrapper."""
    try:
        api = await get_api()
        s = Search(api, search_string=query)
        results = await s.search_all()
        return results
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

@router.get("/player/{player_id}")
async def get_player_profile(player_id: int):
    """Get player profile by ID."""
    try:
        api = await get_api()
        p = Player(api, player_id=player_id)
        profile = await p.get_profile()
        return {"player": profile}
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

@router.get("/player/{player_id}/stats")
async def get_player_stats(player_id: int):
    """Get latest seasonal statistics for a player."""
    try:
        api = await get_api()
        p = Player(api, player_id=player_id)
        # Fetching all seasons to find the latest one
        seasons_data = await p.get_statistics_seasons()
        seasons = seasons_data.get("seasons", [])

        if not seasons:
            return {"statistics": {}}

        latest = seasons[0]
        season_id = latest.get("season", {}).get("id")
        unique_tournament_id = latest.get("uniqueTournament", {}).get("id")

        if season_id and unique_tournament_id:
            stats = await p.get_statistics_season_tournament(
                season_id=season_id,
                unique_tournament_id=unique_tournament_id
            )
            return stats
        return {"statistics": {}}
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

@router.get("/player/{player_id}/season/{season_id}")
async def get_player_season_stats(player_id: int, season_id: int):
    """Get statistics for a specific season."""
    try:
        api = await get_api()
        p = Player(api, player_id=player_id)
        seasons_data = await p.get_statistics_seasons()
        seasons = seasons_data.get("seasons", [])

        target_season = next((s for s in seasons if s.get("season", {}).get("id") == season_id), None)
        if target_season:
            ut_id = target_season.get("uniqueTournament", {}).get("id")
            stats = await p.get_statistics_season_tournament(
                season_id=season_id,
                unique_tournament_id=ut_id
            )
            return stats

        return {"statistics": {}}
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

@router.get("/player/{player_id}/per-90")
async def get_player_per90(player_id: int):
    """Get per-90 statistics for the latest season."""
    try:
        api = await get_api()
        p = Player(api, player_id=player_id)
        seasons_data = await p.get_statistics_seasons()
        seasons = seasons_data.get("seasons", [])

        if not seasons:
            return {"per90": {}}

        latest = seasons[0]
        season_id = latest.get("season", {}).get("id")

        if season_id:
            try:
                per90 = await p.get_statistics_season_per_90(season_id=season_id)
                return per90
            except AttributeError:
                return {"per90": {}}
        return {"per90": {}}
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

@router.get("/player/{player_id}/form")
async def get_player_form(player_id: int):
    """Get recent form for a player."""
    try:
        api = await get_api()
        p = Player(api, player_id=player_id)
        form = await p.get_form()
        return form
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))
