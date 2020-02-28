package com.bawei.weiduyingyuan.flzc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.weiduyingyuan.MainActivity;
import com.bawei.weiduyingyuan.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import base.BaseActivity;
import bean.DengLuBean;
import contract.Icontract;
import encryption.EncryptUtil;
import url.MyUrl;
import util.NetUtil;

public class LoginActivity extends BaseActivity {
    Button denglu;
    TextView zhuce,tglogin;
    CheckBox jizhu,zidong;
    EditText user,pwd;
    SharedPreferences sp;



    @Override
    protected void inidata() {
        //注册
        inizhuce();

        //登录
        iniLogin();


        //记住账号密码,自动登录
        jizi();


        //游客模式登录
        initglogin();




    }

    private void initglogin() {
        tglogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                Toast.makeText(LoginActivity.this, "游客模式登录", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void jizi() {
        sp=getSharedPreferences("", Context.MODE_PRIVATE);
        boolean jizhub = sp.getBoolean("jizhu", false);
        if(jizhub){
            String userjizhu = sp.getString("user", "");
            String pwdjizhu = sp.getString("pwd", "");
            user.setText(userjizhu);
            pwd.setText(pwdjizhu);
            jizhu.setChecked(true);
        }

        boolean zidongb = sp.getBoolean("zidong", false);
        if(zidongb){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }

        jizhu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b){
                    zidong.setChecked(false);
                }
            }
        });

        zidong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                jizhu.setChecked(b);
            }
        });
    }


    @Override
    protected void iniview() {
        denglu=findViewById(R.id.denglu);
        user=findViewById(R.id.user);
        pwd=findViewById(R.id.pwd);
        zhuce=findViewById(R.id.zhuce);
        jizhu=findViewById(R.id.jizhu);
        zidong=findViewById(R.id.zidong);
        tglogin=findViewById(R.id.tgLogin);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_login;
    }




   //注册
    private void inizhuce() {
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ZhuCeZH.class);
                startActivity(intent);
            }
        });
    }




    //登录
    private void iniLogin() {
        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String suser = user.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                String encrypt = EncryptUtil.encrypt(spwd);

                Map<String,Object> map=new HashMap<>();
                map.put("email",suser);
                map.put("pwd",encrypt);

                NetUtil.getInstance().NetDenglu(MyUrl.BASEDengLu, DengLuBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        DengLuBean dengLuBean = gson.fromJson(stra, DengLuBean.class);
                        String status = dengLuBean.getStatus();
                        if(status.equals("0000")){

                            boolean jizhua = jizhu.isChecked();
                            boolean zidonga = zidong.isChecked();
                            SharedPreferences.Editor edit = sp.edit();
                            if(jizhua){
                                edit.putString("user",suser);
                                edit.putString("pwd",spwd);
                            }
                            edit.putBoolean("jizhu",jizhua);
                            edit.putBoolean("zidong",zidonga);
                            boolean commit = edit.commit();

                            if(commit){
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                finish();
                            }else {
                                Toast.makeText(LoginActivity.this,"登陆失败",Toast.LENGTH_LONG).show();
                            }



                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(LoginActivity.this, dengLuBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(LoginActivity.this, dengLuBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
