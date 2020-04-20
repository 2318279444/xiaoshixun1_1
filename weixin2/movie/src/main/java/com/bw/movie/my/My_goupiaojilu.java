package com.bw.movie.my;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;

import com.bw.movie.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import adapter.MyAdapter.My_Goupiaojl_Adapter;
import base.BaseActivity;
import bean.MyBean.My_GoupiaoliBean;
import bean.MyBean.My_GuanzhuBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class My_goupiaojilu extends BaseActivity {
    RecyclerView recyclerView;

    @Override
    protected void inidata() {
        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");
        Log.e("aaa","我的2"+sessionId);

        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",13752);

        Map<String,Object> map1=new HashMap<>();
        map1.put("page",1);
        map1.put("count",11);
        map1.put("status",2);

        NetUtil.getInstance().Net_GouPiaoJL(MyUrl.BASE_GouPiaoJiLu, My_GuanzhuBean.class, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                My_GoupiaoliBean my_goupiaoliBean = gson.fromJson(stra, My_GoupiaoliBean.class);
                My_Goupiaojl_Adapter my_goupiaojl_adapter = new My_Goupiaojl_Adapter(my_goupiaoliBean.getResult(), My_goupiaojilu.this);

                recyclerView.setAdapter(my_goupiaojl_adapter);

                my_goupiaojl_adapter.setToJijiangCall(new My_Goupiaojl_Adapter.ToJijiangCall() {
                    @Override
                    public void onClick(int position) {
                        Intent intent1 = new Intent(My_goupiaojilu.this, My_Gp_erweima.class);
                        String movieName = my_goupiaoliBean.getResult().get(position).getMovieName();
                        intent1.putExtra("movieName",movieName);
                        startActivity(intent1);

                    }
                });
            }
        });




    }

    @Override
    protected void iniview() {
        recyclerView=findViewById(R.id.recyc_Goupiao);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_my_goupiaojilu;
    }
}
