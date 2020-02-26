package com.bawei.dengxianchao2020218;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bawei.dengxianchao2020218.fragment.Daifu;
import com.bawei.dengxianchao2020218.fragment.Daip;
import com.bawei.dengxianchao2020218.fragment.Daishou;
import com.bawei.dengxianchao2020218.fragment.Fini;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.MyFragmentAdapter;
import base.BaseActivity;

public class ShouyeDingdan extends BaseActivity {
    TabLayout tabLayout;
    ViewPager pager;

    List<String> sl=new ArrayList<>();
    List<Fragment> fl=new ArrayList<>();
    private Quanbu quanbu;
    private Daifu daifu;
    private Daishou daishou;
    private Daip daip;
    private Fini fini;

    @Override
    protected void inidata() {
        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");
        Log.e("aaa","s1:"+sessionId);

        Bundle bundle = new Bundle();
        bundle.putString("sessionId",sessionId);

        //添加tablayout五个信息
        sl.add("全部");
        sl.add("待付款");
        sl.add("待收货");
        sl.add("待评价");
        sl.add("已完成");


        //用bundle传值到fragment
        quanbu = new Quanbu();
        quanbu.setArguments(bundle);

        daifu = new Daifu();
        daifu.setArguments(bundle);

        daishou = new Daishou();
        daishou.setArguments(bundle);

        daip = new Daip();
        daip.setArguments(bundle);

        fini = new Fini();
        fini.setArguments(bundle);


        //添加fragment
        fl.add(quanbu);
        fl.add(daifu);
        fl.add(daishou);
        fl.add(daip);
        fl.add(fini);

        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), sl, fl);

        //tablayout与ViewPager绑定
        tabLayout.setupWithViewPager(pager);
        //展示
        pager.setAdapter(myFragmentAdapter);
    }

    @Override
    protected void iniview() {
        tabLayout=findViewById(R.id.tab);
        pager=findViewById(R.id.pager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shouye_dingdan;
    }
}
