package com.example.class10.helloitsme.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.class10.helloitsme.R;
import com.example.class10.helloitsme.adapter.NotificationViewPagerAdapter;

public class NotificationFragment extends Fragment {

    ViewPager noti_viewPager;
    NotificationViewPagerAdapter notificationViewPagerAdapter;
    TabLayout noti_tabLayout;
    static int pageNum = 0;

    //문제는 여기다
    public static void setPageNum(int pageNum) {
        Log.d("phase", "들어옴");
        NotificationFragment.pageNum = pageNum;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("phase", "노티 프레그먼트 크리에이트");
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        noti_viewPager = (ViewPager) view.findViewById(R.id.noti_viewPager);
        notificationViewPagerAdapter = new NotificationViewPagerAdapter(getChildFragmentManager());
        noti_viewPager.setAdapter(notificationViewPagerAdapter);
        noti_tabLayout = (TabLayout) view.findViewById(R.id.noti_tabLayout);
        noti_viewPager.setCurrentItem(1);


        noti_viewPager.setOffscreenPageLimit(2);

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

    public void selectPage(int i){
        Log.d("phase", "들어옴");
        noti_viewPager.setCurrentItem(i);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("phase", "노티 액티비티 크리에티드");
//        if(pageNum == 0){
//            noti_viewPager.setCurrentItem(0);
//            pageNum = 1;
//        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("phase", "노티 액티비티 resume");
        if(pageNum == 0){
            noti_viewPager.setCurrentItem(0);
            pageNum = 1;
        }
    }
}
