package com.bawei.model;

import com.bawei.contract.Icontract;
import com.bawei.util.NetUtil;

/*
 *@auther:邓先超
 *@Date: 2019/12/30
 *@Time:10:23
 *@Description:
 **/
public class Model {
    public void toGit(String url, Class cls, Icontract.ToCall toCall){
        NetUtil.getInstance().toGit(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
