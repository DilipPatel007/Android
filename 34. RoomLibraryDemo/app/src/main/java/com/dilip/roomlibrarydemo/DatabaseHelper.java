package com.dilip.roomlibrarydemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Expense.class, exportSchema = false, version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    private static final String DB_NAME = "expenseDB"; // Name of the database
    private static DatabaseHelper instance; // Singleton instance of the database

    /**
     * Get an instance of the database (singleton pattern).
     *
     * @param context The application context.
     * @return The database instance.
     */
    public static synchronized DatabaseHelper getDB(Context context) {
        if (instance == null) {
            // Create the database instance if it doesn't exist
            instance = Room.databaseBuilder(context, DatabaseHelper.class, DB_NAME)
                    .fallbackToDestructiveMigration() // Recreate the database if schema changes
                    .allowMainThreadQueries() // Allow database operations on the main thread (for simplicity)
                    .build();
        }
        return instance;
    }

    /**
     * Get the DAO (Data Access Object) for expense operations.
     *
     * @return The expense DAO.
     */
    public abstract ExpenseDao expenseDao();
}
