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

import adapter.MyAdapter.My_plun_Liebiao_Adapter;
import base.BaseActivity;
import bean.MyBean.My_Plun_LeibiaoBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class My_pnglun extends BaseActivity {
    RecyclerView recyclerView;


    @Override
    protected void inidata() {
        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");
        Log.e("aaa","我的4"+sessionId);

        Map<String,Object> map=new HashMap<>();
        map.put("sessionId", sessionId);
        map.put("userId",13752);

        Map<String,Object> map1=new HashMap<>();
        map1.put("page",1);
        map1.put("count",11);

        NetUtil.getInstance().Net_Plun_Liebiao(MyUrl.BASE_Plun_Liebiao, My_Plun_LeibiaoBean.class, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {

//                Gson gson = new Gson();
//                My_Plun_LeibiaoBean my_plun_leibiaoBean = gson.fromJson(stra, My_Plun_LeibiaoBean.class);
//                My_plun_Liebiao_Adapter my_plun_liebiao_adapter = new My_plun_Liebiao_Adapter(my_plun_leibiaoBean.getResult(), My_pnglun.this);
//                recyclerView.setAdapter(my_plun_liebiao_adapter);
//                Log.e("aaa","评论列表"+my_plun_leibiaoBean.getResult());

            }
        });


    }

    @Override
    protected void iniview() {
        recyclerView=findViewById(R.id.recyc_my_plun_liebiao);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_my_pnglun;
    }
}
