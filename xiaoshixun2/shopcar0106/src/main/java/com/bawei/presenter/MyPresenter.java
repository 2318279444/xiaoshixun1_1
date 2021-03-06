package com.bawei.presenter;

import com.bawei.base.BasePresenter;
import com.bawei.contract.Icontract;
import com.bawei.model.MyModel;
import com.bawei.shopcar0106.MainActivity;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/6
 *@Time:17:00
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    MyModel myModel;
    public MyPresenter(){
        myModel=new MyModel();
    }

    public void pShop(String url, Class cls, Map<String,Object> map){
        myModel.mShop(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                MainActivity mainActivity= (MainActivity) v;
                mainActivity.success(stra);
            }
        });
    }
}
