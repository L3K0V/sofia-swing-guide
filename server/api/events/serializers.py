from rest_framework import serializers

from api.events.models import Event


class EventSerializer(serializers.ModelSerializer):
    class Meta:
        model = Event
        fields = ('id', 'name', 'description', 'country', 'city', 'from_date', 'to_date')
