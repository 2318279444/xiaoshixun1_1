package com.bawei.jiaqizuoye2020_03_14;

import android.app.Application;

import com.bawei.jiaqizuoye2020_03_14.database.DaoMaster;
import com.bawei.jiaqizuoye2020_03_14.database.DaoSession;

/*
 *@auther:邓先超
 *@Date: 2020/3/15
 *@Time:22:23
 *@Description:
 **/
public class MyApp extends Application {

    private static DaoSession gwc2;

    @Override
    public void onCreate() {
        super.onCreate();
        gwc2 = DaoMaster.newDevSession(this, "gwc2");
    }

    public static DaoSession getGwc2(){
        return gwc2;
    }
}
