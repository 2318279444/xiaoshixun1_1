package com.bw.yanshenghao20200414.mvp.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class MyApp extends Application {

    public static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }


}
