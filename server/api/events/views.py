from django.shortcuts import render

from rest_framework import viewsets

from api.events.models import Event, EventPerson, EventTrack, EventTrackLevel
from api.events.serializers import EventSerializer, EventPersonSerializer, EventTrackSerializer, EventTrackLevelSerializer


class EventViewSet(viewsets.ModelViewSet):
    """
    This viewset automatically provides `list` and `detail` actions.
    """
    queryset = Event.objects.all()
    serializer_class = EventSerializer


class EventPersonViewSet(viewsets.ModelViewSet):
    """
    This viewset automatically provides `list` and `detail` actions.
    """
    queryset = EventPerson.objects.all()
    serializer_class = EventPersonSerializer


class EventTrackViewSet(viewsets.ModelViewSet):
    queryset = EventTrack.objects.all()
    serializer_class = EventTrackSerializer


class EventTrackLevelViewSet(viewsets.ModelViewSet):
    queryset = EventTrackLevel.objects.all()
    serializer_class = EventTrackLevelSerializer
