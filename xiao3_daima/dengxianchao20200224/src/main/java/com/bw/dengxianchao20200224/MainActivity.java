package com.bw.dengxianchao20200224;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

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
    protected void indata() {
        sl.add("我收到的礼物");
        sl.add("我送出的礼物");

        fl.add(new MyShou());
        fl.add(new MySong());

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
