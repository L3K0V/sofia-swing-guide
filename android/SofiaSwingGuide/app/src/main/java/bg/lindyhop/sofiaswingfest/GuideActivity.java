package bg.lindyhop.sofiaswingfest;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.geojson.GeoJsonLayer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import bg.lindyhop.controllers.GuideController;
import bg.lindyhop.entities.GuideItem;

/**
 * Created by lekov on 1/19/16.
 */
public class GuideActivity extends AppCompatActivity implements OnMapReadyCallback {

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
    }

    @Override
    public void onMapReady(final GoogleMap map) {
        LatLng sydney = new LatLng(-34, 151);
        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        new Thread(new Runnable() {
            @Override
            public void run() {
                GuideItem result = GuideController.getInstance().loadGuide();

                try {
                    final JSONObject obj = new JSONObject();
                    obj.put("type", result.getType());
                    obj.put("features", new JSONArray(result.getGeo()));

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            GeoJsonLayer guideLayer = new GeoJsonLayer(map, obj);
                            guideLayer.addLayerToMap();
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
