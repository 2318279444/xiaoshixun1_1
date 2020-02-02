package com.bawei.model;

import com.bawei.contract.Icontract;
import com.bawei.util.NetUtil;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/11
 *@Time:9:02
 *@Description:
 **/
public class MyModel {

    public void mDingdan(String url, Class cls, Map<String,Object> map, Map<String,Object> map1, Icontract.ToCall toCall){
        NetUtil.getInstance().netDingdan(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
