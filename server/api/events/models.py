from django.db import models

from django_countries.fields import CountryField


class Event(models.Model):
    name = models.CharField(max_length=64, blank=False, null=False)
    description = models.TextField()

    # Organizerid

    country = CountryField()
    city = models.CharField(max_length=32, blank=True, null=False)

    from_date = models.DateTimeField()
    to_date = models.DateTimeField()
