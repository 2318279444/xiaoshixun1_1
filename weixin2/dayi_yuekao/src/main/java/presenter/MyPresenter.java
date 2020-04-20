package presenter;

import com.bw.dayi_yuekao.ShouYe;

import base.BasePresenter;
import contract.Icontract;
import model.MyMolder;

public class MyPresenter extends BasePresenter {

    public MyMolder myMolder;
    public MyPresenter(){
        myMolder=new MyMolder();
    }

    public void p_Gwc(String url, Class cls){
        myMolder.m_Gwc(url, cls, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                ShouYe shouYe= (ShouYe) v;
                shouYe.success(stra);
            }
        });
    }

}
