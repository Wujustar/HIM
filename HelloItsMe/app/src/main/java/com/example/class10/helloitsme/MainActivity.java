package com.example.class10.helloitsme;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.class10.helloitsme.adapter.MainViewPagerAdapter;
import com.example.class10.helloitsme.fragment.HomeFragment;
import com.example.class10.helloitsme.fragment.NotificationFragment;

public class MainActivity extends AppCompatActivity {


    LinearLayout main_lnl;
    BottomNavigationView main_bottomNavigationView;
    MainViewPagerAdapter mainViewPagerAdapter;
    CustomViewPager customViewPager;


    int page;
    int fBtn = 0;
    int notiPage = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("phase", "main create");

        /// ### Make Activity Instance save fBtn value ###
        SharedPreferences sharedPreferences = getSharedPreferences("save", 0);
        fBtn = sharedPreferences.getInt("save_fBtn", 0);


        // ### Control ViewPager and BottomNavigationView ###
        main_lnl = (LinearLayout) findViewById(R.id.main_lnl);

        customViewPager = (CustomViewPager) findViewById(R.id.main_customViewPager);
        main_bottomNavigationView = (BottomNavigationView) findViewById(R.id.main_bottomNavigationView);

        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), 3);
        customViewPager.setAdapter(mainViewPagerAdapter);
        customViewPager.setPagingEnabled(false);
        customViewPager.setOffscreenPageLimit(3);

        main_bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId()) {
                    case R.id.main_navigation_home:
                        menuItem.setChecked(true);
                        customViewPager.setCurrentItem(0, false);
                        page = 1;
                        break;

                    case R.id.main_navigation_search:
                        menuItem.setChecked(true);
                        customViewPager.setCurrentItem(1, false);
                        page = 2;
                        break;

                    case R.id.main_navigation_add:
                        Intent intent = new Intent(MainActivity.this, AddActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.activity_anim_not_move, R.anim.activity_anim_not_move);

                        break;

                    case R.id.main_navigation_notification:

                        menuItem.setChecked(true);
                        customViewPager.setCurrentItem(2, false);
                        page = 4;
                        break;

                    case R.id.main_navigation_settings:
                        Intent intent1 = new Intent(MainActivity.this, SettingsActivity.class);
                        startActivityForResult(intent1, 1990);
                        overridePendingTransition(R.anim.activity_anim_not_move, R.anim.activity_anim_not_move);
                        break;

                }
                return false;
            }
        });

    }

    // Call Fragment's Internal Tag Method
    private static String makeFragmentName(int viewPagerId, int index) {
        return "android:switcher:" + viewPagerId + ":" + index;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d("phase", "main onresult");
        if (resultCode == RESULT_OK) {
            if (requestCode == 1990) {
                customViewPager.setCurrentItem(2, false);
                main_bottomNavigationView.getMenu().getItem(3).setChecked(true);
                notiPage = 0;
                //Log.d("phase", "check");
                //NotificationFragment fragment = (NotificationFragment) getSupportFragmentManager().findFragmentByTag(makeFragmentName(R.id.main_customViewPager, 3));
//                if(notiPage == 0){
//                    //NotificationFragment fragment = (NotificationFragment) mainViewPagerAdapter.getItem(2);
//                    NotificationFragment fragment = (NotificationFragment) getSupportFragmentManager().findFragmentByTag(makeFragmentName(R.id.main_customViewPager, 2));
//                    fragment.setPageNum(0);
//                    notiPage = 1;
//                }

            }
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("phase", "main onstart");
//        if(notiPage == 1){
//            //NotificationFragment fragment = (NotificationFragment) mainViewPagerAdapter.getItem(2);
//            NotificationFragment fragment = (NotificationFragment) getSupportFragmentManager().findFragmentByTag(makeFragmentName(R.id.main_customViewPager, 2));
//            fragment.selectPage(0);
//            notiPage = 0;
//        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("phase", "main resume");
        if (notiPage == 0) {
            //NotificationFragment fragment = (NotificationFragment) mainViewPagerAdapter.getItem(2);
            NotificationFragment fragment = (NotificationFragment) getSupportFragmentManager().findFragmentByTag(makeFragmentName(R.id.main_customViewPager, 2));
            fragment.selectPage(0);
            customViewPager.getAdapter().notifyDataSetChanged();
            notiPage = 1;

        }
    }
}




