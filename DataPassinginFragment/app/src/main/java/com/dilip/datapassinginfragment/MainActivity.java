package com.dilip.datapassinginfragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private static final int ROOT_FRAGMENT_TAG = 9;
    Button btnFragA, btnFragB, btnFragC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragA = findViewById(R.id.btnFragA);
        btnFragB = findViewById(R.id.btnFragB);
        btnFragC = findViewById(R.id.btnFragC);

        // Default opening Frag
        loadFrag(new BFragment(),0);

        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFrag(new AFragment(),1);
            }
        });

        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFrag(new BFragment(),1);
            }
        });

        btnFragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFrag(new CFragment(),1);
            }
        });

    }
    public void loadFrag(Fragment fragment, int flag) {
        // Get the FragmentManager
        FragmentManager fm = getSupportFragmentManager();

        // Begin a new FragmentTransaction
        FragmentTransaction ft = fm.beginTransaction();

        if (flag == 0) {
            // Add the specified fragment to the container (R.id.container)
            ft.add(R.id.container, fragment);
            fm.popBackStack(ROOT_FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE); // This line removes all the fragment transactions from the back stack that occur after the one with the tag ROOT_FRAGMENT_TAG.
            // The FragmentManager.POP_BACK_STACK_INCLUSIVE flag indicates that the transaction with the tag ROOT_FRAGMENT_TAG is also to be removed
        } else {
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(String.valueOf(ROOT_FRAGMENT_TAG)); // This line adds the transaction to the back stack with a tag derived from ROOT_FRAGMENT_TAG.
            // This allows users to navigate backward through the fragment transactions by pressing the back button
        }

        // Commit the transaction to apply the changes
        ft.commit();
    }

}