package com.bw.movie.shouye_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.shouye_fragment.shouye_paiqi.Shouye_Paiqi_Week;
import com.bw.movie.shouye_fragment.shouye_paiqi.Shouye_Paiqi_price;
import com.bw.movie.shouye_fragment.shouye_paiqi.Shouye_paiqi_Location;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.MyYingFragmentAdapter;
import base.BaseActivity;

public class ShouYe_Goupiao extends BaseActivity {
    TextView textView;
    TabLayout tabLayout;
    ViewPager pager;

    List<String> sl=new ArrayList<>();
    List<Fragment> fl=new ArrayList<>();
    private Shouye_paiqi_Location shouye_paiqi_location;
    private Shouye_Paiqi_Week shouye_paiqi_week;
    private Shouye_Paiqi_price shouye_paiqi_price;
    private String sessionId;


    @Override
    protected void inidata() {
        Intent intent = getIntent();
        String movieId = intent.getStringExtra("movieId");
        sessionId = intent.getStringExtra("sessionId");
        String namemovie = intent.getStringExtra("namemovie");

        textView.setText(namemovie);

        sl.add("海淀区");
        sl.add("...");
        sl.add("价格最低");

        Bundle bundle = new Bundle();
        bundle.putString("movieId",movieId);
        bundle.putString("sessionId", sessionId);

        Log.e("aaa","影院选择sessionId:"+sessionId);

        shouye_paiqi_location = new Shouye_paiqi_Location();
        shouye_paiqi_location.setArguments(bundle);

        shouye_paiqi_week = new Shouye_Paiqi_Week();
        shouye_paiqi_week.setArguments(bundle);

        shouye_paiqi_price = new Shouye_Paiqi_price();
        shouye_paiqi_price.setArguments(bundle);

        fl.add(shouye_paiqi_location);
        fl.add(shouye_paiqi_week);
        fl.add(shouye_paiqi_price);

        MyYingFragmentAdapter myYingFragmentAdapter = new MyYingFragmentAdapter(getSupportFragmentManager(), sl, fl);

        tabLayout.setupWithViewPager(pager);

        pager.setAdapter(myYingFragmentAdapter);




    }


    @Override
    protected void iniview() {
        tabLayout=findViewById(R.id.Shouye_Paiqi_tab);
        pager=findViewById(R.id.Shouye_Paiqi_pager);
        textView=findViewById(R.id.Shouye_paiqi_text);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shou_ye__goupiao;
    }
}
