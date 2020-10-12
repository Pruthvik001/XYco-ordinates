package com.example.myco_ordinates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import java.nio.channels.FileLock;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        e1=(EditText)findViewById(R.id.xp);
        e2=(EditText)findViewById(R.id.yp);
        e3=(EditText)findViewById(R.id.height);
        e4=(EditText)findViewById(R.id.width);
        e5=(EditText)findViewById(R.id.Xm);
        e6=(EditText)findViewById(R.id.Ym);

        constraintLayout=(ConstraintLayout)findViewById(R.id.layout);

        DisplayMetrics displayMetrics=getResources().getDisplayMetrics();
        float H=displayMetrics.heightPixels/displayMetrics.density;
        float W=displayMetrics.widthPixels/displayMetrics.density;

        e3.setText("H="+Float.toString(H)+ "px");
        e4.setText("W="+Float.toString(W)+ "px");

        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final float x=event.getX();
                final float y=event.getY();
                float X=x;
                float Y=y;

                e1.setText("X="+Float.toString(X)+ "px");
                e2.setText("Y="+Float.toString(Y)+ "px");

                e5.setText("X="+Float.toString((float) ((X*248.25)/1000))+ "mm");
                e6.setText("Y="+Float.toString((float) ((Y*248.25)/1000))+ "mm");

                return true;
            }
        });
    }
}