package bg.lindyhop.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import bg.lindyhop.entities.FeedItem;
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

    public List<FeedItem> loadFeed(Long sinceId) {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
                .create();

        RestAdapter rest = new RestAdapter.Builder()
                                    .setEndpoint(Config.SERVER_URL)
                                    .setConverter(new GsonConverter(gson))
                                    .build();

        FeedService service = rest.create(FeedService.class);

        return service.listPosts(0, 0);
    }
}
