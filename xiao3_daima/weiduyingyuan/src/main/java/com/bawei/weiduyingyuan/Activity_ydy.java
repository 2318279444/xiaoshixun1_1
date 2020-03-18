package com.bawei.weiduyingyuan;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bawei.weiduyingyuan.ydy.ydy1;
import com.bawei.weiduyingyuan.ydy.ydy2;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.MyYingFragmentAdapter;
import base.BaseActivity;

public class Activity_ydy extends BaseActivity {
    ViewPager pager;
    TabLayout tabLayout;
    List<Fragment> fl=new ArrayList<>();
    List<String> sl=new ArrayList<>();

    @Override
    protected void inidata() {
        sl.add("y1");
        sl.add("y2");

        fl.add(new ydy1());
        fl.add(new ydy2());

        MyYingFragmentAdapter myYingFragmentAdapter = new MyYingFragmentAdapter(getSupportFragmentManager(), sl, fl);

        tabLayout.setupWithViewPager(pager);
        pager.setAdapter(myYingFragmentAdapter);

    }

    @Override
    protected void iniview() {
        pager=findViewById(R.id.pager_ydy);
        tabLayout=findViewById(R.id.tab_ydy);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_ydy;
    }
}
