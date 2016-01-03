package bg.lindyhop.network;


import java.util.List;

import bg.lindyhop.entities.FeedItem;
import bg.lindyhop.entities.FeedItemsPage;
import retrofit.http.GET;
import retrofit.http.Path;

public interface FeedService {

    @GET("/feed")
    FeedItemsPage listPosts();
}
