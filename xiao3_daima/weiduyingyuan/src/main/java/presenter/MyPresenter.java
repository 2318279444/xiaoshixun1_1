package presenter;

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
}
