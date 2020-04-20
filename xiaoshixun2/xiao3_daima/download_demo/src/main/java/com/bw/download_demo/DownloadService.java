package com.bw.download_demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.Serializable;

/*
 *@auther:邓先超
 *@Date: 2020/3/18
 *@Time:9:48
 *@Description:
 **/
public class DownloadService extends Service {
    public static final String ACTION_START="ACTION_START";
    public static final String ACTION_STOP="ACTION_STOP";
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(ACTION_START.equals(intent.getAction())){
            Serializable fileinfo = intent.getSerializableExtra("fileinfo");
            Log.e("aaa","fileinfo_start"+fileinfo.toString());
        }else {
            Serializable fileinfo = intent.getSerializableExtra("fileinfo");
            Log.e("aaa","fileinfosti_stop"+fileinfo.toString());
        }


        return super.onStartCommand(intent, flags, startId);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
