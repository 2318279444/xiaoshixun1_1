package com.bawei.weiduyingyuan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.blankj.utilcode.util.EncryptUtils;

import base.BaseActivity;

public class LoginActivity extends BaseActivity {
    Button denglu;
    TextView user,pwd,zhuce;
    CheckBox jizhu,zidong;



    @Override
    protected void inidata() {
        inizhuce();

        String string = EncryptUtils.encryptMD5ToString("d123456");
        Log.e("aaa",""+string);


    }



    @Override
    protected void iniview() {
        denglu=findViewById(R.id.denglu);
        user=findViewById(R.id.user);
        pwd=findViewById(R.id.pwd);
        zhuce=findViewById(R.id.zhuce);
        jizhu=findViewById(R.id.jizhu);
        zidong=findViewById(R.id.zidong);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_login;
    }




    private void inizhuce() {
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ZhuCeZH.class);
                startActivity(intent);
            }
        });
    }
}
