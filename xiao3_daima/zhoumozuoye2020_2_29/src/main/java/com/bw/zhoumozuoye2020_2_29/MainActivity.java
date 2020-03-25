package com.bw.zhoumozuoye2020_2_29;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import base.BaseActivity;
import base.BasePresenter;
import bean.DengLuBean;
import bean.ZhuCeBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class MainActivity extends BaseActivity {
    EditText user,pwd;
    Button denglu,zhuce;
    SharedPreferences sp;

    CheckBox zidongde,jizhu;

    @Override
    protected void inidata() {


        final SharedPreferences sp = getSharedPreferences("", Context.MODE_PRIVATE);
        boolean jizhu1 = sp.getBoolean("jizhu", false);
        if(jizhu1){
            String suser = sp.getString("suser", "");
            String spwd = sp.getString("spwd", "");
            user.setText(suser);
            pwd.setText(spwd);
            jizhu.setChecked(true);
        }

        boolean zidong = sp.getBoolean("zidong", false);
        if(zidong){
            Intent intent = new Intent(MainActivity.this,Book.class);
            startActivity(intent);
        }


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
            public void onClick(View view) {
                final String suser = user.getText().toString().trim();
                final String spwd = pwd.getText().toString().trim();

                String string = EncryptUtils.encryptMD5ToString(spwd);
                Log.e("aaa","密码加密"+string);
                final Map<String,Object> map=new HashMap<>();
                map.put("phone",suser);
                map.put("pwd",spwd);
                NetUtil.getInstance().NEtDenglu(MyUrl.BASEDENGLU, ZhuCeBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        DengLuBean dengLuBean = gson.fromJson(stra, DengLuBean.class);
                        String status = dengLuBean.getStatus();
                        String tel="^1[0-9]{10}$";
                        if(Pattern.compile(tel).matcher(suser).matches()){
                            if(status.equals("0000")){
                                boolean jizhua = jizhu.isChecked();
                                boolean zidonga = MainActivity.this.zidongde.isChecked();
                                SharedPreferences.Editor edit = sp.edit();

                                if(jizhua){
                                    edit .putString("suser",suser);
                                    edit.putString("spwd",spwd);
                                }
                                edit.putBoolean("jizhu",jizhua);
                                edit.putBoolean("zidong",zidonga);
                                boolean commit = edit.commit();
                                if(commit){
                                    Intent intent = new Intent(MainActivity.this,Book.class);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(MainActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                                }
                                Intent intent = new Intent(MainActivity.this,Book.class);
                                startActivity(intent);
                                Toast.makeText(MainActivity.this, dengLuBean.getMessage(), Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(MainActivity.this, dengLuBean.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "手机号输入有误", Toast.LENGTH_SHORT).show();
                        }




                    }
                });
            }
        });
    }

    @Override
    protected void iniview() {

        zidongde=findViewById(R.id.zidongde);
        jizhu=findViewById(R.id.jizhu);

        user=findViewById(R.id.user);
        pwd=findViewById(R.id.pwd);
        denglu=findViewById(R.id.denglu);
        zhuce=findViewById(R.id.zhuce);
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
