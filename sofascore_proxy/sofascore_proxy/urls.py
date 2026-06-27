from django.urls import path, include

urlpatterns = [
    path("sofascore/", include("api.urls")),
]
