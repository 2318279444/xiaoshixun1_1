package com.bawei.rikaoday1_02_21.greend;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:邓先超
 *@Date: 2020/3/5
 *@Time:16:45
 *@Description:
 **/
@Entity
public class GreenDaoweizhi {
    String weizhi;

    @Generated(hash = 1395841586)
    public GreenDaoweizhi(String weizhi) {
        this.weizhi = weizhi;
    }

    @Generated(hash = 428631652)
    public GreenDaoweizhi() {
    }

    public String getWeizhi() {
        return this.weizhi;
    }

    public void setWeizhi(String weizhi) {
        this.weizhi = weizhi;
    }
}
