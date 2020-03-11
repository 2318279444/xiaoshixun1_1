package com.bawei.dengxianchao2020_03_09;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:邓先超
 *@Date: 2020/3/9
 *@Time:22:03
 *@Description:
 **/
@Entity
public class MyMoviesj {
    String url;

    @Generated(hash = 596974646)
    public MyMoviesj(String url) {
        this.url = url;
    }

    @Generated(hash = 2063589923)
    public MyMoviesj() {
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
