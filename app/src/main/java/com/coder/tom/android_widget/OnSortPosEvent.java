package com.coder.tom.android_widget;

/**
 * Created by tangyuan on 2016/9/6.
 */
public class OnSortPosEvent {

    public int sortTag;
    public int postion;
    public int sortWay;

    /**
     *
     * @param sortTag   对哪一个排序
     * @param postion 对哪一个grouppostion排序
     * @param sortWay  排序方式
     */

    public OnSortPosEvent(int sortTag,int postion,int sortWay){
        this.postion=postion;
        this.sortTag=sortTag;
        this.sortWay=sortWay;
    }
}
