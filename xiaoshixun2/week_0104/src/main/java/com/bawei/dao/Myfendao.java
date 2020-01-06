package com.bawei.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:邓先超
 *@Date: 2020/1/4
 *@Time:11:58
 *@Description:
 **/
@Entity
public class Myfendao {
    String fendao;

    @Generated(hash = 1332543872)
    public Myfendao(String fendao) {
        this.fendao = fendao;
    }

    @Generated(hash = 173718798)
    public Myfendao() {
    }

    public String getFendao() {
        return this.fendao;
    }

    public void setFendao(String fendao) {
        this.fendao = fendao;
    }
}
