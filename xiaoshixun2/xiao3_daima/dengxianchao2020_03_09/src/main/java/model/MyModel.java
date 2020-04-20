package model;

import java.util.Map;

import contract.Icontract;
import util.NetUtil;

/*
 *@auther:邓先超
 *@Date: 2020/3/9
 *@Time:13:20
 *@Description:
 **/
public class MyModel {

    public void mNow(String url, Class cls, Map<String,Object> map, final Icontract.ToCall toCall){
        NetUtil.getInstance().NetNow(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }

    public void mHot(String url, Class cls, Map<String,Object> map, final Icontract.ToCall toCall){
        NetUtil.getInstance().NetHot(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
