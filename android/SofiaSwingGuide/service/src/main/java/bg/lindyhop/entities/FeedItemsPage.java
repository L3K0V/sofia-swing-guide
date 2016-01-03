package bg.lindyhop.entities;

import java.util.List;

/**
 * Created by mmironov on 1/3/16.
 */
public class FeedItemsPage {

    private int count;
    private String next;
    private String previous;

    private List<FeedItem> results;

    public List<FeedItem> getResults() {
        return results;
    }
}
