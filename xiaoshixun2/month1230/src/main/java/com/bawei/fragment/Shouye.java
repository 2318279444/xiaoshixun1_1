package com.bawei.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bawei.base.BaseFragment;
import com.bawei.base.BasePresenter;
import com.bawei.month1230.R;

import org.greenrobot.eventbus.EventBus;

public class Shouye extends BaseFragment {



    @Override
    protected void inidata(Bundle savedInstanceState) {
        EventBus.getDefault().post("123");
    }

    @Override
    protected void iniview(View view) {

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shouye;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
