package bg.lindyhop.jobs;

import android.util.Log;

import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;
import com.path.android.jobqueue.RetryConstraint;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import bg.lindyhop.controllers.FeedController;
import bg.lindyhop.entities.FeedItem;
import bg.lindyhop.entities.FeedItemsPage;
import bg.lindyhop.events.FetchedNewPostsEvent;
import bg.lindyhop.events.NoNewPostsEvent;
import bg.lindyhop.models.FeedModel;
import bg.lindyhop.utils.Prefs;
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

        if (!Prefs.hasNextPage()) {

            EventBus.getDefault().post(new NoNewPostsEvent());
        }
    }

    @Override
    public void onRun() throws Throwable {

        Log.i("JOB", "Run");
        //More recent fetches have been requested.
        //Leave them do the job
        if (id != jobCounter.get()) {
            return;
        }

        if (!Prefs.hasNextPage()) {
            return;
        }

        final int nextPage = Prefs.getNextPage();

        FeedModel feedModel = FeedModel.getInstance();

        if (nextPage == FeedItemsPage.FIRST_PAGE_INDEX) {
            feedModel.deleteAll();
        }

        FeedItemsPage feedItemsPage = FeedController.getInstance().loadFeed(nextPage);

        if (feedItemsPage.hasNextPage()) {
            Prefs.putNextPage(feedItemsPage.getNextPage());
        } else {
            Prefs.removeNextPage();
        }

        List<FeedItem> feedItems = feedItemsPage.getResults();

        if (feedItems.size() > 0) {

            Log.i("NEW ITEMS COUNT", String.valueOf(feedItems.size()));

            feedModel.insertOrReplaceAll(feedItems);
            EventBus.getDefault().post(new FetchedNewPostsEvent(feedItems));
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
