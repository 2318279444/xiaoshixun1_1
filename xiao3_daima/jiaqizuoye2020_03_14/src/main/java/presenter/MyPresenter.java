package presenter;

import com.bawei.jiaqizuoye2020_03_14.ShouYe;

import java.util.Map;

import base.BasePresenter;
import contract.Icontract;
import model.Mymodel;

/*
 *@auther:邓先超
 *@Date: 2020/3/14
 *@Time:10:30
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    public Mymodel mymodel;

    public MyPresenter(){
        mymodel=new Mymodel();
    }

    public void pShop(String url, Class cls, Map<String,Object> map){
        mymodel.mShop(url, cls, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                ShouYe shouYe= (ShouYe) v;
                shouYe.success(stra);
            }
        });
    }
}
