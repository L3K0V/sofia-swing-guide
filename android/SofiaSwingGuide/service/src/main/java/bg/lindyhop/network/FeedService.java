package bg.lindyhop.network;


import java.util.List;

import bg.lindyhop.entities.FeedItem;
import bg.lindyhop.entities.FeedItemsPage;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface FeedService {

    @GET("/feed")
    FeedItemsPage listPosts(@Query("page") int page);
}
