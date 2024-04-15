package com.dilip.roomlibrarydemo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenseDao {

    /**
     * Retrieve all expenses from the database.
     *
     * @return A list of all expenses.
     */
    @Query("SELECT * FROM expense")
    List<Expense> getAllExpense();

    /**
     * Add a new transaction (expense) to the database.
     *
     * @param expense The expense to be added.
     */
    @Insert
    void addTx(Expense expense);

    /**
     * Update an existing transaction (expense) in the database.
     *
     * @param expense The updated expense.
     */
    @Update
    void updateTx(Expense expense);

    /**
     * Delete a transaction (expense) from the database.
     *
     * @param expense The expense to be deleted.
     */
    @Delete
    void deleteTx(Expense expense);
}
