package model;

import java.util.Map;

import contract.Icontract;
import util.NetUtil;

/*
 *@auther:邓先超
 *@Date: 2020/3/16
 *@Time:8:37
 *@Description:
 **/
public class MyModel {
    public void mDenglu(String url, Class cls, Map<String,Object> map, final Icontract.ToCall toCall){
        NetUtil.getInstance().NetDenglu(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }

    public void mZhuce(String url, Class cls, Map<String,Object> map, final Icontract.ToCall toCall){
        NetUtil.getInstance().NetZhuce(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
