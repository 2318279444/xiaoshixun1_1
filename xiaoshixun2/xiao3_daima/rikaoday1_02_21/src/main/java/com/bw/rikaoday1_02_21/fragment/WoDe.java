package com.bw.rikaoday1_02_21.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.rikaoday1_02_21.DengCe;
import com.bw.rikaoday1_02_21.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import base.BaseFragment;
import base.BasePresenter;

public class WoDe extends BaseFragment {
    TextView dz;
    ImageView imageView;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        //使用Argunents传值,吧头像信息传递过来;
        Bundle arguments = getArguments();

        //实例化头像信息
        String headPic = arguments.getString("headPic");

        //使用Glide展示头像,并且实现圆形图片

        Glide.with(getActivity()).load(headPic)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                .into(imageView);


        //点击跳到登陆页面
        dz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DengCe.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void iniview(View view) {
        dz=getActivity().findViewById(R.id.dz);
        imageView=getActivity().findViewById(R.id.ima);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_wo_de;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
