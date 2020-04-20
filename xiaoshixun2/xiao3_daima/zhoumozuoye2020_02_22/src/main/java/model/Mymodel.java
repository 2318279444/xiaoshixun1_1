package model;

import contract.Icontract;
import util.NetUtil;

/*
 *@auther:邓先超
 *@Date: 2020/2/22
 *@Time:15:44
 *@Description:
 **/
public class Mymodel {
    public void mZhengzai(String url, Class cls, Icontract.ToCall toCall){
        NetUtil.getInstance().NetZhengzai(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }

    public void mJi(String url, Class cls, Icontract.ToCall toCall){
        NetUtil.getInstance().NetZhengzai(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
