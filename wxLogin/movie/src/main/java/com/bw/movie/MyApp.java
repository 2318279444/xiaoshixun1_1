package com.bw.movie;

import android.app.Application;
import android.content.Context;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/*
 *@auther:邓先超
 *@Date: 2020/3/30
 *@Time:13:38
 *@Description:
 **/
public class MyApp extends Application {
    public static Context context;
    public static IWXAPI mWxApi;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        registerTowX();
    }
    private void registerTowX(){
        //AppConst.WEIXIN.APP_ID是指你应用在微信开放平台上的AppID，记得替换。
        mWxApi = WXAPIFactory.createWXAPI(this, "wxb3852e6a6b7d9516", false);
        // 将该app注册到微信
        mWxApi.registerApp("wxb3852e6a6b7d9516");
    }

}