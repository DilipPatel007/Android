package com.example.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * This class creates an adapter to be used with a RecyclerView to display a list of contacts.
 */
public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    /**
     * The context of the application.
     */
    Context context;

    /**
     * An ArrayList of ContactModel objects that represents the data to be displayed in the RecyclerView.
     */
    ArrayList<ContactModel> arrContacts;

    /**
     * This constructor initializes the context and the ArrayList of ContactModel objects.
     *
     * @param context  The context of the application.
     * @param arrContacts The ArrayList of ContactModel objects containing the contact data.
     */
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts){
        this.context = context;
        this.arrContacts = arrContacts;
    }

    /**
     * This method is called by the RecyclerView layout manager to create a new ViewHolder.
     *
     * @param parent   The ViewGroup that holds the RecyclerView.
     * @param viewType  The view type of the new view.
     * @return A new ViewHolder that holds the views for a single contact item.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /**
     * This method is called by the RecyclerView to bind the data to the views of a ViewHolder at a specific position.
     *
     * @param holder   The ViewHolder that holds the views for the contact item.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtName.setText(arrContacts.get(position).name);
        holder.txtNumber.setText(arrContacts.get(position).number);

        setAnimation(holder.itemView, position);

    }

    /**
     * This method returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in the ArrayList of ContactModel objects.
     */
    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    /**
     * This class represents a single ViewHolder that holds the views for a contact item.
     */
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtNumber;
        ImageView imgContact;

        /**
         * This constructor initializes the views for the contact item.
         *
         * @param itemView The view that represents a single contact item.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.imgContact);
        }
    }

    public void setAnimation(View viewToAnimate, int position) {
        Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        viewToAnimate.setAnimation(slideIn);
    }


}


//        This Java class is an adapter for a RecyclerView in an Android app.
//        It populates the RecyclerView with a list of contacts (ContactModel) and displays their names, phone numbers, and images.
//        Let’s go through the key parts:
//        Constructor: The constructor initializes the adapter with a context and an array of ContactModel objects.
//        onCreateViewHolder: Inflates the layout for each contact row (R.layout.contact_row) and creates a new ViewHolder.
//        onBindViewHolder: Binds data (contact image, name, and number) to the ViewHolder.
//        getItemCount: Returns the total number of contacts in the list.
//        ViewHolder class: Holds references to UI elements (text views and image view) within each contact row.

