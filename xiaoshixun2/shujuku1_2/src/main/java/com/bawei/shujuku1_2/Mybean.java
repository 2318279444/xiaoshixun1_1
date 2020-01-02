package com.bawei.shujuku1_2;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:邓先超
 *@Date: 2020/1/1
 *@Time:19:23
 *@Description:
 **/
@Entity
public class Mybean {
    String name;
    String sex;
    @Generated(hash = 346078633)
    public Mybean(String name, String sex) {
        this.name = name;
        this.sex = sex;
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
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}
