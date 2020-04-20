package com.bw.dengxianchao20200414;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.MyFragmentAdapter;
import base.BaseActivity;

public class ShouYe extends BaseActivity {

    TabLayout tabLayout;
    ViewPager pager;
    List<String> sl=new ArrayList<>();
    List<Fragment> fl=new ArrayList<>();


    @Override
    protected void inidata() {
        sl.add("购物车");
        sl.add("我的");




        GwcActivity gwcActivity = new GwcActivity();

        MyActivity myActivity = new MyActivity();

        fl.add(gwcActivity);
        fl.add(myActivity);

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
        return R.layout.activity_shou_ye;
    }
}
