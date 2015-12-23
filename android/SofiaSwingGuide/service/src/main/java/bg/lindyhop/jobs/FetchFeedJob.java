package bg.lindyhop.jobs;

import android.renderscript.RenderScript;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

import java.util.concurrent.atomic.AtomicInteger;

import bg.lindyhop.models.FeedModel;

/**
 * Created by mmironov on 12/23/15.
 */
public class FetchFeedJob extends Job {

    private static AtomicInteger jobCounter = new AtomicInteger(0);

    private int id;

    public FetchFeedJob() {
        super(new Params(Priority.NORMAL).requireNetwork().groupBy(null));
        id = jobCounter.incrementAndGet();
    }

    @Override
    public void onAdded() {

    }

    @Override
    public void onRun() throws Throwable {

        //More recent fetches have been requested.
        //Leave them do the job
        if (id != jobCounter.get()) {
            return;
        }

        FeedModel feedModel = FeedModel.getInstance();
    }

    @Override
    protected void onCancel() {

    }
}
