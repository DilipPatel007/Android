package com.example.recyclerviewdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    // Create an ArrayList to store contact data
    ArrayList<ContactModel> arrContacts = new ArrayList<>();

    RecyclerContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the RecyclerView in the layout by its ID
        RecyclerView recyclerView = findViewById(R.id.recyclerContact);

        // Set a LinearLayoutManager for the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Add sample contact data to the ArrayList
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "A", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "B", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "C", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "D", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "E", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "F", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "G", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "H", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "I", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "J", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "K", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "L", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "M", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "N", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "O", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "P", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "Q", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "R", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "S", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "T", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "U", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "V", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "W", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "X", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "Y", "954585665"));
        arrContacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "Z", "954585665"));

        // Create an adapter and pass the context and contact data
        adapter = new RecyclerContactAdapter(this, arrContacts);

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(adapter);
    }
}