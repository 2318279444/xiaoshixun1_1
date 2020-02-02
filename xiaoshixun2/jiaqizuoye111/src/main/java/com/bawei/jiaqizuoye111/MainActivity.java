package com.bawei.jiaqizuoye111;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.base.BaseActivtity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.DengluBean;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.bawei.util.NetUtil;
import com.blankj.utilcode.util.EncryptUtils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivtity {
    EditText user,pwd;
    Button denglu;


    @Override
    protected void inidata() {
        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String susr = user.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                String string = EncryptUtils.encryptMD5ToString(spwd);
                Log.e("aaa","mima:"+string);
                Map<String,Object> map=new HashMap<>();
                map.put("phone",susr);
                map.put("pwd",spwd);

                NetUtil.getInstance().toDenglu(MyUrl.BASEDENGLU, DengluBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void seccess(String stra) {
                        Gson gson = new Gson();
                        DengluBean dengluBean = gson.fromJson(stra, DengluBean.class);
                        String status = dengluBean.getStatus();
                        String sessionId = dengluBean.getResult().getSessionId();
                        if(status.equals("0000")){
                            Intent intent = new Intent(MainActivity.this, GwcActivity.class);
                            intent.putExtra("sessionId",sessionId);
                            startActivity(intent);

                        }else {
                            Log.e("aaa","e"+status);
                            Toast.makeText(MainActivity.this, dengluBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void iniview() {


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
}
