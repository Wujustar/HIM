package com.example.class10.helloitsme.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.class10.helloitsme.fragment.NotificatioinChildFragment;

public class NotificationViewPagerAdapter extends FragmentPagerAdapter {
    String num[] = {"1페이지", "2페이지"};
    public NotificationViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        return NotificatioinChildFragment.newInstance(num[i]);
    }


    @Override
    public int getCount() {
        return 2;
    }
}
