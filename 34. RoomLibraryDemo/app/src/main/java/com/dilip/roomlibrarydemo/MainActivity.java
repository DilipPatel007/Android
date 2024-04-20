package com.dilip.roomlibrarydemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    // UI elements
    EditText edtTitle, edtAmount;
    Button btnAdd, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        edtTitle = findViewById(R.id.edtTitle);
        edtAmount = findViewById(R.id.edtAmount);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);

        // Get a database helper instance
        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);

        // List view for displaying expenses
        ListView lvExpense = findViewById(R.id.lvExpense);

        // Create an ArrayList to store expense data
        ArrayList<Expense> expenseList = new ArrayList<>();

        // Initialize your custom adapter
        ExpenseAdapter expenseAdapter = new ExpenseAdapter(this, expenseList);
        lvExpense.setAdapter(expenseAdapter);

        // Add click listener for btnAdd
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString();
                String amount = edtAmount.getText().toString();

                // Input validation
                if (title.isEmpty()) {
                    // Show a toast message if the name field is empty
                    Toast.makeText(getApplicationContext(), "Please enter a name", Toast.LENGTH_SHORT).show();
                    return; // Exit the method early
                }

                if (amount.isEmpty()) {
                    // Show a toast message if the amount field is empty
                    Toast.makeText(getApplicationContext(), "Please enter an amount", Toast.LENGTH_SHORT).show();
                    return; // Exit the method early
                }

                // Add expense to database
                databaseHelper.expenseDao().addTx(new Expense(title, amount));

                // Retrieve all expenses from database
                ArrayList<Expense> arrExpenses = (ArrayList<Expense>) databaseHelper.expenseDao().getAllExpense();

                // Update adapter data
                expenseList.clear();
                expenseList.addAll(arrExpenses);
                expenseAdapter.notifyDataSetChanged();
            }
        });
    }
}
