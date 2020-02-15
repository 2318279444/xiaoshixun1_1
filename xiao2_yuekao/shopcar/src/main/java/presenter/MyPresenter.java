package presenter;

import com.bawei.shopcar.Quanbu;

import java.util.Map;

import base.BasePresenter;
import contract.Icontract;
import model.Mymodel;

/*
 *@auther:邓先超
 *@Date: 2020/2/13
 *@Time:14:01
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    public Mymodel mymodel;

    public MyPresenter(){
        mymodel=new Mymodel();
    }

    public void pDingdan(String url, Class cls, Map<String,Object> map, Map<String,Object> map1){
        mymodel.mDingdan(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Quanbu quanbu= (Quanbu) v;
                quanbu.success(stra);
            }
        });
    }
}
