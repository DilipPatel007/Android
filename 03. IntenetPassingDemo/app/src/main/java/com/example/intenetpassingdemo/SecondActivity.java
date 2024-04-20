package com.example.intenetpassingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        // Get the intent that started this activity
        Intent fromAct = getIntent();

        // Extract data from the intent
        String title = fromAct.getStringExtra("title");
        String studentName = fromAct.getStringExtra("studentName");
        int rollNo = fromAct.getIntExtra("Roll No", 0);

        // Find the TextView to display student information
        TextView tvStudentInfo = findViewById(R.id.txtStudentInfo);

        // Set the student information text
        tvStudentInfo.setText("Name: " + studentName + ", Roll No: " + rollNo);

        // Set the action bar title
        getSupportActionBar().setTitle(title);
    }
}

//        The SecondActivity class displays student information received from the previous activity.
//        We extract data (student name and roll number) from the intent using getStringExtra and getIntExtra.
//        The extracted data is displayed in a TextView.
//        The action bar title is set based on the provided title.
//        Comments have been added to explain each section of the code.
