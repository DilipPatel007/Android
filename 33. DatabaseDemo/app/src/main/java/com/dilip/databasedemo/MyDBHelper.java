 package com.dilip.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {

    // Database information
    private static final String DATABASE_NAME = "ContactsDB";
    private static final int DATABASE_VERSION = 1;

    // Table information
    private static final String TABLE_CONTACT = "Contacts";

    // Table column names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE_NUMBER = "phone_no";

    public MyDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // This method is called when the database is first created
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a SQL statement to create the Contacts table
        String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_CONTACT + "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +  // Auto-incrementing ID
                KEY_NAME + " TEXT, " +                               // Name column
                KEY_PHONE_NUMBER + " TEXT" +                          // Phone number column
                ")";

        // Execute the SQL statement to create the table
        db.execSQL(CREATE_TABLE_QUERY);
    }

    // This method is called when the database version is upgraded
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // If the database version is changed, drop the existing table and recreate it
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACT);
        onCreate(db);
    }

    // Add a new contact to the database
    public void addContact(String name, String phone_no) {
        // Get a writable database instance
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a ContentValues object to store the data to be inserted
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_PHONE_NUMBER, phone_no);

        // Insert the contact data into the Contacts table
        db.insert(TABLE_CONTACT, null, values);

        // Close the database connection
        // db.close();
    }

    // Fetch all contacts from the database
    public ArrayList<ContactModel> fetchContact() {

        // Get a readable database instance
        SQLiteDatabase db = this.getReadableDatabase();

        // Create a SQL query to select all data from the Contacts table
        String SELECT_QUERY = "SELECT * FROM " + TABLE_CONTACT;

        // Execute the query and store the results in a Cursor object
        Cursor cursor = db.rawQuery(SELECT_QUERY, null);

        // Create an empty ArrayList to store the ContactModel objects
        ArrayList<ContactModel> arrContacts = new ArrayList<>();

        // Loop through each row in the Cursor
        while (cursor.moveToNext()) {
            // Create a new ContactModel object
            ContactModel model = new ContactModel();

            // Extract data from the current row of the Cursor
            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.phone_no = cursor.getString(2);

            // Add the ContactModel object to the ArrayList
            arrContacts.add(model);
        }

        // Close the cursor (important to release resources)
        cursor.close();

        // Return the ArrayList containing all contact information
        return arrContacts;
    }

    public void updateContact(ContactModel contactModel) {
        // Get a writable database instance
        SQLiteDatabase db = this.getWritableDatabase();

        // Create a ContentValues object to store the updated phone number
        ContentValues values = new ContentValues();
        values.put(KEY_PHONE_NUMBER, contactModel.phone_no);

        // Update the contact record with the new phone number
        db.update(TABLE_CONTACT, values, KEY_ID + " = " + contactModel.id, null);
    }

    public void deleteContact(int id) {
        // Get a writable database instance
        SQLiteDatabase db = this.getWritableDatabase();

        // Delete the contact record with the specified ID
        db.delete(TABLE_CONTACT, KEY_ID + " = ? ", new String[]{String.valueOf(id)});
    }


}



//        The MyDBHelper class extends SQLiteOpenHelper and manages the database creation and version management.
//        In onCreate, we create the Contacts table with columns for id, name, and phone_no.
//        In onUpgrade, we drop the existing table if it exists and recreate it.
//        The addContact method inserts a new contact into the table.
//        fetchContact: Fetches all contacts from the database and returns them as a list