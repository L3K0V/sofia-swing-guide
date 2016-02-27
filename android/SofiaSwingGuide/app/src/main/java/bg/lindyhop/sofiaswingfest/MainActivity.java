package bg.lindyhop.sofiaswingfest;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import bg.lindyhop.sofiaswingfest.R;
import bg.lindyhop.sofiaswingfest.fragments.CompetitionsFragment;
import bg.lindyhop.sofiaswingfest.fragments.ContactClickCallbacks;
import bg.lindyhop.sofiaswingfest.fragments.ContactsFragment;
import bg.lindyhop.sofiaswingfest.fragments.FeedFragment;
import bg.lindyhop.sofiaswingfest.fragments.ScheduleFragment;
import bg.lindyhop.sofiaswingfest.fragments.TeachersFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ContactClickCallbacks {

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
            replaceFragment(new ScheduleFragment(), ScheduleFragment.TAG, false);
        } else if (id == R.id.nav_teachers) {
            replaceFragment(new TeachersFragment(), TeachersFragment.TAG, false);
        } else if (id == R.id.nav_parties) {

        } else if (id == R.id.nav_competitions) {
            replaceFragment(new CompetitionsFragment(), CompetitionsFragment.TAG, false);
        } else if (id == R.id.nav_contact) {
            replaceFragment(new ContactsFragment(), ContactsFragment.TAG, false);
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

    @Override
    public void handleFacebookPage(View v) {
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment instanceof ContactClickCallbacks) {
                ContactClickCallbacks callbacks = (ContactClickCallbacks) fragment;
                callbacks.handleFacebookPage(v);
                break;
            }
        }
    }

    @Override
    public void handleWebPage(View v) {
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment instanceof ContactClickCallbacks) {
                ContactClickCallbacks callbacks = (ContactClickCallbacks) fragment;
                callbacks.handleWebPage(v);
                break;
            }
        }
    }

    @Override
    public void handleEmail(View v) {
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment instanceof ContactClickCallbacks) {
                ContactClickCallbacks callbacks = (ContactClickCallbacks) fragment;
                callbacks.handleEmail(v);
                break;
            }
        }
    }

    @Override
    public void handlePhone(View v) {
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment instanceof ContactClickCallbacks) {
                ContactClickCallbacks callbacks = (ContactClickCallbacks) fragment;
                callbacks.handlePhone(v);
                break;
            }
        }
    }
}
