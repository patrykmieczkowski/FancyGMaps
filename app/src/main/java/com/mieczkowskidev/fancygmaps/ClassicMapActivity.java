package com.mieczkowskidev.fancygmaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClassicMapActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String TAG = ClassicMapActivity.class.getSimpleName();

    protected GoogleMap googleMap;

    private LatLng krakowLatLng = new LatLng(50.0568, 19.9519);
    private final int[] MAP_TYPES = {GoogleMap.MAP_TYPE_SATELLITE,
            GoogleMap.MAP_TYPE_NORMAL,
            GoogleMap.MAP_TYPE_HYBRID,
            GoogleMap.MAP_TYPE_TERRAIN,
            GoogleMap.MAP_TYPE_NONE};

    private int selectedMapType = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_map);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        initMap();
    }

    private void initMap() {
        MapFragment mapFragment = ((MapFragment) getFragmentManager().findFragmentById(R.id.fragment_classic_map));

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d(TAG, "onMapReady()");
        this.googleMap = googleMap;

        selectedMapTypeMethod(selectedMapType);
        googleMap.setTrafficEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(krakowLatLng, 10));
    }

    private void selectedMapTypeMethod(int selection) {
        googleMap.setMapType(MAP_TYPES[selection]);
    }

    @OnClick(R.id.map_type_button)
    public void setMapType() {
        if (selectedMapType == MAP_TYPES.length - 1)
            selectedMapType = -1;
        selectedMapType++;
        selectedMapTypeMethod(selectedMapType);
    }

}
