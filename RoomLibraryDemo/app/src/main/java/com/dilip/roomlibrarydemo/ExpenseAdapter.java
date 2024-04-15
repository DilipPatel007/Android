package com.dilip.roomlibrarydemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ExpenseAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Expense> expenseList; // Your data source

    public ExpenseAdapter(Context context, ArrayList<Expense> expenseList) {
        this.context = context;
        this.expenseList = expenseList;
    }

    @Override
    public int getCount() {
        return expenseList.size();
    }

    @Override
    public Object getItem(int position) {
        return expenseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.expense_list_item, parent, false);
        }

        // Get the current expense item
        Expense expense = expenseList.get(position);

        // Bind data to views within the layout
        TextView tvTitle = convertView.findViewById(R.id.tvTitle); //
        TextView tvAmount = convertView.findViewById(R.id.tvAmount);

        tvTitle.setText(expense.getTitle());
        tvAmount.setText(expense.getAmount());

        return convertView;
    }
}
