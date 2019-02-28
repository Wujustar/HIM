package com.example.class10.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    // MyCanvas canvas = new MyCanvas(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyCanvas(this));


    }

    private static class MyCanvas extends View{

        public MyCanvas(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(20);
            paint.setColor(Color.rgb(250, 0, 0));
            canvas.drawLine(50, 50, 300, 300, paint);
        }
    }
}
