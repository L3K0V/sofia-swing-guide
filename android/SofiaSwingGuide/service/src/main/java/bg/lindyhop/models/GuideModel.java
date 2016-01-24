package bg.lindyhop.models;

import java.util.List;

import bg.lindyhop.dao.GuideDao;
import bg.lindyhop.entities.Guide;

/**
 * Created by lekov on 1/24/16.
 */
public class GuideModel {
    private static GuideModel instance;
    private final GuideDao dao;

    private GuideModel() {
        dao = DbHelper.getInstance().getDaoSession().getGuideDao();
    }

    public static GuideModel getInstance() {

        if (instance == null) {
            instance = new GuideModel();
        }

        return instance;
    }

    public void insertOrReplace(Guide guide) {
        dao.insertOrReplace(guide);
    }

    public void deleteAll() {
        dao.deleteAll();
    }

    public List<Guide> getGuide() {
        return dao.queryBuilder().list();
    }
}
