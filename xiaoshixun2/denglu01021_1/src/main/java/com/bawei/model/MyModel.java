package com.bawei.model;


import com.bawei.contract.Icontract;
import com.bawei.util.NetUtil;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/2
 *@Time:19:54
 *@Description:
 **/
public class MyModel {
    public void mDenglu(String url, Class cls, Map<String,Object> map, Icontract.ToCall toCall){
        NetUtil.getInstance().toDenglu(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
