package com.bawei.zhoumozuoye_2020_03_07;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bawei.zhoumozuoye_2020_03_07.Fragment.Movie;
import com.bawei.zhoumozuoye_2020_03_07.Fragment.My_activity;
import com.bawei.zhoumozuoye_2020_03_07.Fragment.Shouye;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.MyFragmentAdapter;
import base.BaseActivity;

public class MainActivity extends BaseActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<String> sl=new ArrayList<>();
    List<Fragment> fl=new ArrayList<>();


    @Override
    protected void inidata() {
        sl.add("首页");
        sl.add("电影");
        sl.add("我的");

        fl.add(new Shouye());
        fl.add(new Movie());
        fl.add(new My_activity());

        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), sl, fl);
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
