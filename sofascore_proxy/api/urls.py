from django.urls import path
from . import views

urlpatterns = [
    path("resolve/<str:name>", views.resolve_player),
    path("stats/<str:fbref_id>/<str:slug>", views.get_fbref_stats),
    path("stats/combined/<str:tm_id>/<str:fbref_id>/<str:fbref_slug>", views.get_combined_player_stats, name="combined_stats"),
    path("bridge", views.bridge),
]
