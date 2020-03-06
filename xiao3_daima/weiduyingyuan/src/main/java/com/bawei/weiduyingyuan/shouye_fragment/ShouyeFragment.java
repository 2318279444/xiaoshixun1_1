package com.bawei.weiduyingyuan.shouye_fragment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bawei.weiduyingyuan.R;
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


    @Override
    protected void inidata() {
        sl.add("正在热映");
        sl.add("即将上映");
        sl.add("热门电影");

        now_movie_shouye = new Now_Movie_Shouye();

        jijiang_movie_shouye = new Jijiang_Movie_Shouye();

        remen_movie_shouye = new Remen_Movie_Shouye();

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
