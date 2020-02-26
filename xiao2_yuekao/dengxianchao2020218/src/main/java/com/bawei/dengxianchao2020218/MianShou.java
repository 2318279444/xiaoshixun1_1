package com.bawei.dengxianchao2020218;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import adapter.MyAdapter;
import adapter.MyShouyeAdapter;
import base.BaseActivity;
import bean.ShouyeBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class MianShou extends BaseActivity {
    EditText editText;
    RecyclerView recyclerView;


    @Override
    protected void inidata() {
        //获取搜索对象搜索商品
        String eds = editText.getText().toString().trim();
        Map<String,Object> map=new HashMap<>();
        map.put("keyword",eds);
        map.put("page",1);
        map.put("count",5);


        NetUtil.getInstance().NetShouye(MyUrl.BASESHOUYE, ShouyeBean.class, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
//                Gson gson = new Gson();
//                ShouyeBean shouyeBean = gson.fromJson(stra, ShouyeBean.class);
//                MyShouyeAdapter myShouyeAdapter = new MyShouyeAdapter(shouyeBean.getResult(),this);
            }
        });


        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");
        Log.e("aaa","sessionId:"+sessionId);

    }

    @Override
    protected void iniview() {
        editText=findViewById(R.id.sous);

        recyclerView=findViewById(R.id.recycsousuo);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_mian_shou;
    }
}
