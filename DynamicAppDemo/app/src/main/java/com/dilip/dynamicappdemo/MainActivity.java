package com.dilip.dynamicappdemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Declare a list to hold user names retrieved from the API
    private ArrayList<String> userNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge mode for the activity
        EdgeToEdge.enable(this);

        // Set the activity layout
        setContentView(R.layout.activity_main);

        // Set padding based on system bars to avoid content overlapping
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the reference to the ListView
        ListView listView = findViewById(R.id.listView);

        // Define the URL to fetch user data
        String url = "https://jsonplaceholder.typicode.com/users"; // GET

        // Initialize the AndroidNetworking library
        AndroidNetworking.initialize(this);

        // Send a GET request to the API
        AndroidNetworking.get(url)
                .setPriority(Priority.HIGH) // Set request priority to high
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        Log.d("RES", jsonArray.toString()); // Log the response for debugging

                        // Parse the JSON response
                        try {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject objResult = jsonArray.getJSONObject(i);
                                String name = objResult.getString("name");

                                // Add the name to the userNames list
                                userNames.add(name);
                            }

                            // Create a new adapter with the collected user names
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                                    android.R.layout.simple_list_item_1, userNames);

                            // Set the adapter on the ListView to display the data
                            listView.setAdapter(adapter);
                        } catch (JSONException e) {
                            throw new RuntimeException(e); // Handle parsing errors
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("RES", anError.toString()); // Log the error for debugging
                    }
                });
    }
}

//    Class Declaration and Initialization:
//        The MainActivity class extends AppCompatActivity, which is the base class for activities in Android.
//        Inside the class, you declare an ArrayList<String> called userNames to store the retrieved user names.
//    onCreate() Method:
//        This method is called when the activity is created.
//        It initializes the activity layout, sets padding to avoid content overlapping with system bars, and enables edge-to-edge mode.
//        The setContentView(R.layout.activity_main) line sets the layout for the activity (defined in activity_main.xml).
//        The ViewCompat.setOnApplyWindowInsetsListener block adjusts padding based on system bars (status bar and navigation bar).
//    Fetching User Data from API:
//        The URL for fetching user data is defined as "https://jsonplaceholder.typicode.com/users".
//        The AndroidNetworking library is initialized using AndroidNetworking.initialize(this).
//        A GET request is sent to the API using AndroidNetworking.get(url).
//        The priority of the request is set to high with .setPriority(Priority.HIGH).
//        The response is handled using getAsJSONArray(new JSONArrayRequestListener()).
//    Response Handling:
//        In the onResponse(JSONArray jsonArray) method:
//        The JSON response is logged for debugging (Log.d("RES", jsonArray.toString())).
//        The response is parsed using a loop to extract user names.
//        Each user name is added to the userNames list.
//        An ArrayAdapter is created with the collected user names.
//        The adapter is set on the ListView (listView.setAdapter(adapter)).
//        In case of an error, the onError(ANError anError) method logs the error.
//    Note:
//        If there are parsing errors (e.g., invalid JSON), a RuntimeException is thrown.
//        Ensure that the necessary permissions (e.g., internet permission) are declared in the AndroidManifest.xml file.