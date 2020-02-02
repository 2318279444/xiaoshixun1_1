package com.bawei.presenter;

import com.bawei.base.BasePresenter;
import com.bawei.contract.Icontract;
import com.bawei.jiaqizuoye111.GwcActivity;
import com.bawei.model.MoModel;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/14
 *@Time:19:53
 *@Description:
 **/
public class MyPresenter extends BasePresenter  {
    MoModel moModel;
    public MyPresenter(){
        moModel =new MoModel();
    }

    public void pShop(String url, Class cls, Map<String,Object> map){
        moModel.mShop(url, cls, map, new Icontract.ToCall() {
            @Override
            public void seccess(String stra) {
                GwcActivity gwcActivity= (GwcActivity) v;
                gwcActivity.seccess(stra);
            }
        });
    }
}
