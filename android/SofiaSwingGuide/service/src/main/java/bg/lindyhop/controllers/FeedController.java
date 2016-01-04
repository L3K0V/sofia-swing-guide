package bg.lindyhop.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import bg.lindyhop.entities.FeedItem;
import bg.lindyhop.entities.FeedItemsPage;
import bg.lindyhop.network.Config;
import bg.lindyhop.network.FeedService;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

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

    public FeedItemsPage loadFeed(int page) {

        if (page < 1) {
            return new FeedItemsPage();
        }

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        RestAdapter rest = new RestAdapter.Builder()
                                    .setEndpoint(Config.SERVER_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        FeedService service = rest.create(FeedService.class);

        return service.listPosts(page);
    }

    public FeedItemsPage loadFeed() {
        return loadFeed(FeedItemsPage.FIRST_PAGE_INDEX);
    }
}
