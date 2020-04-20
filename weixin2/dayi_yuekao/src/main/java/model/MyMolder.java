package model;

import contract.Icontract;
import util.NetUtil;

public class MyMolder {
    public void m_Gwc(String url, Class cls, final Icontract.ToCall toCall){
        NetUtil.getInstance().NEt_Gwc(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }
}
