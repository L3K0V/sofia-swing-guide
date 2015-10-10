from rest_framework import serializers

from api.events.models import Event, EventPerson, EventTrack, EventTrackLevel


class EventSerializer(serializers.ModelSerializer):
    class Meta:
        depth = 1
        model = Event
        fields = ('id', 'name', 'description', 'country', 'city', 'from_date', 'to_date', 'tracks')


class EventPersonSerializer(serializers.ModelSerializer):

    type = serializers.ChoiceField(
        choices=EventPerson.PERSON_TYPE,
        style={'base_template': 'radio.html', 'inline': 'true'}
    )

    class Meta:
        model = EventPerson
        fields = ('id', 'person', 'event', 'type')


class EventTrackSerializer(serializers.ModelSerializer):
        def create(self, validated_data):
            e = Event.objects.get(pk=self.context.get('event_pk'))
            return EventTrack.objects.create(event=e, **validated_data)

        class Meta:
            depth = 1
            model = EventTrack
            fields = ('id', 'name', 'type', 'levels')


class EventTrackLevelSerializer(serializers.ModelSerializer):
        class Meta:
            model = EventTrackLevel
            fields = ('id', 'name', 'capacity', 'level', 'track')
