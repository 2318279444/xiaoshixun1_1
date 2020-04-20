package com.bw.movie.shouye_fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bw.movie.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import adapter.ShouyeAdapter.My_Shouye_Sousuo_Adapter;
import base.BaseActivity;
import bean.shouye.Shouye_SousuoBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class Shouye_Ss_Movie extends BaseActivity {
    RecyclerView recyclerView;
    EditText editText;
    Button button;
    private String edit;
    private String editsousuo2;

    @Override
    protected void inidata() {

        Intent intent = getIntent();

        //获取首页传过来的搜索信息
        edit = intent.getStringExtra("edit");

        //在收缩页面直接展示由首页传过来的搜索信息
        Map<String,Object> map=new HashMap<>();
                map.put("keyword", edit);
                map.put("page",1);
                map.put("count",11);
                Log.e("aaa","首页搜索"+ edit);
                NetUtil.getInstance().Net_Shouye_Sousuo(MyUrl.BASE_Shouye_SOUSUO, Shouye_SousuoBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        Shouye_SousuoBean shouye_sousuoBean = gson.fromJson(stra, Shouye_SousuoBean.class);
                        My_Shouye_Sousuo_Adapter my_shouye_sousuo_adapter = new My_Shouye_Sousuo_Adapter(shouye_sousuoBean.getResult(), Shouye_Ss_Movie.this);
                        recyclerView.setAdapter(my_shouye_sousuo_adapter);
                    }
                });


                //上面那个是首页搜索里面输入了什么,跳到搜索页面直接展示,下面的是在搜索页面输入搜索的信息来展示

        button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //再搜索页面获取搜索信息
                        editsousuo2 = editText.getText().toString().trim();
                        //map传参
                        Map<String,Object> map=new HashMap<>();
                        map.put("keyword", editsousuo2);
                        map.put("page",1);
                        map.put("count",11);
                        Log.e("aaa","首页搜索"+ editsousuo2);
                        NetUtil.getInstance().Net_Shouye_Sousuo(MyUrl.BASE_Shouye_SOUSUO, Shouye_SousuoBean.class, map, new Icontract.ToCall() {
                            @Override
                            public void success(String stra) {
                                Gson gson = new Gson();
                                Shouye_SousuoBean shouye_sousuoBean = gson.fromJson(stra, Shouye_SousuoBean.class);
                                My_Shouye_Sousuo_Adapter my_shouye_sousuo_adapter = new My_Shouye_Sousuo_Adapter(shouye_sousuoBean.getResult(), Shouye_Ss_Movie.this);
                                recyclerView.setAdapter(my_shouye_sousuo_adapter);
                                my_shouye_sousuo_adapter.notifyDataSetChanged();
                            }
                        });
                    }
                });
    }

    @Override
    protected void iniview() {
        editText=findViewById(R.id.Shouye_edit2);
        button=findViewById(R.id.Shouye_Sousuo2);


        recyclerView=findViewById(R.id.recyc_Shouye_Sousuo);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shouye__ss__movie;
    }
}
