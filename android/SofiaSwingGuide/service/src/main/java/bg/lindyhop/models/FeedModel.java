package bg.lindyhop.models;

import java.util.List;

import bg.lindyhop.dao.FeedItemDao;
import bg.lindyhop.entities.FeedItem;

/**
 * Created by mmironov on 12/23/15.
 */
public class FeedModel {

    private static FeedModel instance;
    private final FeedItemDao dao;

    private FeedModel() {
        dao = DbHelper.getInstance().getDaoSession().getFeedItemDao();
    }

    public static FeedModel getInstance() {

        if (instance == null) {
            instance = new FeedModel();
        }

        return instance;
    }

    public void insertOrReplaceAll(List<FeedItem> posts) {
        dao.insertOrReplaceInTx(posts);
    }

    public FeedItem getLastFeedItem() {
        return dao.queryBuilder().where(FeedItemDao.Properties.ServerId.isNotNull())
                .orderDesc(FeedItemDao.Properties.CreatedAt)
                .limit(1).unique();
    }

    public List<FeedItem> getFeedItems() {
        return dao.queryBuilder().orderDesc(FeedItemDao.Properties.CreatedAt).list();
    }
}
