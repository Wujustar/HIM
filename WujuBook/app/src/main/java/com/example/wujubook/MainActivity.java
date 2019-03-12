package com.example.wujubook;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    CustomViewPager customViewPager;
    BottomNavigationView main_bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customViewPager = (CustomViewPager) findViewById(R.id.main_customViewPager);
        main_bottomNavigationView = (BottomNavigationView) findViewById(R.id.main_bottomNavigationView);


    }
}
