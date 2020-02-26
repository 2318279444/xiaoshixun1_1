package com.bawei.dengxianchao2020218.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/*
 *@auther:邓先超
 *@Date: 2020/2/20
 *@Time:18:46
 *@Description:
 **/
@Entity
public class MyDao {
    String pic;

    @Generated(hash = 1985029908)
    public MyDao(String pic) {
        this.pic = pic;
    }

    @Generated(hash = 327307982)
    public MyDao() {
    }

    public String getPic() {
        return this.pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
