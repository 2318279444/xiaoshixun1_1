package com.bw.movie.shouye_fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.MyYingFragmentAdapter;
import base.BaseActivity;

public class ShouyeFragment extends BaseActivity {
    TabLayout tab;
    ViewPager pager;
    List<String> sl=new ArrayList<>();
    List<Fragment> fl=new ArrayList<>();
    private Now_Movie_Shouye now_movie_shouye;
    private Jijiang_Movie_Shouye jijiang_movie_shouye;
    private Remen_Movie_Shouye remen_movie_shouye;
    private String sessionId;


    @Override
    protected void inidata() {

        Intent intent = getIntent();
        sessionId = intent.getStringExtra("sessionId");


        sl.add("正在热映");
        sl.add("即将上映");
        sl.add("热门电影");

        Bundle bundle = new Bundle();
        bundle.putString("sessionId",sessionId);

        now_movie_shouye = new Now_Movie_Shouye();
        now_movie_shouye.setArguments(bundle);

        jijiang_movie_shouye = new Jijiang_Movie_Shouye();
        jijiang_movie_shouye.setArguments(bundle);

        remen_movie_shouye = new Remen_Movie_Shouye();
        remen_movie_shouye.setArguments(bundle);

        fl.add(now_movie_shouye);
        fl.add(jijiang_movie_shouye);
        fl.add(remen_movie_shouye);

        MyYingFragmentAdapter myYingFragmentAdapter = new MyYingFragmentAdapter(getSupportFragmentManager(), sl, fl);

        tab.setupWithViewPager(pager);

        pager.setAdapter(myYingFragmentAdapter);

    }

    @Override
    protected void iniview() {
        tab=findViewById(R.id.Shouye_tab);
        pager=findViewById(R.id.Shouye_pager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shouye_fragment;
    }
}
