package presenter;

import com.bawei.dengxianchao2020218.Quanbu;

import java.util.Map;

import base.BasePresenter;
import contract.Icontract;
import model.Mymodel;

/*
 *@auther:邓先超
 *@Date: 2020/2/18
 *@Time:9:19
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    Mymodel mymodel;
    public MyPresenter(){
        mymodel=new Mymodel();
    }


    public void pDD(String url,Class cls,Map<String,Object> map,Map<String,Object> map1){
        mymodel.mDD(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Quanbu quanbu= (Quanbu) v;
                quanbu.success(stra);
            }
        });
    }

}
