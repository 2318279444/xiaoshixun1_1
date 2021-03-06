package com.bw.movie.flzc.wx;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/*
 *@auther:邓先超
 *@Date: 2020/3/25
 *@Time:18:06
 *@Description:
 **/
public class MyApp extends Application {
    public static Context context;
    public static IWXAPI mWxApi;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        registToWX();
        MultiDex.install(this);
    }

    private void registToWX() {
        //AppConst.WEIXIN.APP_ID是指你应用在微信开放平台上的AppID，记得替换。
        mWxApi = WXAPIFactory.createWXAPI(this, "wxb3852e6a6b7d9516", true);
        // 将该app注册到微信
        mWxApi.registerApp("wxb3852e6a6b7d9516");
    }
}
