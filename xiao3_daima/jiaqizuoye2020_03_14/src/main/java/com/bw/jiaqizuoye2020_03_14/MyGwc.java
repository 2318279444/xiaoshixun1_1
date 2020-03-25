package com.bw.jiaqizuoye2020_03_14;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:邓先超
 *@Date: 2020/3/15
 *@Time:22:21
 *@Description:
 **/
@Entity
public class MyGwc {
    String url;

    @Generated(hash = 271383448)
    public MyGwc(String url) {
        this.url = url;
    }

    @Generated(hash = 1279383938)
    public MyGwc() {
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
