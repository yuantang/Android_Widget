package com.coder.tom.android_widget;

import java.util.List;

/**
 * Created by tangyuan on 2016/9/5.
 */
public class GroupData {

    String name;
    String a;
    String b;
    String c;
    List<Child> childs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public List<Child> getChilds() {
        return childs;
    }

    public void setChilds(List<Child> childs) {
        this.childs = childs;
    }

    public static class Child{
        String name;
        String code;
        String data1;
        String data2;
        String data3;
        String data4;
        String data5;
        String data6;

        public Child(String name, String code, String data1, String data2, String data3, String data4, String data5, String data6) {
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

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", childs=" + childs +
                '}';
    }
}
