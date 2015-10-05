from django.db import models

from django_countries.fields import CountryField


class Event(models.Model):
    name = models.CharField(max_length=64, blank=False, null=False)
    description = models.TextField()

    # Organizerid

    country = CountryField()
    city = models.CharField(max_length=32, blank=True, null=False)

    people = models.ManyToManyField('members.Person', through='EventPerson', through_fields=('event', 'person'), related_name='events')

    from_date = models.DateTimeField()
    to_date = models.DateTimeField()

    def __str__(self):
        return '{}'.format(self.name)


class EventPerson(models.Model):

    TEACHER = 'T'
    STUDENT = 'S'
    DJ = 'D'
    GUEST = 'G'

    PERSON_TYPE = (
        (TEACHER, 'Teacher'),
        (STUDENT, 'Student'),
        (DJ, 'DJ'),
        (GUEST, 'Guest')
    )

    event = models.ForeignKey('Event', related_name='person')
    person = models.ForeignKey('members.Person', related_name='event')
    type = models.CharField(max_length=1, choices=PERSON_TYPE, default=STUDENT)
