from django.urls import path, include

urlpatterns = [
    path("fbref/", include("api.urls")),
]
