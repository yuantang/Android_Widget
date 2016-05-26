package com.coder.tom.android_widget;

import java.io.Serializable;

public   class DataBean implements Serializable {
    String name;
    String code;
    String data1;
    String data2;
    String data3;
    String data4;
    String data5;
    String data6;

    public DataBean(String name, String code, String data1, String data2, String data3, String data4, String data5, String data6) {
        this.name = name;
        this.code = code;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
        this.data5 = data5;
        this.data6 = data6;
        this.data1 = data1;
    }
}