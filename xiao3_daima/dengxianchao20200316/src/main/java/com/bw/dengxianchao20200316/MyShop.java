package com.bw.dengxianchao20200316;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:邓先超
 *@Date: 2020/3/16
 *@Time:10:33
 *@Description:
 **/
@Entity
public class MyShop {
    String url;

    @Generated(hash = 1949761400)
    public MyShop(String url) {
        this.url = url;
    }

    @Generated(hash = 1595323673)
    public MyShop() {
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
