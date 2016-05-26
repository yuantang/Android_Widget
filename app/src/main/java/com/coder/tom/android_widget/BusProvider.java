package com.coder.tom.android_widget;

import com.squareup.otto.Bus;

/**
 * Created by tom on 2016/4/7.
 */
public class BusProvider {
    //主线程
    private static final Bus BUS=new Bus();
    public  static  Bus getInstance(){
        return BUS;
    }
    public BusProvider(){
    }
}
