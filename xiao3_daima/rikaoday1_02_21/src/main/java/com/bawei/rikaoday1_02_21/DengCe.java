package com.bawei.rikaoday1_02_21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.rikaoday1_02_21.fragment.WoDe;
import com.blankj.utilcode.util.EncryptUtils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import base.BaseActivity;
import base.BaseFragment;
import base.BasePresenter;
import bean.DengLuBean;
import bean.ZhuCeBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class DengCe extends BaseActivity {
    EditText user,pwd;
    Button denglu,zhuce;



    @Override
    protected void inidata() {
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String suser = user.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                Map<String,Object> map=new HashMap<>();
                map.put("phone",suser);
                map.put("pwd",spwd);
                NetUtil.getInstance().NetZhuce(MyUrl.BASEZHUCE, ZhuCeBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        ZhuCeBean zhuCeBean = gson.fromJson(stra, ZhuCeBean.class);
                        String status = zhuCeBean.getStatus();
                        if(status.equals("0000")){
                            Toast.makeText(DengCe.this, zhuCeBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(DengCe.this, zhuCeBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });




        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String suser = user.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();

                String string = EncryptUtils.encryptMD5ToString(spwd);
                Log.e("aaa","密码加密"+string);
                Map<String,Object> map=new HashMap<>();
                map.put("phone",suser);
                map.put("pwd",spwd);
                NetUtil.getInstance().NEtDenglu(MyUrl.BASEDENGLU, ZhuCeBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        DengLuBean dengLuBean = gson.fromJson(stra, DengLuBean.class);
                        String headPic = dengLuBean.getResult().getHeadPic();
                        String status = dengLuBean.getStatus();
                        if(status.equals("0000")){
                            Intent intent = new Intent(DengCe.this,MainActivity.class);
                            intent.putExtra("headPic",headPic);
                            startActivity(intent);
                            Toast.makeText(DengCe.this, dengLuBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(DengCe.this, dengLuBean.getMessage(), Toast.LENGTH_SHORT).show();
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
        denglu=findViewById(R.id.denglu);
        zhuce=findViewById(R.id.zhuce);
    }
    @Override
    protected int inilayout() {
        return R.layout.activity_deng_ce;
    }
}
