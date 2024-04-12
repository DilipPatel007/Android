package com.dilip.databasedemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an instance of our MyDBHelper class
        MyDBHelper dbHelper = new MyDBHelper(this);

//        dbHelper.addContact("Dilip", "5556454656");
//        dbHelper.addContact("Raman", "4545451545");
//        dbHelper.addContact("Darshan", "31433444");
//        dbHelper.addContact("Vraj", "6848768482");
//        dbHelper.addContact("Dhruv", "6449599455");

// Create a new ContactModel instance
        ContactModel model = new ContactModel();
        model.id = 1;
        model.name = "Dilip";
        model.phone_no = "1234567890";
// Update the contact with the specified model
        dbHelper.updateContact(model);

// Delete the contact with ID 2
        dbHelper.deleteContact(2);

        // Fetch contacts from the database
        ArrayList<ContactModel> arrContacts = dbHelper.fetchContact();

        // Loop through the contacts and print them to the log
        for (int i = 0; i < arrContacts.size(); i++) {
            Log.d("CONTACT_INFO", "Name: " + arrContacts.get(i).name
                    + ", Phone No: " + arrContacts.get(i).phone_no);
        }

        // Get a reference to the ListView element
        ListView listView = findViewById(R.id.listView);

        // Create a ContactAdapter object to manage the list data
        ContactAdapter adapter = new ContactAdapter(this, arrContacts);
        // Set the adapter on the ListView
        listView.setAdapter(adapter);


//        ArrayAdapter<ContactModel> adapter = new ArrayAdapter<>(
//                MainActivity.this, android.R.layout.simple_list_item_1, arrContacts);
//        listView.setAdapter(adapter);
    }
}
