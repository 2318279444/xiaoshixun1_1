package com.bawei.base;

/*
 *@auther:邓先超
 *@Date: 2020/1/14
 *@Time:19:52
 *@Description:
 **/
public class BasePresenter<V extends BaseActivtity> {
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
