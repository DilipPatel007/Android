package com.dilip.googlemapsdemo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

// MainActivity class that extends AppCompatActivity and implements OnMapReadyCallback interface
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    // Variable to hold the GoogleMap instance
    private GoogleMap myMap;

    // onCreate method is the first method that gets called when the activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Sets the user interface layout for this Activity
        setContentView(R.layout.activity_main);

        // Finding the map fragment by its ID and getting it ready for use
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        // Asynchronously gets the map ready for use
        mapFragment.getMapAsync(this);
    }

    // This method is triggered when the map is ready to be used
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        // Assigning the GoogleMap instance to the variable myMap
        myMap = googleMap;

        // Creating a LatLng object with coordinates for Vadodara, Gujarat, India
        LatLng vadodara = new LatLng(22.2994, 73.2081);
        // Adding a marker on the map at the Vadodara location with a title
        MarkerOptions markerOptions = new MarkerOptions().position(vadodara).title("Vadodara");

        myMap.addMarker(markerOptions);
        // Moving the camera view to focus on the Vadodara location
        myMap.moveCamera(CameraUpdateFactory.newLatLng(vadodara));
        // Animating the camera with a zoom level of 16.0f to get a closer view of Vadodara
        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(vadodara, 16f));

}
