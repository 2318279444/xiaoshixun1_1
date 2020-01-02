package com.bawei.day1231;

import android.app.Application;

import com.bawei.database.DaoMaster;
import com.bawei.database.DaoSession;

/*
 *@auther:邓先超
 *@Date: 2019/12/31
 *@Time:15:44
 *@Description:
 **/
public class MyApp extends Application {

    private static DaoSession  student;

    @Override
    public void onCreate() {
        super.onCreate();
        student = DaoMaster.newDevSession(this, "student");
    }

    public static DaoSession getDaosession(){
        return student;
    }
}
