from fastapi import APIRouter
from sofascore_wrapper.api import SofascoreAPI
from sofascore_wrapper.search import Search
from sofascore_wrapper.player import Player

router = APIRouter()
api = SofascoreAPI()

@router.get("/search")
async def search_player(query: str):
    s = Search(api, search_string=query)
    result = await s.search_all()
    return result

@router.get("/player/{player_id}")
async def get_player(player_id: int):
    p = Player(api, player_id)
    return await p.get_info()

@router.get("/player/{player_id}/stats")
async def get_player_stats(player_id: int):
    p = Player(api, player_id)
    return await p.get_statistics()

@router.get("/player/{player_id}/per-90")
async def get_player_per90(player_id: int):
    p = Player(api, player_id)
    return await p.get_per90()

@router.get("/player/{player_id}/form")
async def get_player_form(player_id: int):
    p = Player(api, player_id)
    return await p.get_form()
