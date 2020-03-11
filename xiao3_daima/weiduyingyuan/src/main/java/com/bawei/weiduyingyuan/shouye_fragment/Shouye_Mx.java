package com.bawei.weiduyingyuan.shouye_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bawei.weiduyingyuan.R;
import com.bawei.weiduyingyuan.shouye_fragment.shouye_jsyp.Shouye_MX_JieShao;
import com.bawei.weiduyingyuan.shouye_fragment.shouye_jsyp.Shouye_MX_YingPin;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.MyYingFragmentAdapter;
import base.BaseActivity;

public class Shouye_Mx extends BaseActivity {
    TabLayout tabLayout;
    ViewPager pager;

    List<String> sl=new ArrayList<>();
    List<Fragment> fl=new ArrayList<>();


    private String movieId;
    private String sessionId;

    @Override
    protected void inidata() {
        Intent intent = getIntent();
        movieId = intent.getStringExtra("movieId");
        Log.e("aaa","明细fragment:"+movieId);


        sessionId = intent.getStringExtra("sessionId");


        sl.add("介绍");
        sl.add("影评");


        Bundle bundle = new Bundle();
        bundle.putString("movieId",movieId);
        bundle.putString("sessionId",sessionId);


        Shouye_MX_JieShao shouye_mx_jieShao = new Shouye_MX_JieShao();
        shouye_mx_jieShao.setArguments(bundle);


        Shouye_MX_YingPin shouye_mx_yingPin = new Shouye_MX_YingPin();
        shouye_mx_yingPin.setArguments(bundle);

        fl.add(shouye_mx_jieShao);
        fl.add(shouye_mx_yingPin);

        MyYingFragmentAdapter myYingFragmentAdapter = new MyYingFragmentAdapter(getSupportFragmentManager(), sl, fl);

        tabLayout.setupWithViewPager(pager);

        pager.setAdapter(myYingFragmentAdapter);

    }

    @Override
    protected void iniview() {
        tabLayout=findViewById(R.id.shouye_mx_tab);
        pager=findViewById(R.id.shouye_mx_pager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shouye__mx;
    }
}
