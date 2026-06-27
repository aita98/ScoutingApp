from django.urls import path
from . import views

urlpatterns = [
    path("search", views.search_player),
    path("player/<int:player_id>", views.get_player),
    path("player/<int:player_id>/statistics", views.get_player_stats),
    path("player/<int:player_id>/events", views.get_player_events),
    path("player/<int:player_id>/per-90", views.get_player_per90),
]
