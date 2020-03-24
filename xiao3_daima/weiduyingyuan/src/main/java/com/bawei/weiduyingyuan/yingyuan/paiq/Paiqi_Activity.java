package com.bawei.weiduyingyuan.yingyuan.paiq;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bawei.weiduyingyuan.R;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import adapter.MyYingFragmentAdapter;
import base.BaseActivity;

public class Paiqi_Activity extends BaseActivity {

    TabLayout tabLayout;
    ViewPager pager;
    Long day=86400000l;

    List<String> sl=new ArrayList<>();
    List<Fragment> fl=new ArrayList<>();

    List<Long> listtime=new ArrayList<>();
    private String format;
    private String slisttime;
    List<String> list=new ArrayList<>();
    private Integer yid;

    @Override
    protected void inidata() {
        long time = new Date().getTime();

        for (int i = 0; i < 7; i++) {
            listtime.add(time+day*i);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM_dd");
            format = simpleDateFormat.format(listtime.get(i));
            list.add(format);
            Log.e("aaa","slisttime1"+format);
        }

        for (int i = 0; i < 7; i++) {
            sl.add(list.get(i));
        }

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        Bundle bundle = new Bundle();
        bundle.putString("id",id);


        Paiqi_one paiqi_one = new Paiqi_one();
        paiqi_one.setArguments(bundle);

        Paiqi_two paiqi_two = new Paiqi_two();
        paiqi_two.setArguments(bundle);

        Paiqi_three paiqi_three = new Paiqi_three();
        paiqi_three.setArguments(bundle);

        Paiqi_four paiqi_four = new Paiqi_four();
        paiqi_four.setArguments(bundle);

        Paiqi_five paiqi_five = new Paiqi_five();
        paiqi_five.setArguments(bundle);

        Paiqi_Six paiqi_six = new Paiqi_Six();
        paiqi_six.setArguments(bundle);

        Paiqi_seven paiqi_seven = new Paiqi_seven();
        paiqi_seven.setArguments(bundle);

        fl.add(paiqi_one);
        fl.add(paiqi_two);
        fl.add(paiqi_three);
        fl.add(paiqi_four);
        fl.add(paiqi_five);
        fl.add(paiqi_six);
        fl.add(paiqi_seven);

        MyYingFragmentAdapter myYingFragmentAdapter = new MyYingFragmentAdapter(getSupportFragmentManager(), sl, fl);
        tabLayout.setupWithViewPager(pager);
        pager.setAdapter(myYingFragmentAdapter);


        Log.e("aaa","时间戳"+listtime);
        Log.e("aaa","time"+time);

    }

    @Override
    protected void iniview() {
        tabLayout=findViewById(R.id.Paiqi_tab);
        pager=findViewById(R.id.Paiqi_Pager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_paiqi_;
    }
}
