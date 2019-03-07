package com.example.class10.helloitsme.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.class10.helloitsme.fragment.ContactFragment;
import com.example.class10.helloitsme.fragment.HomeFragment;
import com.example.class10.helloitsme.fragment.NotificatioinChildFragment;
import com.example.class10.helloitsme.fragment.NotificatioinChildFragment1;
import com.example.class10.helloitsme.fragment.NotificatioinChildFragment2;

public class NotificationViewPagerAdapter extends FragmentPagerAdapter {
    String num[] = {"1페이지", "2페이지"};

    public NotificationViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

//        return NotificatioinChildFragment.newInstance(num[i]);

        switch (i) {

            case 0:
                NotificatioinChildFragment1 notificatioinChildFragment1 = new NotificatioinChildFragment1();
                return notificatioinChildFragment1;

            case 1:
                NotificatioinChildFragment2 notificatioinChildFragment2 = new NotificatioinChildFragment2();
                return notificatioinChildFragment2;

            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return 2;
    }
}
