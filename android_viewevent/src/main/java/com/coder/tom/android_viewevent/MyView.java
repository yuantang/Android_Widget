package com.coder.tom.android_viewevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by tangyuan on 2016/6/3.
 */
public class MyView extends Button {
    String Tag="MyView";
    public MyView(Context context) {
        super(context);
    }
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //拦截事件
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(Tag,"dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }
    //消费事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(Tag,"myview----->onTouchEvent");
        return super.onTouchEvent(event);
    }
    @Override
    public void setOnTouchListener(OnTouchListener l) {
        Log.d(Tag,"setOnTouchListener");
        super.setOnTouchListener(l);
    }
}
