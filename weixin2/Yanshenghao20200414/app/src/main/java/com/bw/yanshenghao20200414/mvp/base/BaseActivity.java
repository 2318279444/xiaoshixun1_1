package com.bw.yanshenghao20200414.mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.yanshenghao20200414.mvp.contract.Contract;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseActivity <P extends BasePresenter>extends AppCompatActivity implements Contract.IView {

    public P mPresenter;
    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Layout()!=0){
            setContentView(Layout());
            mPresenter=initPresenter();
            if (mPresenter != null) {
                mPresenter.Attch(this);
            }
            bind = ButterKnife.bind(this);
            initView();
            startCoding();
        }


    }

    protected abstract void startCoding();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract int Layout();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onEnd();
        }
    }
}
