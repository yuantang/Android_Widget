package com.coder.tom.android_widget;

/**
 * Created by tom on 2016/5/9.
 */
public class OnScrollEvent {
    public   int l;
    public   int t;

    public OnScrollEvent(int l, int t) {
        this.l = l;
        this.t = t;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "OnScrollEvent{" +
                "l=" + l +
                ", t=" + t +
                '}';
    }
}
