package com.bw.movie;

import android.app.Application;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by Android Studio.
 * User: 潘世松
 * Date: 2020/2/7
 * Time: 19:44
 */
public class MyApp extends Application {

    public static IWXAPI mWxApi;

    @Override
    public void onCreate() {
        super.onCreate();
        registToWX();
    }

    private void registToWX() {
        //AppConst.WEIXIN.APP_ID是指你应用在微信开放平台上的AppID，记得替换。
        mWxApi = WXAPIFactory.createWXAPI(this, "wxb3852e6a6b7d9516", false);
        // 将该app注册到微信
        mWxApi.registerApp("wxb3852e6a6b7d9516");
    }

}
