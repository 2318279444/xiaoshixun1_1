package com.bw.mvcmvp_project2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
import bean.LoginBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class MainActivity extends BaseActivity {
    EditText user,pwd;
    Button btn;


    @Override
    protected void inidata() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String suser = user.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                Map<String,Object> map=new HashMap<>();
                map.put("phone",suser);
                map.put("pwd",spwd);
                NetUtil.getInstance().Net_Login(MyUrl.BASE_Login, LoginBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        LoginBean loginBean = gson.fromJson(stra, LoginBean.class);
                        String status = loginBean.getStatus();
                        Log.e("aaa",""+status);
                        if(status.equals("0000")){
                            Toast.makeText(MainActivity.this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();

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
        btn=findViewById(R.id.btn);
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
