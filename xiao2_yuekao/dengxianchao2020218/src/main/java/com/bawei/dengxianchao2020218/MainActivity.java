package com.bawei.dengxianchao2020218;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import base.BaseActivity;
import bean.DengluBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class MainActivity extends BaseActivity {
    EditText phone, pwd;
    Button denglu;
//    @BindView(R.id.phone)
//    EditText phone;
//    @BindView(R.id.pwd)
//    EditText pwd;
//    @BindView(R.id.denglu)
//    Button denglu;

    @Override
    protected void inidata() {

//        boolean connettion = NetUtil.getInstance().getConnettion(MainActivity.this);
//        if (connettion) {
            denglu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String sphone = phone.getText().toString().trim();
                    String spwd = pwd.getText().toString().trim();
                    Map<String, Object> map = new HashMap<>();
                    map.put("phone", sphone);
                    map.put("pwd", spwd);
                    NetUtil.getInstance().NetDenglu(MyUrl.BASEDENGLU, DengluBean.class, map, new Icontract.ToCall() {
                        @Override
                        public void success(String stra) {
                            Gson gson = new Gson();
                            DengluBean dengluBean = gson.fromJson(stra, DengluBean.class);
                            String status = dengluBean.getStatus();
                            String sessionId = dengluBean.getResult().getSessionId();
                            if (status.equals("0000")) {
                                Intent intent = new Intent(MainActivity.this, ShouyeDingdan.class);
                                Toast.makeText(MainActivity.this, dengluBean.getMessage(), Toast.LENGTH_SHORT).show();
                                intent.putExtra("sessionId", sessionId);
                                startActivity(intent);
                            }
                        }
                    });
                }
            });
//        } else {
//            Toast.makeText(this, "无网络", Toast.LENGTH_SHORT).show();
//        }

    }

    @Override
    protected void iniview() {
        phone = findViewById(R.id.phone);
        pwd = findViewById(R.id.pwd);
        denglu = findViewById(R.id.denglu);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
