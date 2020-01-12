package com.bawei.model;

import android.util.Log;

import com.bawei.contract.Icontract;
import com.bawei.util.NetUtil;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/11
 *@Time:10:33
 *@Description:
 **/
public class MyModel {

    public void mZhuce(String url, Class cls, Map<String,Object> map, Icontract.ToLoginCallBack toLoginCallBack){
        NetUtil.getInstance().netZhuce(url, cls, map, new Icontract.ToLoginCallBack() {
            @Override
            public void success(String stra) {
                toLoginCallBack.success(stra);
            }
        });
    }



    public void mShop(String url,Class cls,Map<String,Object> map,Icontract.ToCall toCall){
        NetUtil.getInstance().netShop(url, cls, map, new Icontract.ToCall() {
            @Override
            public void successshop(String stra) {
                Log.e("aaa","mshop"+stra);
                toCall.successshop(stra);
            }
        });
    }




}
