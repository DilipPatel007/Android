package com.example.listdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
//    int[] arrNos = new int[]{1, 2, 3, 4, 5};
    ArrayList<String> arrNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "Dilip is clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}