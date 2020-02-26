package presenter;

import com.bawei.did_1.fragment.Quanbu;

import java.util.Map;

import base.BasePresenter;
import contract.Icontract;
import model.Mymodel;

/*
 *@auther:邓先超
 *@Date: 2020/2/17
 *@Time:13:41
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    public Mymodel mymodel;
    public MyPresenter(){
        mymodel=new Mymodel();
    }

    public void pDd(String url, Class cls, Map<String,Object> map, Map<String,Object> map1){
        mymodel.mDd(url, cls, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Quanbu quanbu= (Quanbu) v;
                quanbu.success(stra);
            }
        });
    }
}
