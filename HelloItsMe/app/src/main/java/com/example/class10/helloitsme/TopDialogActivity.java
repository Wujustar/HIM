package com.example.class10.helloitsme;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TopDialogActivity extends Activity {
    LinearLayout top_lnl01;
    TextView top_txt_phoneNum;
    Button top_btn_exit;

    public TopDialogActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_top_dialog);

        top_lnl01 = (LinearLayout) findViewById(R.id.top_lnl01);
        top_txt_phoneNum = (TextView) findViewById(R.id.top_txt_phoneNum);

        top_btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
        //set Flags
        getWindow().addFlags(
                            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O_MR1) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED |
                    WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD |
                    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                    );
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            this.setShowWhenLocked(true);
            this.setTurnScreenOn(true);
        }

    }


}

