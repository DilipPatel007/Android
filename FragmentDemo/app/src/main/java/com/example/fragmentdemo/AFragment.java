package com.example.fragmentdemo;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class AFragment extends Fragment {

    public AFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);

//        // Find the TextView with the ID "textFrag"
//        TextView textFrag = view.findViewById(R.id.textFrag);

        // Return the inflated view
        return view;
    }

}

