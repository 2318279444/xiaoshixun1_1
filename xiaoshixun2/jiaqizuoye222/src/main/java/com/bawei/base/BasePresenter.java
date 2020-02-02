package com.bawei.base;

/*
 *@auther:邓先超
 *@Date: 2020/1/26
 *@Time:14:09
 *@Description:
 **/
public class BasePresenter<V extends BaseActivity> {
    public V v;

    public void attach(V v){
        this.v=v;
    }

    public void unattach(){
        if(v!=null){
            v=null;
        }
    }
}
