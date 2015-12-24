package bg.lindyhop.jobs;

import android.util.Log;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import com.path.android.jobqueue.RetryConstraint;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import bg.lindyhop.controllers.FeedController;
import bg.lindyhop.entities.FeedItem;
import bg.lindyhop.events.FetchedNewPostsEvent;
import bg.lindyhop.models.FeedModel;
import de.greenrobot.event.EventBus;

/**
 * Created by mmironov on 12/23/15.
 */
public class FetchFeedJob extends Job {

    private static AtomicInteger jobCounter = new AtomicInteger(0);

    private int id;

    public FetchFeedJob() {
        super(new Params(Priority.NORMAL).requireNetwork().groupBy("123"));
        id = jobCounter.incrementAndGet();
    }

    @Override
    public void onAdded() {
        Log.i("JOB", "Added");
    }

    @Override
    public void onRun() throws Throwable {

        Log.i("JOB", "Run");
        //More recent fetches have been requested.
        //Leave them do the job
        if (id != jobCounter.get()) {
            return;
        }

        FeedModel feedModel = FeedModel.getInstance();

        FeedItem lastFeedItem = feedModel.getLastFeedItem();

        Long sinceId = lastFeedItem == null ? null : lastFeedItem.getServerId();
        List<FeedItem> feedItems = FeedController.getInstance().loadFeed(sinceId);

        if (feedItems.size() > 0) {

            feedModel.insertOrReplaceAll(feedItems);
            EventBus.getDefault().post(new FetchedNewPostsEvent());
        }
    }

    @Override
    protected void onCancel() {

    }

    @Override
    protected RetryConstraint shouldReRunOnThrowable(Throwable throwable, int runCount,
                                                     int maxRunCount) {

        Log.i("EXCEPTION", throwable.getMessage());
        return RetryConstraint.RETRY;
    }
}
