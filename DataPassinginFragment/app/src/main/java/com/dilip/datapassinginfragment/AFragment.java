package com.dilip.datapassinginfragment;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class AFragment extends Fragment {

    // Constants representing the keys for the arguments bundle
    private static final String ARG1 = "argument1";
    private static final String ARG2 = "argument2";

    // Default constructor required for instantiating the fragment
    public AFragment() {
        // Required empty public constructor
    }

    // Static factory method to create an instance of AFragment with provided arguments
    public static AFragment getInstance(String val1, int val2){
        AFragment aFragment = new AFragment();

        // Create a new bundle to hold the arguments
        Bundle bundle = new Bundle();
        // Put the string and integer arguments into the bundle
        bundle.putString(ARG1, val1);
        bundle.putInt(ARG2, val2);

        // Set the arguments bundle to the fragment
        aFragment.setArguments(bundle);

        // Return the new fragment instance with arguments
        return aFragment;
    }

    // This method is unnecessary as getArguments() is a built-in method, should be removed
    private void getArguments(Bundle bundle) {
    }

    // Called to have the fragment instantiate its user interface view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Check if the fragment was created with arguments
        if (getArguments() != null){
            // Retrieve the arguments from the bundle
            String name = getArguments().getString(ARG1);
            int age = getArguments().getInt(ARG2);

            // Log the values retrieved from the arguments
            Log.d("Values from Act", "Name is " + name + ", Age is " + age);

            ((MainActivity) getActivity()).CallFromFragment();
        }

        // Inflate the layout for this fragment and return the view
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
}
