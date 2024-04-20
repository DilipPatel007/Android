package com.dilip.roomlibrarydemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "expense")
public class Expense {
    @PrimaryKey(autoGenerate = true)
    private int id; // Unique identifier for each expense

    @ColumnInfo(name = "title")
    private String title; // Title or name of the expense (e.g., "Groceries")

    @ColumnInfo(name = "amount")
    private String amount; // Amount spent for the expense (e.g., "50.00")

    // Constructor with all fields (including ID)
    Expense(int id, String title, String amount) {
        this.id = id;
        this.title = title;
        this.amount = amount;
    }

    // Constructor without ID (for inserting new expenses)
    @Ignore
    Expense(String title, String amount) {
        this.title = title;
        this.amount = amount;
    }

    // Getter and setter methods for each field
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
