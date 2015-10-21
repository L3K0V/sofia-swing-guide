from django.shortcuts import render
from django.shortcuts import get_object_or_404

from rest_framework import viewsets
from rest_framework import response
from rest_framework import status

from api.guide.models import GuideItem
from api.guide.serializers import GuideItemSerializer


class GuideItemViewSet(viewsets.ModelViewSet):
    queryset = GuideItem.objects.all()
    serializer_class = GuideItemSerializer
