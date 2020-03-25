package com.bw.movie;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import base.BaseFragment;
import base.BasePresenter;

public class NaviFragment extends BaseFragment {
    TextView textView;


    @Override
    protected void inidata(Bundle savedInstanceState) {

    }

    @Override
    protected void iniview(View view) {
        textView=getActivity().findViewById(R.id.na);
        textView.setText("123123131213123");
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_navi_fragment;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
