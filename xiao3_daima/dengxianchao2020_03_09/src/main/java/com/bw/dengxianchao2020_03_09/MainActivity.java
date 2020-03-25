package com.bw.dengxianchao2020_03_09;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.MyFragmentAdapter;
import base.BaseActivity;

public class MainActivity extends BaseActivity {
    List<String> sl=new ArrayList<>();
    List<Fragment> fl=new ArrayList<>();
    TabLayout tabLayout;
    ViewPager pager;


    @Override
    protected void inidata() {
        //string类型的集合添加导航栏数据
        sl.add("正在上映");
        sl.add("热门电影");


        //fragemnt类型的集合添加fragment切换页面
        fl.add(new Now());
        fl.add(new Hot());


        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), sl, fl);
        //tablayour与viewpager相结合
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
        return R.layout.activity_main;
    }
}
