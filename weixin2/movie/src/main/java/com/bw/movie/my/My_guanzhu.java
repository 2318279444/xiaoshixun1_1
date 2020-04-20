package com.bw.movie.my;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bw.movie.R;
import com.bw.movie.shouye_fragment.Shouye_XQ;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import adapter.MyAdapter.My_Guanzhu_Adapter;
import adapter.ShouyeAdapter.MyShouye_jijiang_Adapter;
import base.BaseActivity;
import bean.MyBean.My_GuanzhuBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class My_guanzhu extends BaseActivity {
    RecyclerView recyclerView;
    private int movieI;
    private String sessionId;

    @Override
    protected void inidata() {
        Intent intent = getIntent();
        sessionId = intent.getStringExtra("sessionId");

        Log.e("aaa","我的1"+ sessionId);


        Map<String,Object> map=new HashMap<>();
        map.put("sessionId", sessionId);
        map.put("userId",13752);

        Map<String,Object> map1=new HashMap<>();
        map1.put("page",1);
        map1.put("count",11);

        NetUtil.getInstance().Net_guanzhu(MyUrl.BASE_WODE_GUANZHU, My_GuanzhuBean.class, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                My_GuanzhuBean my_guanzhuBean = gson.fromJson(stra, My_GuanzhuBean.class);
                My_Guanzhu_Adapter my_guanzhu_adapter = new My_Guanzhu_Adapter(my_guanzhuBean.getResult(), My_guanzhu.this);
                recyclerView.setAdapter(my_guanzhu_adapter);

                my_guanzhu_adapter.setToJijiangCall(new MyShouye_jijiang_Adapter.ToJijiangCall() {
                    @Override
                    public void onClick(int position) {
                        movieI = my_guanzhuBean.getResult().get(position).getMovieId();
                        Intent intent1 = new Intent(My_guanzhu.this, Shouye_XQ.class);

                        String movieId = String.valueOf(movieI);
                        intent1.putExtra("movieId",movieId);
                        intent1.putExtra("sessionId",sessionId);
                        startActivity(intent1);
                    }
                });
            }
        });


    }

    @Override
    protected void iniview() {
        recyclerView=findViewById(R.id.recyc_my_Guanzhu);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_my_guanzhu;
    }
}
