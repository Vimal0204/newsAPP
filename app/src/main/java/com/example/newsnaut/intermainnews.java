package com.example.newsnaut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class intermainnews extends AppCompatActivity {
    TabLayout tabLayout1;
    TabItem mhome1,mscience1,mhealth1,mentertainment1,mtechnology1,msports1;
    PagerAdapter1 pagerAdapter1;
    Toolbar mtoolbar1;
    String api="99120de0188446c0850bb52ce4257f54";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermainnews);
        mtoolbar1=findViewById(R.id.toolbar1);
        setSupportActionBar(mtoolbar1);

        mhome1=findViewById(R.id.home1);
        mhealth1=findViewById(R.id.health1);
        mscience1=findViewById(R.id.science1);
        msports1=findViewById(R.id.sports1);
        mentertainment1=findViewById(R.id.entertainment1);
        mtechnology1=findViewById(R.id.technology1);
        ViewPager viewPager1 = findViewById(R.id.fragmentcontainer1);
        tabLayout1 = findViewById(R.id.include1);

        pagerAdapter1= new PagerAdapter1(getSupportFragmentManager(),6);
        viewPager1.setAdapter(pagerAdapter1);
        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5){
                    pagerAdapter1.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));


    }
}