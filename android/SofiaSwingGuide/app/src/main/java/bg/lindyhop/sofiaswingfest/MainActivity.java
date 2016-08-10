package bg.lindyhop.sofiaswingfest;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import bg.lindyhop.sofiaswingfest.fragments.CompetitionsFragment;
import bg.lindyhop.sofiaswingfest.fragments.ContactClickCallbacks;
import bg.lindyhop.sofiaswingfest.fragments.ContactsFragment;
import bg.lindyhop.sofiaswingfest.fragments.FeedFragment;
import bg.lindyhop.sofiaswingfest.fragments.PartiesFragment;
import bg.lindyhop.sofiaswingfest.fragments.ScheduleFragment;
import bg.lindyhop.sofiaswingfest.fragments.TeachersFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ContactClickCallbacks {

    private static final int REQUEST_LOCATION_PERMISSION = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new FeedFragment(), FeedFragment.TAG, false);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                Snackbar.make(navigationView, "Location permissions are needed for guide", Snackbar.LENGTH_INDEFINITE).show();

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
            }
        }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_feed) {
            replaceFragment(new FeedFragment(), FeedFragment.TAG, true);
        } else if (id == R.id.nav_teachers) {
            replaceFragment(new TeachersFragment(), TeachersFragment.TAG, true);
        } else if (id == R.id.nav_parties) {
            replaceFragment(new PartiesFragment(), PartiesFragment.TAG, true);
        } else if (id == R.id.nav_schedule) {
            replaceFragment(new ScheduleFragment(), ScheduleFragment.TAG, true);
        } else if (id == R.id.nav_competitions) {
            replaceFragment(new CompetitionsFragment(), CompetitionsFragment.TAG, true);
        } else if (id == R.id.nav_contact) {
            replaceFragment(new ContactsFragment(), ContactsFragment.TAG, true);
        } else if (id == R.id.nav_places) {
            startActivity(new Intent(this, GuideActivity.class));
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
