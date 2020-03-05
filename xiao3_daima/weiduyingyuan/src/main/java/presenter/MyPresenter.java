package presenter;

import com.bawei.weiduyingyuan.YingFragment.YingAction;
import com.bawei.weiduyingyuan.YingFragment.YingFuJin;
import com.bawei.weiduyingyuan.YingFragment.YingTuiJian;
import com.bawei.weiduyingyuan.yingyuan.YingXiangqingFragment.MovieElaFragment;
import com.bawei.weiduyingyuan.yingyuan.YingXiangqingFragment.MovieXQFragment;

import java.util.Map;

import base.BasePresenter;
import contract.Icontract;
import model.Mymodel;

/*
 *@auther:邓先超
 *@Date: 2020/2/26
 *@Time:14:21
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    Mymodel mymodel;
    public MyPresenter(){
        mymodel=new Mymodel();
    }

    public void pDenglu(String url, Class cls, Map<String,Object> map){
        mymodel.mDenglu(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {

            }
        });
    }

    public void preCommendMovie(String url,Class cls,Map<String,Object> map,Map<String,Object> map1){
        mymodel.mRecommendMovie(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                YingTuiJian yingTuiJian= (YingTuiJian) v;
                yingTuiJian.success(stra);
            }
        });
    }

    public void pFujinMovie(String url,Class cls,Map<String,Object> map,Map<String,Object> map1){
        mymodel.mFujinMovie(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                YingFuJin fuJin= (YingFuJin) v;
                fuJin.success(stra);
            }
        });
    }


    public void pXqLeft(String url,Class cls,Map<String,Object> map,Map<String,Object> map1){
        mymodel.mFujinMovie(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                MovieXQFragment movieXQFragment= (MovieXQFragment) v;
                movieXQFragment.success(stra);
            }
        });
    }

    public void pPLRight(String url,Class cls,Map<String,Object> map,Map<String,Object> map1){
        mymodel.mPLRight(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                MovieElaFragment movieElaFragment= (MovieElaFragment) v;
                movieElaFragment.success(stra);
            }
        });
    }


    public void p_Location_Left(String url,Class cls){
        mymodel.m_Location_Left(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                YingAction yingAction= (YingAction) v;
                yingAction.success(stra);
            }
        });
    }








}
