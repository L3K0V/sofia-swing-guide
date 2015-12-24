package bg.lindyhop;

import android.app.Application;

import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.log.CustomLogger;

/**
 * Created by lekov on 12/24/15.
 */
public class App extends Application {

    private static App instance;

    private static JobManager jobManager;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        configureJobManager();
    }

    public static App getInstance() {
        return instance;
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
        )
                .minConsumerCount(1)//always keep at least one consumer alive
                .maxConsumerCount(3)//up to 3 consumers at a time
                .loadFactor(3)//3 jobs per consumer
                .consumerKeepAlive(120)
                .build();

        jobManager = new JobManager(this, config);
    };

    public JobManager getJobManager() {
        return jobManager;
    }
}
