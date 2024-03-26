package com.example.spinnerdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    // Declare views
    ListView listView;
    Spinner spinner;
    AutoCompleteTextView actxtView;

    //    int[] arrNos = new int[]{1, 2, 3, 4, 5};
    // ArrayLists for names, IDs, and languages
    ArrayList<String> arrNames = new ArrayList<>();
    ArrayList<String> arrIds = new ArrayList<>();
    ArrayList<String> arrLanguages = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        listView = findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        actxtView = findViewById(R.id.actxtView);

        // Add names to the list
        arrNames.add("Dilip");
        arrNames.add("Ram");
        arrNames.add("Raju");
        arrNames.add("Sita");
        arrNames.add("Krishna");
        arrNames.add("Gita");
        arrNames.add("Amit");
        arrNames.add("Priya");
        arrNames.add("Vikram");
        arrNames.add("Anjali");
        arrNames.add("Rahul");
        arrNames.add("Neha");
        arrNames.add("Ravi");
        arrNames.add("Pooja");
        arrNames.add("Sandeep");
        arrNames.add("Kavita");
        arrNames.add("Rajesh");
        arrNames.add("Meera");
        arrNames.add("Vijay");
        arrNames.add("Shalini");

        // Set adapter for the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrNames);
        listView.setAdapter(adapter);

        // Set item click listener for the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "Dilip is clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // Spinner
        arrIds.add("Voter Id Card");
        arrIds.add("Aadhaar Card");
        arrIds.add("Pan Card");
        arrIds.add("Driving licence Card");
        arrIds.add("Ration Card");
        arrIds.add("Xth score Card");
        arrIds.add("XIIth score Card");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrIds);
        spinner.setAdapter(spinnerAdapter);


        // AutoCompleteTextView
        arrLanguages.add("Arabic");
        arrLanguages.add("Bengali");
        arrLanguages.add("Chinese");
        arrLanguages.add("Dutch");
        arrLanguages.add("English");
        arrLanguages.add("French");
        arrLanguages.add("German");
        arrLanguages.add("Gujarati");
        arrLanguages.add("Hindi");
        arrLanguages.add("Italian");
        arrLanguages.add("Japanese");
        arrLanguages.add("Korean");
        arrLanguages.add("Latin");
        arrLanguages.add("Malayalam");
        arrLanguages.add("Norwegian");
        arrLanguages.add("Odia");
        arrLanguages.add("Portuguese");
        arrLanguages.add("Quechua");
        arrLanguages.add("Russian");
        arrLanguages.add("Spanish");
        arrLanguages.add("Tamil");
        arrLanguages.add("Urdu");
        arrLanguages.add("Vietnamese");
        arrLanguages.add("Welsh");
        arrLanguages.add("Xhosa");
        arrLanguages.add("Yoruba");
        arrLanguages.add("Zulu");

        ArrayAdapter<String> actvAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrLanguages);
        actxtView.setAdapter(actvAdapter);
        actxtView.setThreshold(1);
    }

}

