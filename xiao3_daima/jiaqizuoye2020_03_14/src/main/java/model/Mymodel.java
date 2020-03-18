package model;

import java.util.Map;

import contract.Icontract;
import util.NetUtil;

/*
 *@auther:邓先超
 *@Date: 2020/3/14
 *@Time:10:30
 *@Description:
 **/
public class Mymodel {
    public void mShop(String url, Class cls, Map<String,Object> map, final Icontract.ToCall toCall){
        NetUtil.getInstance().NetShop(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }

}
