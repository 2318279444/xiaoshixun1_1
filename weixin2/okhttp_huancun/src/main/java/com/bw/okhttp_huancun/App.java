package com.bw.okhttp_huancun;

import android.app.Application;
import android.content.Context;

/*
 *@auther:邓先超
 *@Date: 2020/3/27
 *@Time:10:04
 *@Description:
 **/
public class App extends Application {
    public static App sapp;

    @Override
    public void onCreate() {
        super.onCreate();
        sapp=this;
    }

    public static Context getAppContext(){
        return sapp;
    }
}
