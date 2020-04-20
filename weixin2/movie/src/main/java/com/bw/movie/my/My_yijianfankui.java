package com.bw.movie.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.movie.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import base.BaseActivity;
import bean.MyBean.My_fankuiBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class My_yijianfankui extends BaseActivity {
    EditText editText;
    Button button;

    @Override
    protected void inidata() {
        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");

        Log.e("aaa","我的6"+sessionId);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit = editText.getText().toString().trim();
                Map<String,Object> map=new HashMap<>();
                map.put("sessionId", sessionId);
                map.put("userId",13752);

                Map<String,Object> map1=new HashMap<>();
                map1.put("content",edit);

                NetUtil.getInstance().Net_Fankui(MyUrl.BASE_Fankui, My_fankuiBean.class, map, map1, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        My_fankuiBean my_fankuiBean = gson.fromJson(stra, My_fankuiBean.class);
                        String status = my_fankuiBean.getStatus();
                        if(status.equals("0000")){
                            Toast.makeText(My_yijianfankui.this, my_fankuiBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }

    @Override
    protected void iniview() {
        editText=findViewById(R.id.edit_fankui);
        button=findViewById(R.id.btn_fankui);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_my_yijianfankui;
    }
}
