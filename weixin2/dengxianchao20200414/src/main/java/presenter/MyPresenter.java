package presenter;

import com.bw.dengxianchao20200414.GwcActivity;

import base.BasePresenter;
import contract.Icontract;
import model.MyModel;

public class MyPresenter extends BasePresenter {
    MyModel myModel;
    public MyPresenter(){
        myModel=new MyModel();
    }


    public void p_Gwc(String url, Class cls){
        myModel.m_Gwc(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                GwcActivity gwcActivity=new GwcActivity();
                gwcActivity.success(stra);
            }
        });
    }
}
