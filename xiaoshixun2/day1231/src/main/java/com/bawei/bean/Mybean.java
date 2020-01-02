package com.bawei.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Keep;

/*
 *@auther:邓先超
 *@Date: 2019/12/31
 *@Time:15:37
 *@Description:
 **/
@Entity
public class Mybean {

    @Id(autoincrement = true)
    Long id;
    String name;
    String sex;
    @Keep
    public Mybean(Long id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
    @Keep
    public Mybean(String name, String sex) {
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
