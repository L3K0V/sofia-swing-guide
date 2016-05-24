package bg.lindyhop.entities;

/**
 * Created by mmironov on 5/23/16.
 */
public class ScheduleItem {

    private String title;
    private String description;

    private String timeInterval;

    public ScheduleItem() {
        this("", "", "");
    }

    public ScheduleItem(String title, String description, String timeInterval) {
        this.title = title;
        this.description = description;
        this.timeInterval = timeInterval;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }
}
