package com.bawei.presenter;

import com.bawei.base.BasePresenter;
import com.bawei.contract.Contract;
import com.bawei.contract.Ictract;
import com.bawei.dengxianchao20191231.MainActivity;
import com.bawei.model.MyModel;

/*
 *@auther:邓先超
 *@Date: 2019/12/31
 *@Time:8:59
 *@Description:
 **/
public class MyPresenter extends BasePresenter {

    MyModel myModel;
    public MyPresenter(){
        myModel=new MyModel();
    }



    public void ppxinxi(String url,Class cls){
        myModel.toGit(url, cls, new Ictract.ToCall() {
            @Override
            public void success(String stra) {
                MainActivity mainActivity= (MainActivity) v;
                mainActivity.success(stra);
            }
        } );
    }
}
