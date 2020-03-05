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


    public void mRecommendMovie(String url,Class cls,Map<String,Object> map,Map<String,Object> map1,Icontract.ToCall toCall){
        NetUtil.getInstance().NetRecommendMovie(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }

    public void mFujinMovie(String url,Class cls,Map<String,Object> map,Map<String,Object> map1,Icontract.ToCall toCall){
        NetUtil.getInstance().NetFujinMovie(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }

    public void mXqLeft(String url,Class cls,Map<String,Object> map,Map<String,Object> map1,Icontract.ToCall toCall){
        NetUtil.getInstance().NetXqLeft(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }

    public void mPLRight(String url,Class cls,Map<String,Object> map,Map<String,Object> map1,Icontract.ToCall toCall){
        NetUtil.getInstance().NetPLRight(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }


    public void m_Location_Left(String url,Class cls,Icontract.ToCall toCall){
        NetUtil.getInstance().Net_Location_Left(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }

    public void mLocation_Right(String url,Class cls,Map<String,Object> map,Icontract.ToCall toCall){
        NetUtil.getInstance().NetLocation_Right(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                toCall.success(stra);
            }
        });
    }




}
