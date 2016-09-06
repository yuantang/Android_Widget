package com.coder.tom.android_basis.service;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by tangyuan on 2016/7/5.
 */
public class Book implements Parcelable{
    String name;
    String title;
    ArrayList arcti;

    protected Book(Parcel in) {
        name = in.readString();
        title = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(title);
    }
}
