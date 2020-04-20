package com.bw.dayi_yuekao;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import base.BaseActivity;
import base.BasePresenter;
import bean.DlBean;
import bean.ZcBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class MainActivity extends BaseActivity {
 EditText user,pwd;
 Button dl,zc;
    private String suser;
    private String spwd;


    @Override
    protected int inilayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }

    @Override
    protected void inidata() {

        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suser = user.getText().toString().trim();
                spwd = pwd.getText().toString().trim();

                Map<String,Object> map=new HashMap<>();
                map.put("phone",suser);
                map.put("pwd",spwd);

                NetUtil.getInstance().NEt_Zc(MyUrl.BASEZC, ZcBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        ZcBean zcBean = gson.fromJson(stra, ZcBean.class);
                        String status = zcBean.getStatus();
                        if(status.equals("0000")){
                            Toast.makeText(MainActivity.this, zcBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, zcBean.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });



        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                suser = user.getText().toString().trim();
                spwd = pwd.getText().toString().trim();

                Map<String,Object> map=new HashMap<>();
                map.put("phone",suser);
                map.put("pwd",spwd);

                NetUtil.getInstance().NEt_Dl(MyUrl.BASEDL, DlBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        DlBean dlBean = gson.fromJson(stra, DlBean.class);
                        String status = dlBean.getStatus();
                        if(status.equals("0000")){
                            Intent intent = new Intent(MainActivity.this, ShouYe.class);
                            startActivity(intent);
                            Log.e("aaa","staus"+dlBean.getStatus());
                            Toast.makeText(MainActivity.this, dlBean.getMessage(), Toast.LENGTH_SHORT).show();


                        }else {
                            Toast.makeText(MainActivity.this, dlBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }

    @Override
    protected void iniview() {
        user=findViewById(R.id.user);
        pwd=findViewById(R.id.pwd);
        dl=findViewById(R.id.dl);
        zc=findViewById(R.id.zc);
    }
}
