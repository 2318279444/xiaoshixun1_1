package com.bawei.weiduyingyuan.flzc;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.weiduyingyuan.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import base.BaseActivity;
import bean.LoginRegist.EmailBean;
import bean.LoginRegist.ZhuCeBean;
import contract.Icontract;
import encryption.EncryptUtil;
import url.MyUrl;
import util.NetUtil;

public class ZhuCeZH extends BaseActivity  {

    TextView zhucefinnish;
    EditText putname,putemail,putpwd,putyzm;
    Button huoqu,zcyzc;


    @Override
    protected void inidata() {
        //注册页面回到登陆页面
       zcfinish();


       //获取验证码
        iniGetYzm();


        //注册
        iniZC();




    }

    private void iniZC() {
        zcyzc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sname = putname.getText().toString().trim();
                String spwd = putpwd.getText().toString().trim();
                String semail = putemail.getText().toString().trim();
                String syzm = putyzm.getText().toString().trim();

                String encryptspwd = EncryptUtil.encrypt(spwd);
                String encryptspwd1 = EncryptUtil.encrypt("d123456");

                Log.e("aaa","密码d123456:"+encryptspwd1);
                Map<String,Object> map=new HashMap<>();
                map.put("nickName",sname);
                map.put("pwd",encryptspwd);
                map.put("email",semail);
                map.put("code",syzm);
                if(sname.isEmpty()||spwd.isEmpty()||syzm.isEmpty()||syzm.isEmpty()){
                    Toast.makeText(ZhuCeZH.this, "信息不可以为空", Toast.LENGTH_SHORT).show();
                }else {
                    NetUtil.getInstance().NetZhuce(MyUrl.BASEZHUCE, ZhuCeBean.class, map, new Icontract.ToCall() {
                        @Override
                        public void success(String stra) {
                            Gson gson = new Gson();
                            ZhuCeBean zhuCeBean = gson.fromJson(stra, ZhuCeBean.class);
                            String status = zhuCeBean.getStatus();
                            Log.e("aaa","注册的状态码"+status);
                            if(status.equals("0000")){
                                finish();
                                Log.e("aaa","注册的状态码成功"+status);
                                Toast.makeText(ZhuCeZH.this, zhuCeBean.getMessage(), Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(ZhuCeZH.this, zhuCeBean.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
    }


    private void iniGetYzm() {
        huoqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sputemail = putemail.getText().toString().trim();
                Map<String,Object> map=new HashMap<>();
                map.put("email",sputemail);
                NetUtil.getInstance().NetEmail(MyUrl.BASEYOUXIANG, EmailBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        EmailBean emailBean = gson.fromJson(stra, EmailBean.class);
                        String status = emailBean.getStatus();
                        if(status.equals("0000")){
                            Toast.makeText(ZhuCeZH.this, emailBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(ZhuCeZH.this, emailBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });



    }


    @Override
    protected void iniview() {
        zhucefinnish=findViewById(R.id.zhucefinish);
        putname=findViewById(R.id.putname);
        putemail=findViewById(R.id.putemail);
        putpwd=findViewById(R.id.putpwd);
        putyzm=findViewById(R.id.putyzm);
        huoqu=findViewById(R.id.huoqu);
        zcyzc=findViewById(R.id.zcyzc);

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_zhu_ce_zh;
    }

    //完成注册返回登录页面
    private void zcfinish() {
        zhucefinnish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
