package com.bawei.model;

import com.bawei.contract.Contract;
import com.bawei.contract.Ictract;
import com.bawei.util.NetUtil;

/*
 *@auther:邓先超
 *@Date: 2019/12/31
 *@Time:9:00
 *@Description:
 **/
public class MyModel {
    public void toGit(String url, Class cls, Ictract.ToCall toCall){
        NetUtil.getInstance().toGits(url, cls, new Ictract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
