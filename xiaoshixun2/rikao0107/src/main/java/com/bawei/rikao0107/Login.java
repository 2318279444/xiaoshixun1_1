package com.bawei.rikao0107;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.bean.DengluBean;
import com.bawei.contract.Icontract;
import com.bawei.url.MyUrl;
import com.bawei.util.NetUtil;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    EditText user,pwd;
    Button denglu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=findViewById(R.id.user);
        pwd=findViewById(R.id.pwd);
        denglu=findViewById(R.id.denglu);

        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String suser = user.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                Map<String,Object> map=new HashMap<>();

                map.put("phone",suser);
                map.put("pwd",spwd);
                NetUtil.getInstance().netDenglu(MyUrl.BASEDENGLU, DengluBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        DengluBean dengluBean = gson.fromJson(stra, DengluBean.class);
                        if(dengluBean.getStatus().equals(0000)){
                            EventBus.getDefault().post(dengluBean.getResult().getSessionId());
                            startActivity(new Intent(Login.this,MainActivity.class));
                        }else {
                            Toast.makeText(Login.this, "账号密码错误", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
