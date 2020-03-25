package presenter;

import com.bw.dengxianchao20200224.MyShou;

import java.util.Map;

import base.BasePresenter;
import contract.Icontract;
import model.Mymodel;

/*
 *@auther:邓先超
 *@Date: 2020/2/24
 *@Time:13:14
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    Mymodel mymodel;

    public MyPresenter(){
        mymodel=new Mymodel();
    }

    public void pliwu(String url, Class cls, Map<String ,Object> map, Map<String,Object>map1){
        mymodel.mliwu(url, cls, map, map1, new Icontract.Tocall() {
            @Override
            public void success(String stra) {
                MyShou myShou= (MyShou) v;
                myShou.success(stra);
            }
        });
    }
}
