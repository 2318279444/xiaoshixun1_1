package com.bawei.dengxianchao2020_03_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import base.BaseAcitivity;
import base.BasePresenter;
import bean.DengLuBean;
import bean.ZhuceBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class MainActivity extends BaseAcitivity {
    EditText phone,pwd;
    Button zhuce,denglu;
    CheckBox jizhuu;

    SharedPreferences sp;

    @Override
    protected void inidata() {


//        SharedPreferences sp = getSharedPreferences("", Context.MODE_PRIVATE);
//
//        boolean jizhu1 = sp.getBoolean("jizhua", false);
//        if(jizhu1){
//            String sphoneed = sp.getString("sphone", "");
//            String spwded = sp.getString("spwd", "");
//            phone.setText(sphoneed);
//            pwd.setText(spwded);
//            jizhuu.setChecked(true);
//        }

//
//        SharedPreferences sharedPreferences = getSharedPreferences("", Context.MODE_PRIVATE);
//        boolean jz = sharedPreferences.getBoolean("jz", false);
//        if (jz){
//            String sphone = sharedPreferences.getString("sphone", "");
//            String spwd = sharedPreferences.getString("spwd", "");
//            phone.setText(sphone);
//            pwd.setText(spwd);
//        }


        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sphone = phone.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                Map<String,Object> map=new HashMap<>();
                map.put("phone",sphone);
                map.put("pwd",spwd);
                NetUtil.getInstance().NetZhuce(MyUrl.BASEZhuce, ZhuceBean.class, map, new Icontract.ToCall() {
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
            public void onClick(View view) {
                 final String sphone = phone.getText().toString().trim();
                 final String spwd = pwd.getText().toString().trim();
                Map<String,Object> map=new HashMap<>();
                map.put("phone",sphone);
                map.put("pwd",spwd);
                NetUtil.getInstance().NetZhuce(MyUrl.BASEDENGLU, DengLuBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        DengLuBean dengLuBean = gson.fromJson(stra, DengLuBean.class);
                        String status = dengLuBean.getStatus();
                        if(status.equals("0000")){
//                            SharedPreferences.Editor edit = sp.edit();
//                            boolean jizhu = jizhuu.isChecked();
//                            if(jizhu){
//                                edit.putString("sphone",sphone);
//                                edit.putString("spwd",spwd);
//                            }
//                            edit.putBoolean("jz",jizhu);
//                            boolean commit = edit.commit();


//                            edit = sp1.edit();
//                            boolean jizhu =jizhuu.isChecked();
//
//                            if(jizhu){
//                                edit.putString("sphone",sphone);
//                                edit.putString("spwd",spwd);
//                            }
//                            edit.putBoolean("jizhua",jizhu);
//                            boolean commit = edit.commit();
//                            if(commit){
//                                Intent intent = new Intent(MainActivity.this, ShopMianActivity.class);
//                                startActivity(intent);
//                            }


                            Intent intent = new Intent(MainActivity.this, ShopMianActivity.class);
                            Toast.makeText(MainActivity.this, dengLuBean.getMessage(), Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }else {
                            Toast.makeText(MainActivity.this, dengLuBean.getMessage(), Toast.LENGTH_SHORT).show();
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
        jizhuu=findViewById(R.id.jizhu);
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
