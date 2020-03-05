package com.bawei.weiduyingyuan.yingyuan;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bawei.weiduyingyuan.R;
import com.bawei.weiduyingyuan.yingyuan.YingXiangqingFragment.MovieElaFragment;
import com.bawei.weiduyingyuan.yingyuan.YingXiangqingFragment.MovieXQFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.MyYingFragmentAdapter;
import base.BaseActivity;

public class YingTuiJianXiangqing extends BaseActivity {
    ImageView fanhui;
    TextView nameXQ;

    List<String> sl=new ArrayList<>();
    List<Fragment> fl=new ArrayList<>();

    TabLayout tabLayout;
    ViewPager pager;
    private MovieXQFragment movieXQFragment;
    private MovieElaFragment movieElaFragment;

    @Override
    protected void inidata() {
        //获取影院页面传过来的值
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
        String yyid = intent.getStringExtra("yid");
        String sessionId = intent.getStringExtra("sessionId");
        int yid= Integer.parseInt(yyid);


        Log.e("aaa","详情name:"+name);
        Log.e("aaa","详情address:"+address);
        Log.e("aaa","影院id:"+yid);

        //返回锐减影院页面
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //影院详情
        nameXQ.setText(name+"("+address+")");


        sl.add("影院详情");
        sl.add("影院评价");

        Bundle bundle = new Bundle();
        bundle.putString("yid", String.valueOf(yid));
        bundle.putString("sessionId",sessionId);

        movieXQFragment = new MovieXQFragment();
        movieXQFragment.setArguments(bundle);


        movieElaFragment = new MovieElaFragment();
        movieElaFragment.setArguments(bundle);

        fl.add(movieXQFragment);
        fl.add(movieElaFragment);

        MyYingFragmentAdapter myYingFragmentAdapter = new MyYingFragmentAdapter(getSupportFragmentManager(), sl, fl);
        tabLayout.setupWithViewPager(pager);
        pager.setAdapter(myYingFragmentAdapter);


    }

    @Override
    protected void iniview() {

        fanhui=findViewById(R.id.tuijianXQfanhui);
        nameXQ=findViewById(R.id.texttuijianXQ);


        tabLayout=findViewById(R.id.tabXQ);
        pager=findViewById(R.id.pagerXQ);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_ying_tui_jian_xiangqing;
    }
}
