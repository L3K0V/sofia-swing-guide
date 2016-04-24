package bg.lindyhop.network;

import bg.lindyhop.entities.Guide;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by lekov on 1/24/16.
 */
public interface GuideService {

    @GET("/events/{eventId}/guide/")
    Guide listGuideItems(@Path("eventId") long eventId);
}
