package bg.lindyhop.network;


import java.util.List;

import bg.lindyhop.entities.FeedItem;
import retrofit.http.GET;
import retrofit.http.Path;

public interface FeedService {

    @GET("/orgs/{o_id}/events/{e_id}/posts")
    List<FeedItem> listPosts(@Path("o_id") int orgId, @Path("e_id") int eventId);
}
