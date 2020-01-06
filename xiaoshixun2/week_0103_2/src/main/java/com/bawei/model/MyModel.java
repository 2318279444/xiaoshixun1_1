package com.bawei.model;

import com.bawei.contract.Icontract;
import com.bawei.util.NetUtil;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/3
 *@Time:11:27
 *@Description:
 **/
public class MyModel {
    public void mFenlei(String url, Class cls, final Icontract.ToCall toCall){
        NetUtil.getInstance().netFenlei(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }



    public void mXiangqing(String url, Class cls, Map<String,Object> map, final Icontract.ToCall toCall){
        NetUtil.getInstance().netxiangqing(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
