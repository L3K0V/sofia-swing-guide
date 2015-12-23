package bg.lindyhop;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mmironov on 12/23/15.
 */
public class Post {

    @SerializedName("id")
    private Long serverId;

    private String title;

    private String text;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Long getServerId() {
        return serverId;
    }
}
