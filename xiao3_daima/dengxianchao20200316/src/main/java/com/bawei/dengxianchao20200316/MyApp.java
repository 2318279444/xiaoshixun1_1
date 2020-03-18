package com.bawei.dengxianchao20200316;

import android.app.Application;

import com.bawei.dengxianchao20200316.database.DaoMaster;
import com.bawei.dengxianchao20200316.database.DaoSession;

/*
 *@auther:邓先超
 *@Date: 2020/3/16
 *@Time:10:35
 *@Description:
 **/
public class MyApp extends Application {

    private static DaoSession shop6;

    @Override
    public void onCreate() {
        super.onCreate();
        shop6 = DaoMaster.newDevSession(this, "shop6");
    }

    public static DaoSession getShop6(){
        return shop6;
    }
}
