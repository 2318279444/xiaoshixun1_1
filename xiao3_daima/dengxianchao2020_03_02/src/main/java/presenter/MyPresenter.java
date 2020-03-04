package presenter;

import com.bawei.dengxianchao2020_03_02.ShopMianActivity;

import base.BasePresenter;
import contract.Icontract;
import model.Mymodel;

/*
 *@auther:邓先超
 *@Date: 2020/3/2
 *@Time:13:07
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    Mymodel mymodel;
    public MyPresenter(){
        mymodel=new Mymodel();
    }

    public void pShop(String url, Class cls){
        mymodel.mShop(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                ShopMianActivity shopMianActivity= (ShopMianActivity) v;
                shopMianActivity.success(stra);
            }
        });
    }
}
