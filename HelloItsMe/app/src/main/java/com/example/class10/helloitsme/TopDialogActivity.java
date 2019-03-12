package com.example.class10.helloitsme;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Display;
import android.view.MotionEvent;
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
    LinearLayoutManager lnl01_manager;
    WindowManager windowManager;
    LinearLayout.LayoutParams layoutParams;


    public TopDialogActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_top_dialog);

        top_lnl01 = (LinearLayout) findViewById(R.id.top_lnl01);
        top_txt_phoneNum = (TextView) findViewById(R.id.top_txt_phoneNum);
        top_btn_exit = (Button) findViewById(R.id.top_btn_exit);
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

        layoutParams = (LinearLayout.LayoutParams) top_lnl01.getLayoutParams();
        setDraggable();

    }

    private void setDraggable() {

        top_lnl01.setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
//                        initialX = layoutParams.x;
//                        initialY = layoutParams.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        return true;
                    case MotionEvent.ACTION_MOVE:
//                        layoutParams.x = initialX + (int) (event.getRawX() - initialTouchX);
//                        layoutParams.y = initialY + (int) (event.getRawY() - initialTouchY);

                        if (top_lnl01 != null)
                            windowManager.updateViewLayout(top_lnl01, layoutParams);
                        return true;
                }
                return false;
            }
        });



    }
}

