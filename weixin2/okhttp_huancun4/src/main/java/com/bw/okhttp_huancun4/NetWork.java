package com.bw.okhttp_huancun4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * date:2020/3/27
 * author:易宸锋(dell)
 * function:网络判断工具类
 */
public class NetWork {

    //判断当前的手机状态是有有网还是无网
    public static boolean isNetworkReachable(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo curent = cm.getActiveNetworkInfo();
        if (curent == null){
            return false;
        }
        return ( curent.isAvailable() );

    }


}
