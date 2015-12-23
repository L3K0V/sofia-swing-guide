package bg.lindyhop.models;

import java.util.ArrayList;
import java.util.List;

import bg.lindyhop.Post;

/**
 * Created by mmironov on 12/23/15.
 */
public class FeedModel {

    private List<Post> posts;

    private static FeedModel instance;

    private FeedModel() {
        posts = new ArrayList<Post>();
    }

    public static FeedModel getInstance() {

        if (instance == null) {
            instance = new FeedModel();
        }

        return instance;
    }

    public void insertOrReplaceAll(List<Post> posts) {
        this.posts = posts;
    }

    //TODO: implement
    public Post getLastPost() {
        return new Post();
    }

    public List<Post> getPosts() {
        return posts;
    }
}
