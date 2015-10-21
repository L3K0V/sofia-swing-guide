from rest_framework_gis.serializers import GeoFeatureModelSerializer

from api.guide.models import GuideItem


class GuideItemSerializer(GeoFeatureModelSerializer):

    class Meta:
        depth = 1
        model = GuideItem
        geo_field = "point"
        id_field = False
        fields = ('id', 'name', 'description', 'address', 'city', 'state', 'hours')
