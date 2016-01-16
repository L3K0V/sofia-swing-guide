package bg.lindyhop.sofiaswingfest.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.path.android.jobqueue.JobManager;

import java.util.ArrayList;
import java.util.List;

import bg.lindyhop.entities.FeedItem;
import bg.lindyhop.entities.FeedItemsPage;
import bg.lindyhop.events.FetchedNewPostsEvent;
import bg.lindyhop.events.NoNewPostsEvent;
import bg.lindyhop.jobs.FetchFeedJob;
import bg.lindyhop.models.FeedModel;
import bg.lindyhop.sofiaswingfest.adapters.FeedAdapter;
import bg.lindyhop.sofiaswingfest.R;
import bg.lindyhop.sofiaswingfest.SofiaSwingFestApplication;
import bg.lindyhop.utils.Prefs;
import de.greenrobot.event.EventBus;

/**
 * Created by mmironov on 1/4/16.
 */
public class FeedFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    public static final String TAG = "FeedFragment";

    private int previousTotal = 0;
    private boolean loading = false;
    private int visibleThreshold = 0;
    private FeedAdapter adapter;
    int firstVisibleItem, visibleItemCount, totalItemCount;

    private SwipeRefreshLayout swipeRefreshLayout;

    private JobManager jobManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_feed, container, false);

        jobManager = SofiaSwingFestApplication.getInstance().getJobManager();

        Prefs.putNextPage(FeedItemsPage.FIRST_PAGE_INDEX);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(this);

        final RecyclerView feed = (RecyclerView) view.findViewById(R.id.feed);
        feed.setLayoutManager(new LinearLayoutManager(getActivity()));
        feed.setItemAnimator(new DefaultItemAnimator());
        feed.setHasFixedSize(true);

        adapter = new FeedAdapter(getActivity(), new ArrayList<FeedItem>());
        feed.setAdapter(adapter);
        feed.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                visibleItemCount = feed.getChildCount();
                totalItemCount = feed.getLayoutManager().getItemCount();
                firstVisibleItem = ((LinearLayoutManager) feed.getLayoutManager()).findFirstVisibleItemPosition();

                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                    }
                } else if (!loading && (totalItemCount - visibleItemCount)
                        <= (firstVisibleItem + visibleThreshold)) {

                    Log.i("SCROLL", "Load more...");

                    loading = true;
                    jobManager.addJobInBackground(new FetchFeedJob());
                }

            }
        });

        EventBus.getDefault().register(this);

        swipeRefreshLayout.setRefreshing(true);
        jobManager.addJobInBackground(new FetchFeedJob());

        return view;
    }

    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    @Override
    public void onRefresh() {
        Prefs.putNextPage(FeedItemsPage.FIRST_PAGE_INDEX);
        previousTotal = 0;
        jobManager.addJobInBackground(new FetchFeedJob());
        swipeRefreshLayout.setRefreshing(true);
    }

    public void onEventMainThread(FetchedNewPostsEvent event) {

        Log.i("EVENT", "Received");

        if (swipeRefreshLayout.isRefreshing()) {
            updateFeedUI();
            Log.i("EVENT", "Updating Feed");
            swipeRefreshLayout.setRefreshing(false);
        } else {
            addToFeedUI(event.getPosts());
            Log.i("EVENT", "Adding to Feed");
        }
    }

    public void onEventMainThread(NoNewPostsEvent event) {

    }

    private void updateFeedUI() {
        FeedModel feedModel = FeedModel.getInstance();
        List<FeedItem> feedItems = feedModel.getFeedItems();
        adapter.swapDataSet(feedItems);
    }

    private void addToFeedUI(List<FeedItem> posts) {
        adapter.add(posts);
    }
}
