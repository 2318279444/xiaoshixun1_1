package com.bawei.weiduyingyuan.YingFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bawei.weiduyingyuan.R;

import base.BaseFragment;
import base.BasePresenter;

public class YingAction extends BaseFragment {


    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String sessionId = arguments.getString("sessionId");
        Log.e("aaa","yingaction:sessionId:"+sessionId);
    }

    @Override
    protected void iniview(View view) {

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_ying_action;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
