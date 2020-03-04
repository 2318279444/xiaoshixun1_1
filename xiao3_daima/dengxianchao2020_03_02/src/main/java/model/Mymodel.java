package model;

import contract.Icontract;
import util.NetUtil;

/*
 *@auther:邓先超
 *@Date: 2020/3/2
 *@Time:13:07
 *@Description:
 **/
public class Mymodel {
    public void mShop(String url, Class cls, final Icontract.ToCall toCall){
        NetUtil.getInstance().NetShop(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
