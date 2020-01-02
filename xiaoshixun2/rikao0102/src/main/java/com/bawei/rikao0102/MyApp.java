package com.bawei.rikao0102;

import android.app.Application;

import com.bawei.rikao0102.database.DaoMaster;
import com.bawei.rikao0102.database.DaoSession;

/*
 *@auther:邓先超
 *@Date: 2020/1/2
 *@Time:9:13
 *@Description:
 **/
public class MyApp extends Application {

    private static DaoSession rikao0102;

    @Override
    public void onCreate() {
        super.onCreate();
        rikao0102 = DaoMaster.newDevSession(this, "rikao0102");
    }

    public static DaoSession getRikao0102(){
        return rikao0102;
    }
}
