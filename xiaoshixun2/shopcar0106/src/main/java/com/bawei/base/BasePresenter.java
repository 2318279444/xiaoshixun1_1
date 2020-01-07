package com.bawei.base;

/*
 *@auther:邓先超
 *@Date: 2020/1/6
 *@Time:17:00
 *@Description:
 **/
public class BasePresenter<V extends BaseActivity> {
    public V v;

    public void attach(V v){
        this.v=v;
    }

    public void unatach(){
        if(v!=null){
            v=null;
        }
    }
}
