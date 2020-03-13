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
import bean.LoginRegist.DengLuBean;
import contract.Icontract;
import encryption.EncryptUtil;
import url.MyUrl;
import util.NetUtil;

public class LoginActivity extends BaseActivity {
    Button denglu;
    TextView zhuce;
    CheckBox jizhu,zidong;
    EditText user,pwd;
    SharedPreferences sp;
    private String headPic;
    private String nickName;
    private String sex;
    private String cstime;
    private String email;


    @Override
    protected void inidata() {
        //注册
        inizhuce();

        //登录
        iniLogin();


        //记住账号密码,自动登录
        jizi();







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
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
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
                        String sessionId = dengLuBean.getResult().getSessionId();
                        //个人信息
                        headPic = dengLuBean.getResult().getUserInfo().getHeadPic();
                        nickName = dengLuBean.getResult().getUserInfo().getNickName();
                        int sexx = dengLuBean.getResult().getUserInfo().getSex();
                        sex = String.valueOf(sexx);
                        long lastLoginTime = dengLuBean.getResult().getUserInfo().getLastLoginTime();
                        cstime = String.valueOf(lastLoginTime);
                        email = dengLuBean.getResult().getUserInfo().getEmail();


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
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("sessionId",sessionId);
                                startActivity(intent);
                                finish();
                            }else {
                                Toast.makeText(LoginActivity.this,"登陆失败",Toast.LENGTH_LONG).show();
                            }



                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("sessionId",sessionId);

                            intent.putExtra("headPic",headPic);
                            intent.putExtra("nickName",nickName);
                            intent.putExtra("sex",sex);
                            intent.putExtra("cstime",cstime);
                            intent.putExtra("email",email);

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
