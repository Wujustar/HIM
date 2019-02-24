package com.example.class10.helloitsme.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.class10.helloitsme.R;
import com.example.class10.helloitsme.adapter.NotificationViewPagerAdapter;

public class NotificationFragment extends Fragment {

    ViewPager noti_viewPager;
    NotificationViewPagerAdapter notificationViewPagerAdapter;
    TabLayout noti_tabLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        noti_viewPager = (ViewPager) view.findViewById(R.id.noti_viewPager);
        notificationViewPagerAdapter = new NotificationViewPagerAdapter(getChildFragmentManager());
        noti_viewPager.setAdapter(notificationViewPagerAdapter);
        noti_tabLayout = (TabLayout) view.findViewById(R.id.noti_tabLayout);
        noti_viewPager.setCurrentItem(1);
        noti_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(noti_tabLayout));
        noti_tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                noti_viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }
}
