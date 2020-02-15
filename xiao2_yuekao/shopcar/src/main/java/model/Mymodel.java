package model;

import java.util.Map;

import contract.Icontract;
import util.NetUtil;

/*
 *@auther:邓先超
 *@Date: 2020/2/13
 *@Time:14:01
 *@Description:
 **/
public class Mymodel {
    public void mDingdan(String url, Class cls, Map<String,Object> map, Map<String,Object> map1, Icontract.ToCall toCall){
        NetUtil.getInstance().NetDingDan(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
