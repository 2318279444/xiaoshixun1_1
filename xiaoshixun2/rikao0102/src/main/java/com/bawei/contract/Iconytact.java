package com.bawei.contract;

/*
 *@auther:邓先超
 *@Date: 2020/1/2
 *@Time:8:50
 *@Description:
 **/
public interface Iconytact {
    public interface ToCall{
        void success(String json);
    }

    public interface  CallBanner{
        void success(Object o);
    }
}
