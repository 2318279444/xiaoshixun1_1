package model;

import java.util.Map;

import contract.Icontract;
import util.NetUtil;

/*
 *@auther:邓先超
 *@Date: 2020/2/18
 *@Time:9:19
 *@Description:
 **/
public class Mymodel {
    public void mSous(String url, Class cls, Map<String,Object> map, Icontract.ToCall toCall){
        NetUtil.getInstance().NetShouye(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }

    public void mDD(String url,Class cls,Map<String,Object> map,Map<String,Object> map1,Icontract.ToCall toCall){
        NetUtil.getInstance().NetDD(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
