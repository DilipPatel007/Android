package com.dilip.googlemapsdemo;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        LatLng vadodara = new LatLng(22.373301, 73.189537);

        LatLng sea = new LatLng(21.2994, 72.2081);

        LatLng point1 = new LatLng(22.3010, 73.2070); // North-West of Vadodara
        LatLng point2 = new LatLng(22.3010, 73.2092); // North-East of Vadodara
        LatLng point3 = new LatLng(22.2978, 73.2092); // South-East of Vadodara
        LatLng point4 = new LatLng(22.2978, 73.2070); // South-West of Vadodara


        // Adding a marker on the map at the Vadodara location with a title
        MarkerOptions markerOptions = new MarkerOptions().position(vadodara).title("Vadodara");
        myMap.addMarker(markerOptions);
        // Moving the camera view to focus on the Vadodara location
        myMap.moveCamera(CameraUpdateFactory.newLatLng(vadodara));
        // Animating the camera with a zoom level of 16.0f to get a closer view of Vadodara
        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(vadodara, 16f));

        // Circle
        myMap.addCircle(new CircleOptions()
                .center(point2)
                .radius(1000)
                .fillColor(Color.RED)
                .strokeColor(Color.DKGRAY));

        // Polygon
        myMap.addPolygon(new PolygonOptions()
                .add(sea, point1, point2, point3, point4)
//                .add(new LatLng(22.3109, 73.1926),  // North-West corner
//                        new LatLng(22.3109, 73.2236),  // North-East corner
//                        new LatLng(22.2704, 73.2236),  // South-East corner
//                        new LatLng(22.2704, 73.1926))  // South-West corner
                .strokeColor(Color.RED)  // Line color of the polygon
                .fillColor(Color.BLUE)); // Fill color of the polygon


//// Adding a ground overlay to the map
//        myMap.addGroundOverlay(new GroundOverlayOptions()
//                .position(point1, 1000f, 1000f) // Set the position with width and height in meters
//                .image(BitmapDescriptorFactory.fromResource(R.drawable.baseline_account_balance_wallet_24)) // Set the image for the overlay
//                .clickable(true)); // Make the overlay

        myMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        myMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                // Create a Geocoder instance to get the address from the clicked location
                Geocoder geocoder = new Geocoder(MainActivity.this);
                String address = "";
                try {
                    // Get the address from the latitude and longitude
                    List<Address> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                    if (addresses != null && !addresses.isEmpty()) {
                        address = addresses.get(0).getAddressLine(0);
                        Log.d("Addr",addresses.get(0).getAddressLine(0));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // Display the address as a Toast message
                Toast.makeText(MainActivity.this, "Clicked at: " + address, Toast.LENGTH_LONG).show();
            }
        });

    }
}