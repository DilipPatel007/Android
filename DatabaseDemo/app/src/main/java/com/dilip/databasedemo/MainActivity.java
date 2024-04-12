package com.dilip.databasedemo;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyDBHelper dbHelper = new MyDBHelper(this);

//        dbHelper.addContact("Dilip", "5556454656");
//        dbHelper.addContact("Raman", "4545451545");
//        dbHelper.addContact("Darshan", "31433444");
//        dbHelper.addContact("Vraj", "6848768482");
//        dbHelper.addContact("Dhruv", "6449599455");

        ArrayList<ContactModel> arrContacts = dbHelper.fetchContact();

        for (int i=0; i<arrContacts.size(); i++){
            Log.d("CONTACT_INFO","Name: " + arrContacts.get(i).name
                    + ", Phone No: " + arrContacts.get(i).phone_no);

        }



    }
}