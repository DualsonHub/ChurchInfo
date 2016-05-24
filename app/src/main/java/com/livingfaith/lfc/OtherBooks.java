package com.livingfaith.lfc;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class OtherBooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_books);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout1);
        tabLayout.addTab(tabLayout.newTab().setText("Online Stores"));
        tabLayout.addTab(tabLayout.newTab().setText("Offline Stores"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(OtherBooks.this)
                        // .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("List your stores:")
                        .setMessage( "Contact Email: shops.listing.here@gmail.com \n" + "Phone: 08138667392")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }

                        })
                        .setNegativeButton("", null)
                        .show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager1);
        final PageAdapter2 adapter = new PageAdapter2(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
