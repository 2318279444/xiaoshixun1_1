package com.bawei.contract;

/*
 *@auther:邓先超
 *@Date: 2020/1/11
 *@Time:10:32
 *@Description:
 **/
public interface Icontract {

    public interface ToLoginCallBack{
        void success(String stra);
    }

    public interface ToCall{
        void successshop(String stra);
    }
}
