package com.bawei.rikao0107;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.presenter.MyPresenter;

public class Tijiao extends BaseActivity {



    @Override
    protected void inidata() {

    }

    @Override
    protected void iniview() {

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_tijiao;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }
}
