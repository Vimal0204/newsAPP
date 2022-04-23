package com.example.newsnaut;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter1 extends FragmentPagerAdapter {


    int tabcount1;

    public PagerAdapter1(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount1=behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
                case 0:
                return new HomeFragment1();
                case 1:
                return new SportsFragment1();
                case 2:
                return new HealthFragment1();
                case 3:
                return new ScienceFragment1();
                case 4:
                return new EntertainmentFragment1();
                case 5:
                return new TechnologyFragment1();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount1;
    }
}
