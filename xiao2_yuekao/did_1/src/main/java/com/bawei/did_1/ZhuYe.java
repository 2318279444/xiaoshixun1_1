package com.bawei.did_1;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bawei.did_1.fragment.Daifu;
import com.bawei.did_1.fragment.Daip;
import com.bawei.did_1.fragment.Dais;
import com.bawei.did_1.fragment.Finishh;
import com.bawei.did_1.fragment.Quanbu;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.MyFragmentAdapter;
import base.BaseActivity;

public class ZhuYe extends BaseActivity {
    TabLayout tabLayout;
    ViewPager pager;

    List<String> slist=new ArrayList<>();
    List<Fragment> flist=new ArrayList<>();
    private Quanbu quanbu;
    private Daifu daifu;
    private Dais dais;
    private Daip daip;
    private Finishh finishh;


    @Override
    protected void inidata() {
        slist.add("全部订单");
        slist.add("待付款");
        slist.add("待收货");
        slist.add("待评价");
        slist.add("已完成");

        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");
        Log.e("aaa","zhuye:"+sessionId);

        Bundle bundle = new Bundle();
        bundle.putString("sessionId",sessionId);

        quanbu = new Quanbu();
        quanbu.setArguments(bundle);

        daifu = new Daifu();
        daifu.setArguments(bundle);

        dais = new Dais();
        dais.setArguments(bundle);

        daip = new Daip();
        daip.setArguments(bundle);

        finishh = new Finishh();
        finishh.setArguments(bundle);


        flist.add(quanbu);
        flist.add(daifu);
        flist.add(dais);
        flist.add(daip);
        flist.add(finishh);

        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), slist, flist);

        tabLayout.setupWithViewPager(pager);
        pager.setAdapter(myFragmentAdapter);

    }

    @Override
    protected void iniview() {
        tabLayout=findViewById(R.id.tab);
        pager=findViewById(R.id.pager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_zhu_ye;
    }
}
