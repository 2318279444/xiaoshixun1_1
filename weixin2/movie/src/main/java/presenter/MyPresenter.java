package presenter;

import com.bw.movie.YingFragment.YingAction;
import com.bw.movie.YingFragment.YingFuJin;
import com.bw.movie.YingFragment.YingTuiJian;
import com.bw.movie.my.My_guanzhu;
import com.bw.movie.shouye_fragment.Jijiang_Movie_Shouye;
import com.bw.movie.shouye_fragment.Remen_Movie_Shouye;
import com.bw.movie.shouye_fragment.shouye_jsyp.Shouye_Mx_Juzhao;
import com.bw.movie.yingyuan.YingXiangqingFragment.MovieElaFragment;
import com.bw.movie.yingyuan.YingXiangqingFragment.MovieXQFragment;
import com.bw.movie.yingyuan.paiq.Paiqi_one;

import java.util.Map;

import base.BasePresenter;
import contract.Icontract;
import fragment.ShouYe;
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


    public void pShouyeMoview(String url,Class cls,Map<String,Object> map){
        mymodel.mShoyeMovie(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                ShouYe shouYe= (ShouYe) v;
                shouYe.success(stra);
            }
        });
    }



    public void pRemenMovie(String url,Class cls,Map<String,Object> map){
        mymodel.mRemenMovie(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Remen_Movie_Shouye remen_movie_shouye= (Remen_Movie_Shouye) v;
                remen_movie_shouye.success(stra);
            }
        });
    }


    public void pJijiangMovie(String url,Class cls,Map<String,Object> map,Map<String,Object> map1){
        mymodel.mJijiangMovie(url, cls, map,map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Jijiang_Movie_Shouye jijiang_movie_shouye= (Jijiang_Movie_Shouye) v;
                jijiang_movie_shouye.success(stra);
            }
        });
    }


    public void pShouye_Movie_XQ(String url,Class cls,Map<String,Object> map,Map<String,Object> map1){
        mymodel.mShouye_Movie_XQ(url, cls, map,map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {

            }
        });
    }



    public void pYing_Paiqi(String url,Class cls,Map<String,Object> map){
        mymodel.mYing_Paiqi(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Paiqi_one paiqi_one= (Paiqi_one) v;
                paiqi_one.success(stra);
            }
        });
    }






    public void p_Juzhao(String url,Class cls,Map<String,Object> map,Map<String,Object> map1){
        mymodel.m_Juzhao(url, cls, map,map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Shouye_Mx_Juzhao shouye_mx_juzhao= (Shouye_Mx_Juzhao) v;
                shouye_mx_juzhao.success(stra);
            }
        });
    }





    







}
