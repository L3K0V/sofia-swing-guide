from rest_framework import viewsets

from api.feed.models import FeedItem
from api.feed.serializers import FeedItemSerializer


class FeedViewSet(viewsets.ModelViewSet):
    """
    This viewset automatically provides `list` and `detail` actions.
    """
    queryset = FeedItem.objects.all()
    serializer_class = FeedItemSerializer
