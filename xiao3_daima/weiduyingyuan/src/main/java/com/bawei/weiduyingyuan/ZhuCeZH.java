package com.bawei.weiduyingyuan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import base.BaseActivity;

public class ZhuCeZH extends BaseActivity {

    TextView zhucefinnish;
    @Override
    protected void inidata() {
       zcfinish();
    }



    @Override
    protected void iniview() {
        zhucefinnish=findViewById(R.id.zhucefinish);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_zhu_ce_zh;
    }

    //完成注册返回登录页面
    private void zcfinish() {
        zhucefinnish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
