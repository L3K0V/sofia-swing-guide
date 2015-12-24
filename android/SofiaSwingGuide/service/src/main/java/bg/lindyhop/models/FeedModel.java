package bg.lindyhop.models;

import java.util.ArrayList;
import java.util.List;

import bg.lindyhop.entities.FeedItem;

/**
 * Created by mmironov on 12/23/15.
 */
public class FeedModel {

    private List<FeedItem> feedItems;

    private static FeedModel instance;

    private FeedModel() {
        feedItems = new ArrayList<FeedItem>();
    }

    public static FeedModel getInstance() {

        if (instance == null) {
            instance = new FeedModel();
        }

        return instance;
    }

    public void insertOrReplaceAll(List<FeedItem> posts) {
        this.feedItems = posts;
    }

    //TODO: implement
    public FeedItem getLastFeedItem() {
        return new FeedItem();
    }

    public List<FeedItem> getFeedItems() {
        return feedItems;
    }
}
