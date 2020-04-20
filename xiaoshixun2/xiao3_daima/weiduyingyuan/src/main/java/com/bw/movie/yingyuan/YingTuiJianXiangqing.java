package com.bw.movie.yingyuan;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.yingyuan.paiq.Paiqi_Activity;
import com.bw.movie.Pinglun_Acitivity;
import com.bw.movie.R;
import com.bw.movie.yingyuan.YingXiangqingFragment.MovieElaFragment;
import com.bw.movie.yingyuan.YingXiangqingFragment.MovieXQFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.MyYingFragmentAdapter;
import base.BaseActivity;

public class YingTuiJianXiangqing extends BaseActivity {
    ImageView fanhui;
    TextView nameXQ;

    RelativeLayout paiqi,plun;

    List<String> sl=new ArrayList<>();
    List<Fragment> fl=new ArrayList<>();

    TabLayout tabLayout;
    ViewPager pager;
    private MovieXQFragment movieXQFragment;
    private MovieElaFragment movieElaFragment;
    private String yyid;

    @Override
    protected void inidata() {

        paiqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YingTuiJianXiangqing.this, Paiqi_Activity.class);
                intent.putExtra("id",yyid);
                startActivity(intent);
            }
        });

        plun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(YingTuiJianXiangqing.this, Pinglun_Acitivity.class));
            }
        });


        //获取影院页面传过来的值
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
        yyid = intent.getStringExtra("yid");
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

        paiqi=findViewById(R.id.Yingyuan_Paiqi);
        plun=findViewById(R.id.Yingyuan_Pinglun);

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
