package com.bawei.model;

import com.bawei.contract.Icontract;
import com.bawei.util.NetUtil;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/6
 *@Time:17:00
 *@Description:
 **/
public class MyModel {
    public void mShop(String url, Class cls, Map<String,Object> map, Icontract.ToCall toCall){
        NetUtil.getInstance().netShop(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
