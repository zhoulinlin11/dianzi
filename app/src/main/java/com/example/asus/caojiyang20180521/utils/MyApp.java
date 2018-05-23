package com.example.asus.caojiyang20180521.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by asus on 2018/5/21.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Fresco初始化
        Fresco.initialize(this);
    }
}
