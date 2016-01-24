package bg.lindyhop.sofiaswingfest;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.geojson.GeoJsonLayer;
import com.path.android.jobqueue.JobManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import bg.lindyhop.entities.Guide;
import bg.lindyhop.events.FetchedGuideEvent;
import bg.lindyhop.jobs.FetchGuideJob;
import bg.lindyhop.models.GuideModel;
import de.greenrobot.event.EventBus;

/**
 * Created by lekov on 1/19/16.
 */
public class GuideActivity extends AppCompatActivity implements OnMapReadyCallback {

    private JobManager manager;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
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
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        this.map = map;

        LatLng sydney = new LatLng(-34, 151);
        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));


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

            map.animateCamera(CameraUpdateFactory.newLatLngBounds(guideLayer.getBoundingBox(), 5));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
