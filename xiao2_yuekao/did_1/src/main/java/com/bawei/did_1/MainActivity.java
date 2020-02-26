package com.bawei.did_1;

import androidx.appcompat.app.AppCompatActivity;

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
import bean.DengluBean;
import bean.ZhuCeBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class MainActivity extends BaseActivity {
    EditText phone,pwd;
    Button zhuce,denglu;


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
                NetUtil.getInstance().NetZhuce(MyUrl.BASEZHUCE, ZhuCeBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        ZhuCeBean zhuCeBean = gson.fromJson(stra, ZhuCeBean.class);
                        String status = zhuCeBean.getStatus();
                        if(status.equals("0000")){
                            Toast.makeText(MainActivity.this, zhuCeBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, zhuCeBean.getMessage(), Toast.LENGTH_SHORT).show();
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
                Log.e("aaa","密码加密:"+string);
                Map<String,Object> map=new HashMap<>();
                map.put("phone",sphone);
                map.put("pwd",spwd);

                NetUtil.getInstance().NetDenglu(MyUrl.BASEDENGLU, DengluBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        DengluBean dengluBean = gson.fromJson(stra, DengluBean.class);
                        String status = dengluBean.getStatus();
                        String sessionId = dengluBean.getResult().getSessionId();
                        if(status.equals("0000")){
                            Intent intent = new Intent(MainActivity.this, ZhuYe.class);
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
        zhuce=findViewById(R.id.zhuce);
        denglu=findViewById(R.id.denglu);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_main;
    }
}
