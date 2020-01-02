package com.bawei.presenter;

import com.bawei.base.BasePresenter;
import com.bawei.contract.Iconytact;
import com.bawei.model.Mymodel;
import com.bawei.rikao0102.MainActivity;

/*
 *@auther:邓先超
 *@Date: 2020/1/2
 *@Time:8:50
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    Mymodel mymodel;
    public MyPresenter(){
        mymodel=new Mymodel();
    }


    public void pShop(String url, Class cls){
        mymodel.mShop(url, cls, new Iconytact.ToCall() {
            @Override
            public void success(String json) {
                MainActivity mainActivity= (MainActivity) v;
                mainActivity.success(json);
            }
        });
    }
}
