package presenter;

import com.bw.dengxianchao2020_03_09.Hot;
import com.bw.dengxianchao2020_03_09.Now;

import java.util.Map;

import base.BasePresenter;
import contract.Icontract;
import model.MyModel;

/*
 *@auther:邓先超
 *@Date: 2020/3/9
 *@Time:13:20
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    MyModel myModel;

    public MyPresenter(){
        myModel=new MyModel();
    }

    public void pNow(String url, Class cls, Map<String,Object> map){
        myModel.mNow(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Now now= (Now) v;
                now.success(stra);
            }
        });
    }

    public void pHot(String url, Class cls, Map<String,Object> map){
        myModel.mHot(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Hot hot= (Hot) v;
                hot.success(stra);
            }
        });
    }
}
