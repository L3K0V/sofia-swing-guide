package bg.lindyhop.sofiaswingfest;

import android.app.Application;

import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.log.CustomLogger;

/**
 * Created by mmironov on 12/23/15.
 */
public class SofiaSwingFestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        configureJobManager();
    }

    private void configureJobManager() {

        Configuration config = new Configuration.Builder(this).customLogger(
                new CustomLogger() {
                    @Override
                    public boolean isDebugEnabled() {
                        return BuildConfig.DEBUG;
                    }

                    @Override
                    public void d(String text, Object... args) {

                    }

                    @Override
                    public void e(Throwable t, String text, Object... args) {

                    }

                    @Override
                    public void e(String text, Object... args) {

                    }
                }
        ).build();
    };
}
