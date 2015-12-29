package bg.lindyhop.sofiaswingfest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.path.android.jobqueue.JobManager;

import java.util.ArrayList;
import java.util.List;

import bg.lindyhop.entities.FeedItem;
import bg.lindyhop.events.FetchedNewPostsEvent;
import bg.lindyhop.jobs.FetchFeedJob;
import bg.lindyhop.models.FeedModel;
import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SwipeRefreshLayout.OnRefreshListener {

    private int previousTotal = 0;
    private boolean loading = false;
    private int visibleThreshold = 5;
    private FeedAdapter adapter;
    int firstVisibleItem, visibleItemCount, totalItemCount;

    private SwipeRefreshLayout swipeRefreshLayout;

    private JobManager jobManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        jobManager = SofiaSwingFestApplication.getInstance().getJobManager();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        swipeRefreshLayout.setOnRefreshListener(this);

        final RecyclerView feed = (RecyclerView) findViewById(R.id.feed);
        feed.setLayoutManager(new LinearLayoutManager(this));
        feed.setHasFixedSize(true);

        adapter = new FeedAdapter(new ArrayList<String>());
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
                        swipeRefreshLayout.setRefreshing(loading);
                        previousTotal = totalItemCount;
                    }
                }
                if (!loading && (totalItemCount - visibleItemCount)
                        <= (firstVisibleItem + visibleThreshold)) {

                    adapter.add("More...");
                    recyclerView.getAdapter().notifyDataSetChanged();

                    loading = true;
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });

        updateFeedUI();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_feed) {
            // Handle the camera action
        } else if (id == R.id.nav_schedule) {

        } else if (id == R.id.nav_teachers) {

        } else if (id == R.id.nav_parties) {

        } else if (id == R.id.nav_competitions) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onRefresh() {
        jobManager.addJobInBackground(new FetchFeedJob());
    }

    public void onEventMainThread(FetchedNewPostsEvent event) {

        Log.i("EVENT", "Received");

        updateFeedUI();

        swipeRefreshLayout.setRefreshing(false);
    }

    private void updateFeedUI() {
        FeedModel feedModel = FeedModel.getInstance();

        List<FeedItem> feedItems = feedModel.getFeedItems();
        List<String> dataset = new ArrayList<String>();

        for(FeedItem feedItem : feedItems) {
            dataset.add(feedItem.getTitle());
        }

        adapter.swapDataSet(dataset);
    }
}
