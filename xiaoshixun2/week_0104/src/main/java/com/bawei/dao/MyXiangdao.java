package com.bawei.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:邓先超
 *@Date: 2020/1/4
 *@Time:11:59
 *@Description:
 **/
@Entity
public class MyXiangdao {
    String Xiangdao;

    @Generated(hash = 2055012275)
    public MyXiangdao(String Xiangdao) {
        this.Xiangdao = Xiangdao;
    }

    @Generated(hash = 394767932)
    public MyXiangdao() {
    }

    public String getXiangdao() {
        return this.Xiangdao;
    }

    public void setXiangdao(String Xiangdao) {
        this.Xiangdao = Xiangdao;
    }
}
