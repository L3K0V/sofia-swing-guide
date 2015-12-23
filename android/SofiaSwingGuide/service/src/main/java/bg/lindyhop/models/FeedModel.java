package bg.lindyhop.models;

import java.util.List;

import bg.lindyhop.Post;

/**
 * Created by mmironov on 12/23/15.
 */
public class FeedModel {

    private static FeedModel instance;

    private FeedModel() {

    }

    public static FeedModel getInstance() {

        if (instance != null) {
            instance = new FeedModel();
        }

        return instance;
    }
}
