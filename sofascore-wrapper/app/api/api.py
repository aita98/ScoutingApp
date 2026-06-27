from fastapi import APIRouter
from app.api.endpoints import sofascore

api_router = APIRouter()
api_router.include_router(sofascore.router, prefix="/sofascore", tags=["sofascore"])
