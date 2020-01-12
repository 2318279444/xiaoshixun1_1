package com.bawei.week0111_1;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.Loginbean;
import com.bawei.bean.ZhuceBean;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.bawei.util.NetUtil;
import com.blankj.utilcode.util.EncryptUtils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity implements Icontract.ToLoginCallBack {
    EditText user,pwd;
    Button zhuce,denglu;


    @Override
    protected void inidata() {

        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String suser = user.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                Map<String,Object> map=new HashMap<>();
                map.put("phone",suser);
                map.put("pwd",spwd);
                NetUtil.getInstance().netZhuce(MyUrl.BASEZHUCE, ZhuceBean.class, map, new Icontract.ToLoginCallBack() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        ZhuceBean zhuceBean = gson.fromJson(stra, ZhuceBean.class);
                        if(zhuceBean.getStatus().equals("0000")){
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
            public void onClick(View v) {
                String suser = user.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                String string = EncryptUtils.encryptMD5ToString(String.valueOf(pwd));
                Log.e("aaa","md5"+string);
                Map<String,Object> map=new HashMap<>();
                map.put("phone",suser);
                map.put("pwd",spwd);
                NetUtil.getInstance().netZhuce(MyUrl.BASEDENGLU, Loginbean.class, map, new Icontract.ToLoginCallBack() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        Loginbean loginbean = gson.fromJson(stra, Loginbean.class);
                        if(loginbean.getStatus().equals("0000")){
                            String headPic = loginbean.getResult().getHeadPic();
                            String sessionId = loginbean.getResult().getSessionId();
                            String phone = loginbean.getResult().getPhone();
                            Intent intent = new Intent(MainActivity.this, Shoppingg.class);

                            intent.putExtra("phone",phone);
                            intent.putExtra("pic",headPic);
                            intent.putExtra("sessionId",sessionId);
                            startActivity(intent);
                        }else {
                            Toast.makeText(MainActivity.this, loginbean.getMessage(), Toast.LENGTH_SHORT).show();
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
        zhuce=findViewById(R.id.zhuce);
        denglu=findViewById(R.id.denglu);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {

    }
}
