package bg.lindyhop.network;


import java.util.List;

import bg.lindyhop.Post;
import retrofit.http.GET;
import retrofit.http.Path;

public interface FeedService {

    @GET("/orgs/{o_id}/events/{e_id}/posts")
    List<Post> listPosts(@Path("o_id") int orgId, @Path("e_id") int eventId);
}
