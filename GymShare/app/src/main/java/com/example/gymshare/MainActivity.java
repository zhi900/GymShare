package com.example.gymshare;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.GeoPoint;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    TabLayout mainTab;
    SupportMapFragment supportMapFragment;
    GoogleMap map;

    LatLng latLng;
    private Location destinationLocation;
    private Marker userMarker;
    private Marker destinationMarker;
    private Location userLocation;
    FusedLocationProviderClient client;
    private static final int REQUEST_CODE = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mainTab = findViewById(R.id.mainTab);
        mainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        break;
                }
            }
        });


    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.map = googleMap;

        LatLng nyc = new LatLng(40.6976701, -74.2598767);
        map.addMarker(new MarkerOptions()
                .position(new LatLng(40.6976701, -74.2598767))
                .title("Jon's Garage Gym"));

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(nyc,10));
    }
}