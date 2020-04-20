package com.bw.movie.ydy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.flzc.LoginActivity;

import base.BaseFragment;
import base.BasePresenter;

public class ydy2 extends BaseFragment {
    TextView textView;


    @Override
    protected void inidata(Bundle savedInstanceState) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
    }

    @Override
    protected void iniview(View view) {
        textView=getActivity().findViewById(R.id.ydy_tg);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_ydy2;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
