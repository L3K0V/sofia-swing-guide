from rest_framework import viewsets
from rest_framework import filters

from api.feed.models import FeedItem
from api.feed.serializers import FeedItemSerializer
from api.feed.filters import FeedItemFilter


class FeedViewSet(viewsets.ModelViewSet):
    """
    This viewset automatically provides `list` and `detail` actions.
    """
    queryset = FeedItem.objects.all()
    serializer_class = FeedItemSerializer
    filter_backends = (filters.DjangoFilterBackend,)
    filter_class = FeedItemFilter
