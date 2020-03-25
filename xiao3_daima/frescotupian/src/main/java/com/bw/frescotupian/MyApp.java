package com.bw.frescotupian;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/*
 *@auther:邓先超
 *@Date: 2020/2/25
 *@Time:11:13
 *@Description:
 **/
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
