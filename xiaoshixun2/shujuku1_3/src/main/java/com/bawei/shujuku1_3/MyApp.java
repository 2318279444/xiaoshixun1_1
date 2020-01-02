package com.bawei.shujuku1_3;

import android.app.Application;

import com.bawei.shujuku1_3.database.DaoMaster;
import com.bawei.shujuku1_3.database.DaoSession;

/*
 *@auther:邓先超
 *@Date: 2020/1/1
 *@Time:19:53
 *@Description:
 **/
public class MyApp extends Application {

    private static DaoSession qwe;

    @Override
    public void onCreate() {
        super.onCreate();
        qwe = DaoMaster.newDevSession(this, "qwe");
    }

    public static DaoSession getQwe(){
        return qwe;
    }
}
