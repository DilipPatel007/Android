package com.dilip.smsdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<String> {

    public MyListAdapter(Context context, ArrayList<String> messages) {
        super(context, R.layout.list_item_layout, messages); //
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_layout, parent, false);
        }

        TextView messageTextView = (TextView) itemView.findViewById(R.id.message_text);

        String message = getItem(position);
        messageTextView.setText(message);

        return itemView;
    }
}
