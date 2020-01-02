package com.bawei.rikao0102;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:邓先超
 *@Date: 2020/1/2
 *@Time:9:12
 *@Description:
 **/
@Entity
public class Mybean {
    String name;

    @Generated(hash = 1259330254)
    public Mybean(String name) {
        this.name = name;
    }

    @Generated(hash = 793355079)
    public Mybean() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
