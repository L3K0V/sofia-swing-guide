package bg.lindyhop.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mmironov on 1/3/16.
 */
public class FeedItemsPage {

    public static final int FIRST_PAGE_INDEX = 1;

    private int count;
    private String next;
    private String previous;

    private List<FeedItem> results;

    public FeedItemsPage() {
        results = new ArrayList<FeedItem>();
    }

    public List<FeedItem> getResults() {
        return results;
    }

    public boolean hasNextPage() {
        return next != null;
    }

    public int getNextPage() {

        final int eqIndex = next.lastIndexOf("=");
        final String pageString = next.substring(eqIndex + 1);

        final int page = Integer.parseInt(pageString);

        return page;
    }
}
