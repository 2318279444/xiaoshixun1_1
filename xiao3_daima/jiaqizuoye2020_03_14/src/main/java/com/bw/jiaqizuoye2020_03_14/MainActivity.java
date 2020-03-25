package com.bw.jiaqizuoye2020_03_14;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import base.BaseActivity;
import base.BasePresenter;
import bean.DengluBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class MainActivity extends BaseActivity {
    EditText user,pwd;
    Button dl;
    @Override
    protected void inidata() {


        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String suser = user.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                Map<String,Object> map=new HashMap<>();
                map.put("phone",suser);
                map.put("pwd",spwd);
                NetUtil.getInstance().NetLogin(MyUrl.BASE_LOGIN, DengluBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        DengluBean dengluBean = gson.fromJson(stra, DengluBean.class);
                        String sessionId = dengluBean.getResult().getSessionId();
                        String status = dengluBean.getStatus();
                        if(status.equals("0000")){
                            Intent intent = new Intent(MainActivity.this,ShouYe.class);
                            intent.putExtra("sessionId",sessionId);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, dengluBean.getMessage()+status, Toast.LENGTH_SHORT).show();
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
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
