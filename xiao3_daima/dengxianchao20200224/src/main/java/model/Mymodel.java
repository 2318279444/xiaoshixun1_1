package model;

import java.util.Map;

import contract.Icontract;
import util.NetUtil;

/*
 *@auther:邓先超
 *@Date: 2020/2/24
 *@Time:13:16
 *@Description:
 **/
public class Mymodel {
    public void mliwu(String url, Class cls, Map<String ,Object> map, Map<String,Object>map1, Icontract.Tocall tocall){
        NetUtil.getInstance().NetLiwu(url, cls, map, map1, new Icontract.Tocall() {
            @Override
            public void success(String stra) {
                tocall.success(stra);
            }
        });
    }
}
