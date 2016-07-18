package bg.lindyhop.network;


import bg.lindyhop.entities.FeedItemsPage;
import retrofit.http.GET;
import retrofit.http.Query;

public interface FeedService {

    @GET("/feed")
    FeedItemsPage listPosts(@Query("page") int page);
}
