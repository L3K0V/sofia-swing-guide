package bg.lindyhop.controllers;

import bg.lindyhop.entities.AuthToken;
import bg.lindyhop.entities.FeedItemsPage;
import bg.lindyhop.network.AuthTokenService;
import bg.lindyhop.network.Config;
import bg.lindyhop.network.FeedService;
import bg.lindyhop.network.ServiceGenerator;

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

        AuthTokenService tokenService = ServiceGenerator.createService(AuthTokenService.class,
                Config.CLIENT_ID, Config.CLIENT_SECRET);

        AuthToken token = tokenService.obtainToken(Config.GRANT_TYPE);

        FeedService service = ServiceGenerator.createService(FeedService.class, token);

        return service.listPosts(page);
    }

    public FeedItemsPage loadFeed() {
        return loadFeed(FeedItemsPage.FIRST_PAGE_INDEX);
    }
}
