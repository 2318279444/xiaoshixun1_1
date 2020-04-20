package com.bw.okhttp_huancun4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private String json_path = "http://publicobject.com/helloworld.txt";
    private TextView text_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void okhttp_json(View view) {
        OKhttpUtils.getInstance().doGet(json_path, new OKhttpUtils.okCallback() {
            @Override
            public void onFailure(Exception e) {
                Toast.makeText(MainActivity.this, "网络请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String json) {
                text_tv.setText(json);
            }
        });
    }

    //服务器提交账号密码
    public void okhttp_table(View view){
        HashMap<String, String> map = new HashMap<>();
        map.put("uid","71");
        OKhttpUtils.getInstance().doPost(json_path, map, new OKhttpUtils.okCallback() {
            @Override
            public void onFailure(Exception e) {
                Toast.makeText(MainActivity.this, "网络请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(String json) {
                text_tv.setText(json);
            }
        });
    }


    private void initView() {
        text_tv = (TextView) findViewById(R.id.text_tv);
    }
}
