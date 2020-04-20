package com.bw.movie.shouye_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.shouye_fragment.shouye_jsyp.Shouye_MX_JieShao;
import com.bw.movie.shouye_fragment.shouye_jsyp.Shouye_MX_YingPin;
import com.bw.movie.shouye_fragment.shouye_jsyp.Shouye_Mx_Juzhao;
import com.bw.movie.shouye_fragment.shouye_jsyp.Shouye_Mx_Yugao;
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
        sl.add("预告");
        sl.add("剧照");
        sl.add("影评");


        Bundle bundle = new Bundle();
        bundle.putString("movieId",movieId);
        bundle.putString("sessionId",sessionId);

        Shouye_Mx_Yugao shouye_mx_yugao = new Shouye_Mx_Yugao();
        shouye_mx_yugao.setArguments(bundle);

        Shouye_Mx_Juzhao shouye_mx_juzhao = new Shouye_Mx_Juzhao();
        shouye_mx_juzhao.setArguments(bundle);


        Shouye_MX_JieShao shouye_mx_jieShao = new Shouye_MX_JieShao();
        shouye_mx_jieShao.setArguments(bundle);


        Shouye_MX_YingPin shouye_mx_yingPin = new Shouye_MX_YingPin();
        shouye_mx_yingPin.setArguments(bundle);

        fl.add(shouye_mx_jieShao);
        fl.add(shouye_mx_yugao);
        fl.add(shouye_mx_juzhao);
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
