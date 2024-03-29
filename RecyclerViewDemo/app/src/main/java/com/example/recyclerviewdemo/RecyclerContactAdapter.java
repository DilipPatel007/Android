package com.example.recyclerviewdemo;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    // Declare variables
    Context context;
    ArrayList<ContactModel> arrContacts;

    // Constructor: Initializes the adapter with context and contact data
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts) {
        this.context = context;
        this.arrContacts = arrContacts;
    }

    // Create a ViewHolder for the RecyclerView
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each contact row
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);
        // Create a new ViewHolder with the inflated view
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // Bind data to the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // Set the contact image resource based on the position in the list
        holder.imgContact.setImageResource(arrContacts.get(position).img);
        // Set the contact name text
        holder.txtName.setText(arrContacts.get(position).name);
        // Set the contact number text
        holder.txtNumber.setText(arrContacts.get(position).number);

        // Handle click on a contact row
        holder.llrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the dialog with a theme for consistency
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_lay);

                // Initialize views with null checks
                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);
                TextView txtTitle = dialog.findViewById(R.id.txtTitle);

                if (edtName == null || edtNumber == null || btnAction == null || txtTitle == null) {
                    Log.e("TAG", "Error: Could not find views in dialog");
                    return;
                }

                // Set title and button text
                txtTitle.setText("Update Contact");
                btnAction.setText("Update");

                // Pre-fill EditTexts with existing data
                edtName.setText((arrContacts.get(position)).name);
                edtNumber.setText((arrContacts.get(position)).number);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = edtName.getText().toString();
                        String number = edtNumber.getText().toString();

                        if (!name.isEmpty() && !number.isEmpty()) {
                            arrContacts.set(position, new ContactModel(name, number));
                            notifyItemChanged(position);
                            dialog.dismiss();
                        }
                    }
                });

                dialog.show(); // Show the dialog
            }
        });

        // Long-click listener for contact row
        holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Show a confirmation dialog for contact deletion
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure you want to delete?")
                        .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Remove the contact from the list and update the RecyclerView
                                arrContacts.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // No action needed if user cancels deletion
                            }
                        });
                builder.show();

                return true; // Indicate that the long-click event is consumed
            }
        });
    }

    // Return the total number of contacts in the list
    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    // ViewHolder class to hold references to UI elements
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtNumber;
        ImageView imgContact;
        LinearLayout llrow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize UI elements from the contact_row layout
            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.imgContact);
            llrow = itemView.findViewById(R.id.llrow);
        }
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

//        MainActivity.this only works if you are in an inner class of MainActivity.
//        If you are in MainActivity itself, just use this.
//        If you are in another class entirely, you need to pass it an instance of a context from the Activity you are in.

