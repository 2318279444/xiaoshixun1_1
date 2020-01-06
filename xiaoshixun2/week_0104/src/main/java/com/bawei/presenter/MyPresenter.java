package com.bawei.presenter;

import com.bawei.base.BasePresenter;
import com.bawei.contract.Icontract;
import com.bawei.model.MyModel;
import com.bawei.week_0104.MainActivity;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/4
 *@Time:9:41
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    MyModel myModel;

    public MyPresenter(){
        myModel=new MyModel();
    }

    public void pFen(String url, Class cls){
        myModel.mFen(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                MainActivity mainActivity= (MainActivity) v;
                mainActivity.success(stra);
            }
        });
    }



    public void pXiang(String url, Class cls, Map<String,Object> map){
        myModel.mXiang(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                MainActivity mainActivity= (MainActivity) v;
                mainActivity.success(stra);
            }
        });
    }
}
