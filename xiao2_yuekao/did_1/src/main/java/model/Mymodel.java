package model;

import java.util.Map;

import contract.Icontract;
import util.NetUtil;

/*
 *@auther:邓先超
 *@Date: 2020/2/17
 *@Time:13:41
 *@Description:
 **/
public class Mymodel {
    public void mDd(String url, Class cls, Map<String,Object>map, Map<String,Object> map1, Icontract.ToCall toCall){
        NetUtil.getInstance().NetDd(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
