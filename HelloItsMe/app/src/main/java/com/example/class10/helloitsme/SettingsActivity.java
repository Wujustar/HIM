package com.example.class10.helloitsme;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;


import com.example.class10.helloitsme.adapter.SettingsListViewAdapter;

public class SettingsActivity extends AppCompatActivity {
    ListView settings_listView;
    SettingsListViewAdapter settingsListViewAdapter;
    int[] icons = {R.drawable.navigation_notification_outlined, R.drawable.navigation_notification_outlined, R.drawable.navigation_notification_outlined, R.drawable.navigation_notification_outlined};
    String[] titles = {"공지사항", "내 정보", "알림", "버전"};
    String[] txts = {"","", "", ""};
    ImageView settings_iv_prev;
    private static final int INFO = 0;
    private static final int MY_INFO = 1;
    private static final int ALARM = 2;
    private static final int VERSION = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        settings_iv_prev = (ImageView) findViewById(R.id.settings_iv_prev);
        settings_iv_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        settings_listView = (ListView) findViewById(R.id.settings_listView);
        settingsListViewAdapter = new SettingsListViewAdapter();
        settings_listView.setAdapter(settingsListViewAdapter);

        for(int i = 0; i < icons.length; i++){
            settingsListViewAdapter.addData(ContextCompat.getDrawable(this, icons[i]), titles[i], txts[i]);
        }
        settings_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case INFO :

                        setResult(RESULT_OK);
                        finish();
                        Log.d("phase", "백백");
                        break;

                    case MY_INFO :
                        break;

                    case ALARM :
                        break;

                    case VERSION :
                        break;
                }
            }
        });

    }
}
