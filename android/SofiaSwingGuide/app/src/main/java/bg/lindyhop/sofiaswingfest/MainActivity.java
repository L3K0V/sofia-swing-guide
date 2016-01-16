package bg.lindyhop.sofiaswingfest;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.path.android.jobqueue.JobManager;

import bg.lindyhop.entities.FeedItemsPage;
import bg.lindyhop.sofiaswingfest.fragments.FeedFragment;
import bg.lindyhop.sofiaswingfest.fragments.TeachersFlipFragment;
import bg.lindyhop.sofiaswingfest.fragments.TeachersFragment;
import bg.lindyhop.utils.Prefs;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new FeedFragment(), FeedFragment.TAG, false);
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
            replaceFragment(new FeedFragment(), FeedFragment.TAG, false);
        } else if (id == R.id.nav_schedule) {

        } else if (id == R.id.nav_teachers) {
            replaceFragment(new TeachersFragment(), TeachersFragment.TAG, false);
        } else if (id == R.id.nav_parties) {

        } else if (id == R.id.nav_competitions) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void addFragment(Fragment fragment, String tag, boolean addToBackStack) {

        FragmentTransaction tr = getSupportFragmentManager().beginTransaction();

        tr.add(R.id.main_container, fragment, tag);

        if (addToBackStack) {
            tr.addToBackStack(null);
        }

        tr.commit();
    }

    private void replaceFragment(Fragment fragment, String tag, boolean addToBackStack) {

        FragmentTransaction tr = getSupportFragmentManager().beginTransaction();

        tr.replace(R.id.main_container, fragment, tag);

        if (addToBackStack) {
            tr.addToBackStack(null);
        }

        tr.commit();
    }
}
