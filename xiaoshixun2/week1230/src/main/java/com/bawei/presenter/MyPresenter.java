package com.bawei.presenter;

import com.bawei.base.BasePresenter;
import com.bawei.contract.Icontract;
import com.bawei.model.Model;
import com.bawei.week1230.MainActivity;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2019/12/30
 *@Time:10:23
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    Model model;
    public MyPresenter(){
        model=new Model();
    }

    public void toGits(String url, Map<String,Object> map, Class cls){
        model.toGit(url,map, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                MainActivity mainActivity= (MainActivity) v;
                mainActivity.success(stra);
            }
        });
    }
}
