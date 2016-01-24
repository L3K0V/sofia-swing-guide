package bg.lindyhop.network;

import bg.lindyhop.entities.GuideItem;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by lekov on 1/24/16.
 */
public interface GuideService {

    @GET("/events/{eventId}/guides/")
    GuideItem listGuideItems(@Path("eventId") long eventId);
}
