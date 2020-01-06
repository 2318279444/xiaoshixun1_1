package com.bawei.presenter;

import com.bawei.base.BasePresenter;
import com.bawei.contract.Icontract;
import com.bawei.model.MyModel;
import com.bawei.week_0103_2.MainActivity;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/3
 *@Time:11:26
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    MyModel myModel;
    public MyPresenter(){
        myModel=new MyModel();
    }

    public void pFenlei(String url, Class cls){
        myModel.mFenlei(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                MainActivity mainActivity= (MainActivity) v;
                mainActivity.success(stra);
            }
        });
    }

    public void pXiangqing(String url, Class cls, Map<String,Object> map){
        myModel.mXiangqing(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                MainActivity mainActivity= (MainActivity) v;
                mainActivity.success(stra);
            }
        });
    }
}
