package com.bawei.presenter;

import com.bawei.base.BasePresenter;
import com.bawei.contract.Icontract;
import com.bawei.dengxianchao20200106.MainActivity;
import com.bawei.model.MyModel;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/6
 *@Time:9:01
 *@Description:
 **/
public class MyPresenter extends BasePresenter {

    MyModel myModel;

    public MyPresenter(){
        myModel=new MyModel();
    }

    public void pCate(String url, Class cls){
        myModel.mCate(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                MainActivity mainActivity= (MainActivity) v;
                mainActivity.success(stra);
            }
        });
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
