package com.mooracle.smellslikecooking;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // crete the lis fragment object:
        ListFragment fragment = new ListFragment();

        // create fragment manager to add our fragment into place holder:
        //this is the latest app support fragment manager since the old getFragmentManager method has beed deprecated
        FragmentManager fragmentManager = getSupportFragmentManager();

        // create the fragment transaction variable:
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.placeHolder, fragment);
        fragmentTransaction.commit();
    }
}
