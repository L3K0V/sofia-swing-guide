"""swing URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.8/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Add an import:  from blog import urls as blog_urls
    2. Add a URL to urlpatterns:  url(r'^blog/', include(blog_urls))
"""
from django.conf.urls import include, url
from django.contrib import admin

from rest_framework.routers import DefaultRouter

from rest_framework_nested import routers

from api.events.views import EventViewSet, EventPersonViewSet, EventTrackViewSet, EventTrackLevelViewSet

router = routers.DefaultRouter()
router.register(r'events', EventViewSet, base_name='events')

event_router = routers.NestedSimpleRouter(router, r'events', lookup='event')
event_router.register(r'tracks', EventTrackViewSet, base_name='tracks')

tracks_router = routers.NestedSimpleRouter(event_router, r'tracks', lookup='track')
tracks_router.register(r'levels', EventTrackLevelViewSet, base_name='levels')

urlpatterns = [
    url(r'^', include(router.urls)),
    url(r'^', include(event_router.urls)),
    url(r'^', include(tracks_router.urls)),
    url(r'^admin/', include(admin.site.urls)),
]
