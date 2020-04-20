package com.bw.okhttp_huancun3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    //Post自己服务器登录接口网址
    //private String Login_path = "http://169.254.53.96:8080/web/LoginServlet";
    //下载图片接口网址
//    private String Picture_path="https://10.url.cn/eth/ajNVdqHZLLAxibwnrOxXSzIxA76ichutwMCcOpA45xjiapneMZsib7eY4wUxF6XDmL2FmZEVYsf86iaw/";

    //GET接口网址
//    private String json_path = "http://publicobject.com/helloworld.txt";

    private String json_path = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1";
    //Post请求接口网址   bw购物车的内容 共有字段"source", "android"添加到拦截器中   参数"uid","71"
    String url = "http://www.zhaoapi.cn/product/getCarts";

    private TextView text_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_tv = (TextView) findViewById(R.id.text_tv);
    }

    /**
     * 通过点击事件执行okhttp里封装的根据网址,获取字符串的逻辑操作.
     * @param view
     *
     */
    public void okhttp_json(View view){
        OkhtttpUtils.getInstance().doGet(json_path, new OkhtttpUtils.OkCallback() {
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

    //像服务器提交账号及密码
    public void okhttp_table(View view){
        HashMap<String, String> map = new HashMap<>();
        map.put("uid","71");
        OkhtttpUtils.getInstance().doPost(url, map, new OkhtttpUtils.OkCallback() {
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
}
