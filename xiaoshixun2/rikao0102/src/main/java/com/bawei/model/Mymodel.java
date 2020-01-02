package com.bawei.model;

import com.bawei.contract.Iconytact;
import com.bawei.util.NetUtil;

/*
 *@auther:邓先超
 *@Date: 2020/1/2
 *@Time:8:50
 *@Description:
 **/
public class Mymodel  {
    public void mShop(String url, Class cls, Iconytact.ToCall toCall){
        NetUtil.getInstance().netShop(url, cls, new Iconytact.ToCall() {
            @Override
            public void success(String json) {
                toCall.success(json);
            }
        });
    }
}
