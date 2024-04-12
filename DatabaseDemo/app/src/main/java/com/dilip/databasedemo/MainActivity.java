package com.dilip.databasedemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MyDBHelper dbHelper = new MyDBHelper(this);

        dbHelper.addContact("Dilip", "5556454656");
        dbHelper.addContact("Raman", "4545451545");
        dbHelper.addContact("Darshan", "31433444");
        dbHelper.addContact("Vraj", "6848768482");
        dbHelper.addContact("Dhruv", "6449599455");



    }
}