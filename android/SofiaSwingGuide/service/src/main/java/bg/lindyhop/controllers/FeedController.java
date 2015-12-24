package bg.lindyhop.controllers;

import java.util.List;

import bg.lindyhop.entities.FeedItem;
import bg.lindyhop.network.Config;
import bg.lindyhop.network.FeedService;
import retrofit.RestAdapter;

/**
 * Created by mmironov on 12/23/15.
 */
public class FeedController {

    private static FeedController instance;

    public static FeedController getInstance() {

        if (instance == null) {
            instance = new FeedController();
        }

        return instance;
    }

    public List<FeedItem> loadFeed(Long sinceId) {

        RestAdapter rest = new RestAdapter.Builder()
                                    .setEndpoint(Config.SERVER_URL)
                                    .build();

        FeedService service = rest.create(FeedService.class);

        return service.listPosts(0, 0);
    }
}
