package com.mastercoding.viewpagerapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewpager;
    MyViewPagerAdapter myadapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);

        //The getsupportfragmentmanager provides an instiance for a fragment manager
        // keeps track of fragments dynamically

        // gets a reference to teh lifecycle of the fragment like oncreate.
        // gets a reference to all lifecycles of the fragment class.
        myadapter = new MyViewPagerAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        // adding the fragments to the list in the adpater class
        myadapter.addFragment(new Fragment1());
        myadapter.addFragment(new Fragment2());
        myadapter.addFragment(new Fragment3());

        // set the orientation in viewpager 2
        viewpager = findViewById(R.id.viewPager2);
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        //connecting the adapter with the viewpager2
        viewpager.setAdapter(myadapter);

        // connecting tablayout with viewpager
        new TabLayoutMediator(
                tabLayout,
                viewpager,
//                (tab, position) -> {
//
//                }
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText("Fragment "+(position +1));
                    }
                }
        ).attach();

    }
}