from rest_framework import serializers

from api.events.models import Event, EventPerson


class EventSerializer(serializers.ModelSerializer):
    class Meta:
        model = Event
        fields = ('id', 'name', 'description', 'country', 'city', 'from_date', 'to_date')


class EventPersonSerializer(serializers.ModelSerializer):
    class Meta:
        model = EventPerson
        fields = ('id', 'person', 'event', 'type')
