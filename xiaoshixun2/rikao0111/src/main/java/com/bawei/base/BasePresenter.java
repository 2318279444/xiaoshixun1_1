package com.bawei.base;

/*
 *@auther:邓先超
 *@Date: 2020/1/11
 *@Time:8:46
 *@Description:
 **/
public class BasePresenter<V extends BaseFragment> {
    public V v;

    public void attacg(V v){
        this.v=v;
    }

    public void unattach(){
        if(v!=null){
            v=null;
        }
    }
}
