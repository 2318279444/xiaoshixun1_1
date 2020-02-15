package com.bawei.shopcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import base.BaseActivity;
import base.BasePresenter;
import bean.DengluBean;
import bean.ZhuceBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class MainActivity extends BaseActivity {
    EditText phone ,pwd;
    Button denglu,zhuce;
    @Override
    protected int inilayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void inidata() {
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sphone = phone.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                Map<String,Object> map=new HashMap<>();
                map.put("phone",sphone);
                map.put("pwd",spwd);
                NetUtil.getInstance().NetZhuce(MyUrl.ZHUCE, ZhuceBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        ZhuceBean zhuceBean = gson.fromJson(stra, ZhuceBean.class);
                        String status = zhuceBean.getStatus();
                        if(status.equals("0000")){
                            Toast.makeText(MainActivity.this, zhuceBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, zhuceBean.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });


        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sphone = phone.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                String string = EncryptUtils.encryptMD5ToString(spwd);
                Log.e("aaa","加密:"+string);
                Map<String,Object> map=new HashMap<>();
                map.put("phone",sphone);
                map.put("pwd",spwd);
                NetUtil.getInstance().NetDenglu(MyUrl.DENGLU, DengluBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        DengluBean dengluBean = gson.fromJson(stra, DengluBean.class);
                        String status = dengluBean.getStatus();
                        String sessionId = dengluBean.getResult().getSessionId();
//                        Bundle bundle = new Bundle();
//                        bundle.putString("sessionId",sessionId);
//                        quanbu.setArguments(bundle);


                        if(status.equals("0000")){
                            Intent intent = new Intent(MainActivity.this, ShouYe.class);
                            intent.putExtra("sessionId",sessionId);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, dengluBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, dengluBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }


    @Override
    protected void iniview() {
        phone=findViewById(R.id.phone);
        pwd=findViewById(R.id.pwd);
        denglu=findViewById(R.id.denglu);
        zhuce=findViewById(R.id.zhuce);
    }
}
