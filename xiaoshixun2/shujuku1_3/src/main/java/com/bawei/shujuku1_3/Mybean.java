package com.bawei.shujuku1_3;

/*
 *@auther:邓先超
 *@Date: 2020/1/1
 *@Time:19:52
 *@Description:
 **/

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Mybean {

    Long id;
    String name;
    String sex;
    @Generated(hash = 2067845904)
    public Mybean(Long id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
    @Generated(hash = 793355079)
    public Mybean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
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
