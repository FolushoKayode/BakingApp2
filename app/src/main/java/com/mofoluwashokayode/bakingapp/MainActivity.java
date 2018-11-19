package com.mofoluwashokayode.bakingapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.mofoluwashokayode.bakingapp.R;
import com.mofoluwashokayode.bakingapp.fragments.MainActivityFragment;

public class MainActivity extends AppCompatActivity {

    public static boolean isTablet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            if (findViewById(R.id.tablet_view) != null) {
                isTablet = true;
                FragmentManager fragmentManager = getSupportFragmentManager();
                MainActivityFragment bakesFragment = new MainActivityFragment();
                fragmentManager.beginTransaction()
                        .add(R.id.tablet_view, bakesFragment)
                        .commit();
            } else {
                FragmentManager fragmentManager = getSupportFragmentManager();
                MainActivityFragment bakesFragment = new MainActivityFragment();
                fragmentManager.beginTransaction()
                        .add(R.id.phone_view, bakesFragment)
                        .commit();
            }
        }


    }


}

