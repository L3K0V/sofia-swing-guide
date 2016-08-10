package bg.lindyhop.sofiaswingfest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.geojson.GeoJsonLayer;
import com.path.android.jobqueue.JobManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import bg.lindyhop.entities.Guide;
import bg.lindyhop.events.FetchedGuideEvent;
import bg.lindyhop.jobs.FetchGuideJob;
import bg.lindyhop.models.GuideModel;
import bg.lindyhop.sofiaswingfest.adapters.GuideAdapter;
import de.greenrobot.event.EventBus;


/**
 * Created by lekov on 1/19/16.
 */
public class GuideActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private JobManager manager;
    private GoogleMap map;
    private GoogleApiClient googleApiClient;

    private GuideAdapter adapter;
    private RecyclerView guide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        CollapsingToolbarLayout collapsing = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsing.setExpandedTitleTextAppearance(R.style.transperant);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        AppBarLayout mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mAppBarLayout.getLayoutParams();
        AppBarLayout.Behavior behavior = new AppBarLayout.Behavior();
        behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
            @Override
            public boolean canDrag(AppBarLayout appBarLayout) {
                return false;
            }
        });
        params.setBehavior(behavior);

        EventBus.getDefault().register(this);

        manager = SofiaSwingFestApplication.getInstance().getJobManager();

        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        guide = (RecyclerView) findViewById(R.id.guide);
        guide.setLayoutManager(new LinearLayoutManager(this));
        guide.setItemAnimator(new DefaultItemAnimator());
        guide.setHasFixedSize(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        googleApiClient.connect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (googleApiClient.isConnected()) {
            googleApiClient.disconnect();
        }
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        this.map = map;
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                System.out.println(marker.toString());
                return true;
            }
        });
        manager.addJobInBackground(new FetchGuideJob());
    }


    public void onEventMainThread(FetchedGuideEvent event) {
        GuideModel model = GuideModel.getInstance();

        try {
            final JSONObject obj = new JSONObject();
            final Guide guideItem = model.getGuide().get(0);

            obj.put("type", guideItem.getType());
            obj.put("features", new JSONArray(guideItem.getGeo()));

            GeoJsonLayer guideLayer = new GeoJsonLayer(map, obj);
            guideLayer.addLayerToMap();
            guide.setAdapter(new GuideAdapter(guideItem));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);

        if (location != null) {
            handleNewLocation(location);
        }
    }

    private void handleNewLocation(Location location) {
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 15));
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
