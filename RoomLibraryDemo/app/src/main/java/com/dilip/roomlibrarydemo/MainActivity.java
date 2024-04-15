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

    EditText edtTitle, edtAmount;
    Button btnAdd, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTitle = findViewById(R.id.edtTitle);
        edtAmount = findViewById(R.id.edtAmount);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);

        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);

        ListView lvExpense = findViewById(R.id.lvExpense);

// Create an ArrayList to store expense data
        ArrayList<Expense> expenseList = new ArrayList<>();

// Initialize your custom adapter (you'll need to create this adapter)
        ExpenseAdapter expenseAdapter = new ExpenseAdapter(this, expenseList);
        lvExpense.setAdapter(expenseAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtTitle.getText().toString();
                String amount = edtAmount.getText().toString();

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

                // Add the transaction to the database
                databaseHelper.expenseDao().addTx(new Expense(title, amount));

                // Retrieve all expenses from the database
                ArrayList<Expense> arrExpenses = (ArrayList<Expense>) databaseHelper.expenseDao().getAllExpense();

                // Clear the existing data and add the new data to the adapter
                expenseList.clear();
                expenseList.addAll(arrExpenses);

                // Notify the adapter that the data has changed
                expenseAdapter.notifyDataSetChanged();
            }
        });

    }
}