package com.bawei.model;

import android.util.Log;

import com.bawei.contract.Icontract;
import com.bawei.util.NetUtil;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/14
 *@Time:19:53
 *@Description:
 **/
public class MoModel {
    public void mShop(String url, Class cls, Map<String,Object> map, Icontract.ToCall toCall){
        NetUtil.getInstance().toShop(url, cls, map, new Icontract.ToCall() {
            @Override
            public void seccess(String stra) {
                Log.e("aaa", "m: "+stra);
                toCall.seccess(stra);
            }
        });
    }
}
