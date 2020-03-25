package presenter;

import com.bw.dengxianchao20200316.DengluMain;
import com.bw.dengxianchao20200316.ZhuceMain;

import java.util.Map;

import base.BasePresenter;
import contract.Icontract;
import model.MyModel;

/*
 *@auther:邓先超
 *@Date: 2020/3/16
 *@Time:8:37
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    public MyModel myModel;

    public MyPresenter(){
        myModel=new MyModel();
    }

    public void pDenglu(String url, Class cls, Map<String,Object> map){
        myModel.mDenglu(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                DengluMain dengluMain= (DengluMain) v;
                dengluMain.success(stra);
            }
        });
    }

    public void pZhuce(String url, Class cls, Map<String,Object> map){
        myModel.mZhuce(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                ZhuceMain zhuceMain= (ZhuceMain) v;
                zhuceMain.success(stra);
            }
        });
    }
}
