package com.bawei.weiduyingyuan.shouye_fragment.shouye_jsyp;

import android.os.Bundle;
import android.view.View;

import com.bawei.weiduyingyuan.R;

import base.BaseFragment;
import base.BasePresenter;
import contract.Icontract;
import presenter.MyPresenter;

public class Shouye_MX_YingPin extends BaseFragment implements Icontract.ToCall {


    @Override
    protected void inidata(Bundle savedInstanceState) {

    }

    @Override
    protected void iniview(View view) {

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shouye__mx__ying_pin;

    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {

    }
}
