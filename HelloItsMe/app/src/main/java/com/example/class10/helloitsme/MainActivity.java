package com.example.class10.helloitsme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import com.example.class10.helloitsme.adapter.CustomViewPager;
import com.example.class10.helloitsme.adapter.MainViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    ImageView main_iv_search, main_iv_logo, main_iv_menu;
//    ViewPager main_viewPager;
    LinearLayout main_lnl;
    BottomNavigationView main_bottomNavigationView;
    MainViewPagerAdapter mainViewPagerAdapter;
    CustomViewPager customViewPager;
    Toolbar main_toolbar;
    int page = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ### Control Search Button on Toolbar ###
        main_toolbar = (Toolbar) findViewById(R.id.main_toolbar);

        main_iv_search = (ImageView)findViewById(R.id.main_iv_search);
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

                        switch (item.getItemId()){
                            case R.id.main_menu_display :
                                break;
                            case R.id.main_menu_developer :
                                break;
                            case R.id.main_menu_settings :
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
        customViewPager = (CustomViewPager)findViewById(R.id.main_customViewPager);
        main_bottomNavigationView = (BottomNavigationView) findViewById(R.id.main_bottomNavigationView);

        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), 4);
        customViewPager.setAdapter(mainViewPagerAdapter);
        customViewPager.setPagingEnabled(false);

        main_bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                main_toolbar.setVisibility(View.VISIBLE);
                if(customViewPager.getCurrentItem() == R.id.main_navigation_notification){
                    main_toolbar.setVisibility(View.GONE);
                }
                switch (menuItem.getItemId()){
                    case R.id.main_navigation_home :
                        menuItem.setChecked(true);
                        customViewPager.setCurrentItem(0,false);
                        page = 1;
                        break;

                    case R.id.main_navigation_search :
                        menuItem.setChecked(true);
                        customViewPager.setCurrentItem(1,false);
                        page = 2;
                        break;

                    case R.id.main_navigation_add :
                        Intent intent = new Intent(MainActivity.this, AddActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.activity_anim_not_move, R.anim.activity_anim_not_move);

                        break;

                    case R.id.main_navigation_notification :
                        main_toolbar.setVisibility(View.GONE);
                        menuItem.setChecked(true);
                        customViewPager.setCurrentItem(2,false);
                        page = 4;
                        break;

                    case R.id.main_navigation_info :
                        menuItem.setChecked(true);
                        customViewPager.setCurrentItem(3,false);
                        page = 5;
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
        if(page == 4){
            main_toolbar.setVisibility(View.GONE);
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

//    StringBuffer sb = new StringBuffer();
//    Cursor managedCursor = managedQuery(CallLog.Calls.CONTENT_URI, null,
//            null, null, null);
//    int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
//    int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
//    int name = managedCursor.getColumnIndex(CallLog.Calls.CACHED_NAME);
//
//while (managedCursor.moveToNext()) {
//        String phNumber = managedCursor.getString(number); //전화번호
//        String callType = managedCursor.getString(type); // 수신, 송신, 수신안됨
//        String callDate = managedCursor.getString(date); //날짜 시간
//        String Named = managedCursor.getString(name); //이름
//        Date callDayTime = new Date(Long.valueOf(callDate));
//        String callDuration = managedCursor.getString(duration);
//        String dir = null;
//        int dircode = Integer.parseInt(callType);
//        switch (dircode) {
//            case CallLog.Calls.OUTGOING_TYPE:
//                dir = "송신";
//                break;
//
//            case CallLog.Calls.INCOMING_TYPE:
//                dir = "수신";
//                break;
//
//            case CallLog.Calls.MISSED_TYPE:
//                dir = "통화안됨";
//                break;
//        }
//        sb.append("\n전화번호: " + phNumber + "\n날짜: " + callDayTime
//        );
//        sb.append("\n----------------------------------");
//    }
//managedCursor.close();
//Toast.makeText(MainActivity.this , sb, Toast.LENGTH_LONG).show();
}
