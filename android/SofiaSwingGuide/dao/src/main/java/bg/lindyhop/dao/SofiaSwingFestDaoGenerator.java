package bg.lindyhop.dao;

import java.io.IOException;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class SofiaSwingFestDaoGenerator extends DaoGenerator {

    public SofiaSwingFestDaoGenerator() throws IOException {
    }

    public static void main(String[] args) {
        Schema schema = new Schema(1, "bg.lindyhop.entities");
        schema.setDefaultJavaPackageDao("bg.lindyhop.dao");
        schema.enableKeepSectionsByDefault();

        Entity event = schema.addEntity("Event");
        event.addLongProperty("localId").primaryKey().autoincrement();
        event.addLongProperty("serverId").unique();
        event.addDateProperty("createdAt");
        event.addDateProperty("updatedAt");

        event.addStringProperty("name");
        event.addStringProperty("description");
        event.addStringProperty("country");
        event.addStringProperty("city");
        event.addDateProperty("fromDate");
        event.addDateProperty("toDate");

        // FeedItem entitiy
        Entity feed = schema.addEntity("FeedItem");
        feed.addLongProperty("localId").primaryKey().autoincrement();
        feed.addLongProperty("serverId").unique();

        feed.addStringProperty("title");
        feed.addStringProperty("text");
        feed.addDateProperty("createdAt");
        feed.addDateProperty("updatedAt");

        feed.addStringProperty("coverUrl");

        Property eventId = feed.addLongProperty("eventId").getProperty();
        feed.addToOne(event, eventId);

        Entity feedUrl = schema.addEntity("FeedItemUrl");
        feedUrl.addIdProperty();
        feedUrl.addStringProperty("url");

        Property feedId = feed.addLongProperty("feedId").getProperty();
        feedUrl.addToOne(feed, feedId, "urls");

        try {
            new DaoGenerator().generateAll(schema, "service/src-gen/main/java", "service/src/main/java", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
