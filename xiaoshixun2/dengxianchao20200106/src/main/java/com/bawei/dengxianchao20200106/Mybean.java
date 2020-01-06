package com.bawei.dengxianchao20200106;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:邓先超
 *@Date: 2020/1/6
 *@Time:9:58
 *@Description:
 **/
@Entity
public class Mybean {

    String cate;

    @Generated(hash = 1464256582)
    public Mybean(String cate) {
        this.cate = cate;
    }

    @Generated(hash = 793355079)
    public Mybean() {
    }

    public String getCate() {
        return this.cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }
}
