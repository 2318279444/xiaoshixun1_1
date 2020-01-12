package com.bawei.presenter;

import android.util.Log;

import com.bawei.base.BasePresenter;
import com.bawei.contract.Icontract;
import com.bawei.model.MyModel;
import com.bawei.week0111_1.MainActivity;
import com.bawei.week0111_1.Shoppingg;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/11
 *@Time:10:33
 *@Description:
 **/
public class MyPresenter extends BasePresenter {

    MyModel myModel;
    public MyPresenter(){
        myModel=new MyModel();
    }


    public void pZhuce(String url, Class cls, Map<String,Object> map){
        myModel.mZhuce(url, cls, map, new Icontract.ToLoginCallBack() {
            @Override
            public void success(String stra) {
                MainActivity mainActivity= (MainActivity) v;
                mainActivity.success(stra);
            }
        });
    }



    public void pShop(String url,Class cls,Map<String,Object> map){
        myModel.mShop(url, cls, map, new Icontract.ToCall() {
            @Override
            public void successshop(String stra) {
                Log.e("aaa","p"+stra);
                Shoppingg shoppingg= (Shoppingg) v;
                shoppingg.successshop(stra);
            }
        });
    }
}
