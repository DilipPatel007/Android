package com.dilip.databasedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {

    // The context of the activity
    private Context context;

    // The list of contacts to be displayed
    private ArrayList<ContactModel> arrContacts;

    // Constructor to initialize context and contact list
    public ContactAdapter(Context context, ArrayList<ContactModel> arrContacts) {
        this.context = context;
        this.arrContacts = arrContacts;
    }

    // This method returns the total number of items in the adapter (list size)
    @Override
    public int getCount() {
        return arrContacts.size();
    }

    // This method returns the specific contact object at a given position in the list
    @Override
    public Object getItem(int position) {
        return arrContacts.get(position);
    }

    // This method is rarely used, but should return a unique ID for each list item
    // In this case, we return the position itself
    @Override
    public long getItemId(int position) {
        return position;
    }

    // This is the most important method in the adapter class
    // It's responsible for inflating the layout for each list item
    // and populating it with data from the corresponding ContactModel object
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is available for reuse (convertView)
        if (convertView == null) {
            // If not, inflate the layout for this item from list_item_contact.xml
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_contact, parent, false);
        }

        // Get references to the TextView elements in the list item layout
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvPhoneNo = convertView.findViewById(R.id.tvPhoneNo);

        // Get the ContactModel object for the current position
        ContactModel contact = arrContacts.get(position);

        // Set the text of the TextViews with data from the ContactModel object
        tvName.setText(contact.name);
        tvPhoneNo.setText(contact.phone_no);

        // Return the populated view
        return convertView;
    }
}


//    Class Definition:
//        public class ContactAdapter extends BaseAdapter: The ContactAdapter class inherits from BaseAdapter.
//    Instance Variables:
//        private Context context: An instance variable to store the application context.
//        private ArrayList<ContactModel> arrContacts: An array list to hold ContactModel objects.
//    Constructor:
//        The constructor initializes the context and arrContacts variables with the provided values.
//    Adapter Methods:
//        getCount(): Returns the total number of items in the adapter (size of arrContacts).
//        getItem(int position): Returns the item at the specified position (from arrContacts).
//        getItemId(int position): Returns the unique ID for the item at the given position.
//        getView(int position, View convertView, ViewGroup parent): Creates and returns a view for the item at the specified position. If convertView is null, it inflates a layout (R.layout.list_item_contact) and initializes the TextView widgets with data from the corresponding ContactModel.
//    Usage:
//        This adapter is typically used with a ListView or GridView to display a list of contacts. It binds the data from arrContacts to the UI elements in the specified layout (list_item_contact.xml).