from django.db import models
from django.contrib.auth.models import User

from django_countries.fields import CountryField


class Member(models.Model):
    user = models.OneToOneField(User, related_name="member")
    country = CountryField()
