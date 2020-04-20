package com.bw.dengxianchao2020_03_02;

import android.app.Application;
import android.content.Context;

/**
 * date:2020/3/27
 * author:易宸锋(dell)
 * function:给整个项目可用的上下文
 * Application的上下文和我们的Activity有什么不同
 * 全局的上下文生命周期特别长,随着项目的启动就出现,一直到项目的退出才结束
 * 局部的上下文生命周期和Activity的生命周期是一致
 */
public class App extends Application {

    private static App sApp;

    public static Context getAPPContext(){
        return sApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
    }
}
