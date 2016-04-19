package com.mieczkowskidev.fancygmaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

public class ClassicMapActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapLoadedCallback {

    public static final String TAG = ClassicMapActivity.class.getSimpleName();

    protected GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_map);

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

        googleMap.setOnMapLoadedCallback(this);
    }

    @Override
    public void onMapLoaded() {
        Log.d(TAG, "onMapLoaded()");

    }
}
