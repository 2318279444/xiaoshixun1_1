package com.bw.okhttp_huancun3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/*
 *@auther:邓先超
 *@Date: 2020/3/27
 *@Time:10:08
 *@Description:
 **/
public class NetUtil {
    public static boolean isNetWork(Context context){
        ConnectivityManager manager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if(info!=null){
            return info.isConnected();
        }
        return false;
    }
}
