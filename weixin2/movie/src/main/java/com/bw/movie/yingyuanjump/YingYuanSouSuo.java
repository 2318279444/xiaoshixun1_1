package com.bw.movie.yingyuanjump;

import android.view.View;
import android.widget.ImageView;

import com.bw.movie.R;

import base.BaseActivity;

public class YingYuanSouSuo extends BaseActivity {
    ImageView yingyuanfanhui;

    @Override
    protected void inidata() {
        //回退到影院页面
        yingyuanfanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }

    @Override
    protected void iniview() {
        yingyuanfanhui=findViewById(R.id.yingyuanfanhui);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_ying_yuan_sou_suo;
    }
}
