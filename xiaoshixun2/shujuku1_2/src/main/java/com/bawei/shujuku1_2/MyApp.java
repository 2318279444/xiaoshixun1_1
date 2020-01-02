package com.bawei.shujuku1_2;

import android.app.Application;

import com.bawei.shujuku1_2.database.DaoMaster;
import com.bawei.shujuku1_2.database.DaoSession;

/*
 *@auther:邓先超
 *@Date: 2020/1/1
 *@Time:19:25
 *@Description:
 **/
public class MyApp extends Application {

    private static DaoSession grre;

    @Override
    public void onCreate() {
        super.onCreate();
        grre = DaoMaster.newDevSession(this, "grre");
    }

    public static DaoSession getGrre(){
        return grre;
    }
}
