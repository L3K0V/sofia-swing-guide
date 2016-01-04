package bg.lindyhop.events;

import java.util.List;

import bg.lindyhop.entities.FeedItem;
import retrofit.http.POST;

/**
 * Created by mmironov on 12/23/15.
 */
public class FetchedNewPostsEvent {

    private List<FeedItem> newPosts;

    public FetchedNewPostsEvent(List<FeedItem> newPosts) {
        this.newPosts = newPosts;
    }

    public List<FeedItem> getPosts() {
        return newPosts;
    }
}
