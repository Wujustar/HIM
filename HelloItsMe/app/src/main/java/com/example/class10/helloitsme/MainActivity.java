package com.example.class10.helloitsme;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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

public class MainActivity extends AppCompatActivity {
    ImageView main_iv_search, main_iv_logo, main_iv_menu;
    //    ViewPager main_viewPager;
    LinearLayout main_lnl;
    BottomNavigationView main_bottomNavigationView;
    MainViewPagerAdapter mainViewPagerAdapter;
    CustomViewPager customViewPager;
    Toolbar main_toolbar;
    View menu_filter_view;
    HomeFragment homeFragment;
    int page;
    int fBtn = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// ### Make Activity Instance save fBtn value ###
        SharedPreferences sharedPreferences = getSharedPreferences("save", 0);
        fBtn = sharedPreferences.getInt("save_fBtn", 0);


        // ### Control Search Button on Toolbar ###
        main_toolbar = (Toolbar) findViewById(R.id.main_toolbar);

        main_iv_search = (ImageView) findViewById(R.id.main_iv_search);
        main_iv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_anim_not_move, R.anim.activity_anim_not_move);
            }
        });

        // ### Control Menu Button on Toolbar (using PopUpMenu) ###
        main_iv_menu = (ImageView) findViewById(R.id.main_iv_menu);


        main_iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.main_menu_display:
                                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                menu_filter_view = View.inflate(MainActivity.this, R.layout.menu_filter, null);
                                final RadioButton menu_filter_both = (RadioButton) menu_filter_view.findViewById(R.id.menu_filter_both);
                                final RadioButton menu_filter_call = (RadioButton) menu_filter_view.findViewById(R.id.menu_filter_call);
                                final RadioButton menu_filter_message = (RadioButton) menu_filter_view.findViewById(R.id.menu_filter_message);
                                menu_filter_both.setChecked(true);
                                builder.setTitle("화면 편집")
                                        .setView(menu_filter_view)
                                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {

                                            }
                                        })
                                        .setPositiveButton("적용", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                homeFragment = (HomeFragment)getSupportFragmentManager().findFragmentByTag(makeFragmentName(R.id.main_customViewPager, 0));
                                                if(menu_filter_both.isChecked()){
                                                    homeFragment.showAll();
                                                    fBtn = 1;

                                                }else if(menu_filter_call.isChecked()){
                                                    homeFragment.showAll();
                                                    homeFragment.hideMessage();
                                                    fBtn = 2;

                                                }else if(menu_filter_message.isChecked()){
                                                    homeFragment.showAll();
                                                    homeFragment.hideCall();
                                                    fBtn = 3;
                                                }
                                            }
                                        })
                                        .show();
                                break;
                            case R.id.main_menu_developer:

                                break;
                            case R.id.main_menu_settings:
                                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                                startActivity(intent);
                                break;
                        }

                        return false;
                    }
                });
                popupMenu.inflate(R.menu.main_menu);
                popupMenu.show();
            }
        });


        // ### Control ViewPager and BottomNavigationView ###
        main_lnl = (LinearLayout) findViewById(R.id.main_lnl);
        //main_viewPager = (ViewPager) findViewById(R.id.main_viewPager);
        customViewPager = (CustomViewPager) findViewById(R.id.main_customViewPager);
        main_bottomNavigationView = (BottomNavigationView) findViewById(R.id.main_bottomNavigationView);

        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), 4);
        customViewPager.setAdapter(mainViewPagerAdapter);
        customViewPager.setPagingEnabled(false);
        customViewPager.setOffscreenPageLimit(3);

        main_bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                main_toolbar.setVisibility(View.VISIBLE);
                if (customViewPager.getCurrentItem() == R.id.main_navigation_notification) {
                    main_toolbar.setVisibility(View.GONE);
                }
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
                        main_toolbar.setVisibility(View.GONE);
                        menuItem.setChecked(true);
                        customViewPager.setCurrentItem(2, false);
                        page = 4;
                        break;

                    case R.id.main_navigation_info:
                        Intent intent1 = new Intent(MainActivity.this, SettingsActivity.class);
                        startActivity(intent1);
                        overridePendingTransition(R.anim.activity_anim_not_move, R.anim.activity_anim_not_move);
                        break;

                }
                return false;
            }
        });

    }

    //  ### Toolbar hides when specific fragment in MainAcitivity is called again (from other activities) ###
    @Override
    protected void onResume() {
        super.onResume();
        if (page == 4) {
            main_toolbar.setVisibility(View.GONE);
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("life", "포즈");
        SharedPreferences sharedPreferences = getSharedPreferences("save", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("save_fBtn", fBtn);
        editor.commit();

    }



    // Call Internal Fragment Tag Method
    private static String makeFragmentName(int viewPagerId, int index) {
        return "android:switcher:" + viewPagerId + ":" + index;
    }


}

//    public void showPopupMenu(View v){
//        PopupMenu popupMenu = new PopupMenu(this, v);
//        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//
//                return false;
//            }
//        });
//        popupMenu.inflate(R.menu.main_menu);
//        popupMenu.show();
//
//
//    }


