package com.bawei.zhoumozuoye2020_02_22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

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
        sl.add("正在上映");
        sl.add("即将上映");

        fl.add(new ZhengZai());
        fl.add(new JiJang());

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
