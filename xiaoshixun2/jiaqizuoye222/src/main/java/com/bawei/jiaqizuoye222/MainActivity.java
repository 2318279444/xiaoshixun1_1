package com.bawei.jiaqizuoye222;

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
import com.bawei.bean.Denglubean;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.bawei.util.NetUtil;
import com.blankj.utilcode.util.EncryptUtils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity implements Icontract.ToCall {
    EditText user,pwd;
    Button button;

    @Override
    protected void inidata() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String suser = user.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                String string = EncryptUtils.encryptMD5ToString(spwd);
                Log.e("aaa","加密:"+string);
                Map<String,Object> map=new HashMap<>();
                map.put("phone",suser);
                map.put("pwd",spwd);


                NetUtil.getInstance().NetDenglu(MyUrl.BASEDENGLU, Denglubean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        Denglubean denglubean = gson.fromJson(stra, Denglubean.class);
                        String status = denglubean.getStatus();
                        String sessionId = denglubean.getResult().getSessionId();
                        if(status.equals("0000")){

                            Intent intent = new Intent(MainActivity.this, GwcActivityyyy.class);
                            intent.putExtra("sessionId",sessionId);
                            startActivity(intent);

                        }else {
                            Toast.makeText(MainActivity.this, "22", Toast.LENGTH_SHORT).show();
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
        button=findViewById(R.id.denglu);
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
