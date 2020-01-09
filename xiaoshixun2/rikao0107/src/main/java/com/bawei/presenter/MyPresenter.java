package com.bawei.presenter;

import com.bawei.base.BasePresenter;
import com.bawei.contract.Icontract;
import com.bawei.model.MyModel;
import com.bawei.rikao0107.Adress;
import com.bawei.rikao0107.MainActivity;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/7
 *@Time:8:49
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


    public void pAdress(String url,Class cls,Map<String,Object> map){
        myModel.mAdress(url, cls, map, new Icontract.adressCallBack() {
            @Override
            public void success(String stra) {
                Adress adress= (Adress) v;
                adress.success(stra);
            }
        });
    }


}
