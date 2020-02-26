package model;

import java.util.Map;

import contract.Icontract;
import util.NetUtil;

/*
 *@auther:邓先超
 *@Date: 2020/2/26
 *@Time:14:21
 *@Description:
 **/
public class Mymodel {
    public void mDenglu(String url, Class cls, Map<String,Object> map, Icontract.ToCall toCall){
        NetUtil.getInstance().NetDenglu(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
