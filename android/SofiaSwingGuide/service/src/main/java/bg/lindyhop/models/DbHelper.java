package bg.lindyhop.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import bg.lindyhop.App;
import bg.lindyhop.dao.DaoMaster;
import bg.lindyhop.dao.DaoSession;

/**
 * Created by lekov on 12/24/15.
 */
public class DbHelper {
    private static DbHelper instance;
    private DaoSession daoSession;
    private DaoMaster daoMaster;
    private SQLiteDatabase db;

    public synchronized static DbHelper getInstance() {
        if(instance == null) {
            instance = new DbHelper();
        }
        return instance;
    }

    public DbHelper() {
        Context context = App.getInstance().getApplicationContext();
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "twitter", null);
        db = devOpenHelper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public DaoMaster getDaoMaster() {
        return daoMaster;
    }

    public void release() {
        daoSession.clear();
        db.close();
    }
}
