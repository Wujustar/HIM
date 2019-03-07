package com.example.class10.helloitsme.adapter;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.class10.helloitsme.fragment.ContactFragment;
import com.example.class10.helloitsme.fragment.HomeFragment;
import com.example.class10.helloitsme.fragment.MoreFragment;
import com.example.class10.helloitsme.fragment.NotificationFragment;

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    int tabCount;
    public MainViewPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){

            case 0 :
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;

            case 1 :
                ContactFragment contactFragment = new ContactFragment();
                return contactFragment;



            case 2 :
                NotificationFragment notificationFragment = new NotificationFragment();
                return notificationFragment;



            default :
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }


}


