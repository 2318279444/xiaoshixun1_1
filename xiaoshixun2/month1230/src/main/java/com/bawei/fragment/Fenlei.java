package com.bawei.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bawei.base.BaseFragment;
import com.bawei.base.BasePresenter;
import com.bawei.month1230.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Fenlei extends BaseFragment {



    @Override
    protected void inidata(Bundle savedInstanceState) {



    }




    @Override
    protected void iniview(View view) {

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_fenlei;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
