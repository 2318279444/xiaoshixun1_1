package com.bawei.base;

/*
 *@auther:邓先超
 *@Date: 2020/1/7
 *@Time:8:49
 *@Description:
 **/
public class BasePresenter<V extends BaseActivity> {
    public V v;

    public void atach(V v){
        this.v=v;
    }

    public void unattach(){
        if(v!=null){
            v=null;
        }
    }
}
