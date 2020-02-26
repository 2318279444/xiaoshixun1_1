package presenter;

import com.bawei.zhoumozuoye2020_02_22.JiJang;
import com.bawei.zhoumozuoye2020_02_22.ZhengZai;

import base.BasePresenter;
import contract.Icontract;
import model.Mymodel;

/*
 *@auther:邓先超
 *@Date: 2020/2/22
 *@Time:15:44
 *@Description:
 **/
public class MyPresenter extends BasePresenter {
    Mymodel mymodel;
    public MyPresenter(){
        mymodel=new Mymodel();
    }

    public void pZhengzai(String url,Class cls){
        mymodel.mZhengzai(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                ZhengZai zhengZai= (ZhengZai) v;
                zhengZai.success(stra);
            }
        });
    }


}
