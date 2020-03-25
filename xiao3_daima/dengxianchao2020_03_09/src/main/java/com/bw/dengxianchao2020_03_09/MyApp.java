package com.bw.dengxianchao2020_03_09;

import android.app.Application;

import com.bw.dengxianchao2020_03_09.database.DaoMaster;
import com.bw.dengxianchao2020_03_09.database.DaoSession;

/*
 *@auther:邓先超
 *@Date: 2020/3/9
 *@Time:22:05
 *@Description:
 **/
public class MyApp extends Application {

    private static DaoSession movie2;

    @Override
    public void onCreate() {
        super.onCreate();
        movie2 = DaoMaster.newDevSession(this, "movie2");
    }

    public static DaoSession getMovie2(){
        return movie2;
    }
}
