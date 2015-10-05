from django.shortcuts import render

from rest_framework import viewsets

from api.events.models import Event, EventPerson
from api.events.serializers import EventSerializer, EventPersonSerializer


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
