package com.bawei.presenter;

import com.bawei.base.BasePresenter;
import com.bawei.contract.Icontract;
import com.bawei.model.Mymodel;
import com.bawei.month1230.MainActivity;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/9
 *@Time:13:45
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    Mymodel mymodel;

    public MyPresenter(){
        mymodel=new Mymodel();
    }

    public void pDd(String url, Class cls, Map<String,Object> map,Map<String,Object> map1){
        mymodel.mDd(url, cls, map,map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                MainActivity mainActivity= (MainActivity) v;
                mainActivity.success(stra);
            }
        });
    }


}
