from django.shortcuts import render

from rest_framework import viewsets

from api.events.models import Event
from api.events.serializers import EventSerializer


class EventViewSet(viewsets.ModelViewSet):
    """
    This viewset automatically provides `list` and `detail` actions.
    """
    queryset = Event.objects.all()
    serializer_class = EventSerializer
