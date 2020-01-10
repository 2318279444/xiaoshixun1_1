package com.bawei.model;

import com.bawei.contract.Icontract;
import com.bawei.util.NetUtil;

import java.util.Map;

/*
 *@auther:邓先超
 *@Date: 2020/1/9
 *@Time:13:45
 *@Description:
 **/
public class Mymodel {

    public void mDd(String url,Class cls,Map<String,Object> map,Map<String,Object> map1,Icontract.ToCall toCall){
        NetUtil.getInstance().netDd(url, cls, map,map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }

}
