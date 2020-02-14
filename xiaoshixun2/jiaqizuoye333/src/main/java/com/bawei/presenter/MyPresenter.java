package com.bawei.presenter;

import android.util.Log;

import com.bawei.base.BasePresenter;
import com.bawei.contract.Icontract;
import com.bawei.fragment.Daifk;
import com.bawei.fragment.Quanbu;
import com.bawei.model.MyModel;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/11
 *@Time:9:01
 *@Description:
 **/
public class MyPresenter extends BasePresenter {

    MyModel myModel;
    public MyPresenter(){
        myModel=new MyModel();
    }

    public void pDingDan(String url, Class cls, Map<String,Object> map, Map<String,Object> map1){
        myModel.mDingdan(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Quanbu quanbu= (Quanbu) v;
                quanbu.success(stra);

                Log.e("aaa","noi"+stra);
            }
        });
    }
}
