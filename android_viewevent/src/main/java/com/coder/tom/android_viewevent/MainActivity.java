package com.coder.tom.android_viewevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String Tag="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.mylayoutview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,"onClick------>mylayoutview",Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.mylayoutview).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                eventShow(v,event);
                Toast.makeText(MainActivity.this,"onTouch------>mylayoutview",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(Tag,"button----->OnClickListener");
                Toast.makeText(MainActivity.this,"onClick------>button",Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.button).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(Tag,"button----->OnTouchListener");
                eventShow(v,event);
                Toast.makeText(MainActivity.this,"onTouch------>button",Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        findViewById(R.id.mybutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(Tag,"myview----->OnClickListener");
                Toast.makeText(MainActivity.this,"onClick------>mybutton",Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.mybutton).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(Tag,"myview----->OnTouchListener");
                eventShow(v,event);
                Toast.makeText(MainActivity.this,"onTouch------>mybutton",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
    private void eventShow(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
            case MotionEvent.ACTION_OUTSIDE:
                break;
        }
    }
    //事件拦截
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(Tag,"dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(Tag,"onTouchEvent");
        return super.onTouchEvent(event);
    }
}
