package com.bw.movie.my;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bw.movie.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import adapter.MyAdapter.My_Guanzhu_Adapter;
import adapter.MyAdapter.My_YueyueAdapter;
import base.BaseActivity;
import bean.MyBean.My_GuanzhuBean;
import bean.MyBean.My_YueyueBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class My_yuyue extends BaseActivity {
    RecyclerView recyclerView;

    @Override
    protected void inidata() {
        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");

        Log.e("aaa","我的7"+sessionId);

        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",13752);



        NetUtil.getInstance().Net_yuyue(MyUrl.BASE_WODE_YUYUE, My_YueyueBean.class, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                My_YueyueBean my_yueyueBean = gson.fromJson(stra, My_YueyueBean.class);
                My_YueyueAdapter my_yueyueAdapter = new My_YueyueAdapter(my_yueyueBean.getResult(), My_yuyue.this);
                recyclerView.setAdapter(my_yueyueAdapter);
            }
        });
    }

    @Override
    protected void iniview() {
        recyclerView=findViewById(R.id.recyc_my_Yuyue);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_my_yuyue;
    }
}
