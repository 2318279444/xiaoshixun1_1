package com.bawei.presenter;

import com.bawei.base.BasePresenter;
import com.bawei.contract.Icontract;
import com.bawei.denglu01021_1.Login;
import com.bawei.denglu01021_1.MainActivity;
import com.bawei.model.MyModel;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/2
 *@Time:19:28
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    MyModel myModel;
    public MyPresenter(){
        myModel=new MyModel();
    }

    public void mDenglu(String url, Class cls, Map<String,Object> map){
        myModel.mDenglu(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                MainActivity mainActivity= (MainActivity) v;
                mainActivity.success(stra);
            }
        });
    }


    public void pShop(String url,Class cls,Map<String,Object> map){
        myModel.mShop(url, cls, map, new Icontract.ToShopCall() {
            @Override
            public void success(String stra) {
                Login login= (Login) v;
                login.success(stra);
            }
        });
    }
}
