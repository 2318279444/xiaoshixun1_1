package com.bw.movie.shouye_fragment.shouye_paiqi;

import android.os.Bundle;
import android.view.View;

import com.bw.movie.R;

import base.BaseFragment;
import base.BasePresenter;

public class Shouye_Paiqi_price extends BaseFragment {



    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String movieId = arguments.getString("movieId");
        String sessionId = arguments.getString("sessionId");
    }

    @Override
    protected void iniview(View view) {

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shouye__paiqi_price;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
