package com.coder.tom.android_viewevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by tangyuan on 2016/6/3.
 */
public class MyViewGroup extends LinearLayout {
String Tag="MyViewGroup";
    public MyViewGroup(Context context) {
        super(context);
    }
    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //分发事件
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(Tag,"dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
//        return true;
    }
    //拦截事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(Tag,"onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
//        return true;
    }
    //消费事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(Tag,"onTouchEvent");
        return super.onTouchEvent(event);
    }
    @Override
    public void setOnTouchListener(OnTouchListener l) {
        Log.d(Tag,"setOnTouchListener");
        super.setOnTouchListener(l);
    }
}
