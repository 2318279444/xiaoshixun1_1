package com.bw.rikaoday1_02_21;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bw.rikaoday1_02_21.fragment.ddfragment.DaiAll;
import com.bw.rikaoday1_02_21.fragment.ddfragment.DaiFinish;
import com.bw.rikaoday1_02_21.fragment.ddfragment.DaiFu;
import com.bw.rikaoday1_02_21.fragment.ddfragment.DaiShou;
import com.bw.rikaoday1_02_21.fragment.ddfragment.Daipj;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import base.BaseActivity;

public class Main2ActivityDD extends BaseActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<String> sl=new ArrayList<>();
    List<Fragment> fl=new ArrayList<>();
    private DaiAll daiAll;
    private DaiFu daiFu;
    private DaiShou daiShou;
    private Daipj daipj;
    private DaiFinish daiFinish;
    private String sessionId;


    @Override
    protected void iniview() {

        tabLayout=findViewById(R.id.tab);
        pager=findViewById(R.id.pager);

    }

    @Override
    protected void inidata() {

        Intent intent = getIntent();
        sessionId = intent.getStringExtra("sessionId");
        Log.e("aaa","main2"+sessionId);

        sl.add("查看全部");
        sl.add("待付款");
        sl.add("待收货");
        sl.add("待评价");
        sl.add("已完成");

        Bundle bundle = new Bundle();
        bundle.putString("sessionId", sessionId);

        daiAll = new DaiAll();
        daiAll.setArguments(bundle);

        daiFu = new DaiFu();
        daiFu.setArguments(bundle);

        daiShou = new DaiShou();
        daiShou.setArguments(bundle);

        daipj = new Daipj();
        daipj.setArguments(bundle);

        daiFinish = new DaiFinish();
        daiFinish.setArguments(bundle);


        fl.add(daiAll);
        fl.add(daiFu);
        fl.add(daiShou);
        fl.add(daipj);
        fl.add(daiFinish);

        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), sl, fl);
        tabLayout.setupWithViewPager(pager);
        pager.setAdapter(myAdapter);


    }

    @Override
    protected int inilayout() {
        return R.layout.activity_main2_dd;
    }
}
