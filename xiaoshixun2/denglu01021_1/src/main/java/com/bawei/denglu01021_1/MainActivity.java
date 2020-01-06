package com.bawei.denglu01021_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.MyLogin;
import com.bawei.bean.Myzhuce;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.bawei.util.NetUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity implements Icontract.ToCall {
    EditText user,pwd;
    Button zhuce,denglu;

    @Override
    protected void inidata() {

        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String suser = user.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                if (suser.isEmpty()||spwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"不可以为空",Toast.LENGTH_SHORT).show();
                }else {
                    Map<String,Object> map=new HashMap<>();
                    map.put("phone",suser);
                    map.put("pwd",spwd);
                    NetUtil.getInstance().toDenglu(MyUrl.BASEZHUCE, Myzhuce.class, map, new Icontract.ToCall() {
                        @Override
                        public void success(String stra) {
                            Gson gson = new Gson();
                            Myzhuce myzhuce = gson.fromJson(stra, Myzhuce.class);
                            if (myzhuce.getStatus().equals("1001")){
                                Toast.makeText(MainActivity.this,myzhuce.getMessage(),Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(MainActivity.this,myzhuce.getMessage(),Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
            }
        });


        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String suser = user.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                if (suser.isEmpty()||spwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"不可以为空",Toast.LENGTH_SHORT).show();
                }else {
                    Map<String,Object> map=new HashMap<>();
                    map.put("phone",suser);
                    map.put("pwd",spwd);
                    NetUtil.getInstance().toDenglu(MyUrl.BASEDENGLU, MyLogin.class, map, new Icontract.ToCall() {
                        @Override
                        public void success(String stra) {
                            Gson gson = new Gson();
                            MyLogin myLogin = gson.fromJson(stra, MyLogin.class);
                            if (myLogin.getStatus().equals("1001")){
                                Toast.makeText(MainActivity.this,myLogin.getMessage(),Toast.LENGTH_SHORT).show();
                            }else {
                                Intent intent = new Intent(MainActivity.this, Login.class);
                                startActivity(intent);
                            }

                        }
                    });

                }
            }
        });

    }

    @Override
    protected void iniview() {
        zhuce=findViewById(R.id.zhuce);
        denglu=findViewById(R.id.denglu);
        user=findViewById(R.id.user);
        pwd=findViewById(R.id.pwd);
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
