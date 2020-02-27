package com.bawei.rikaoday1_02_21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bawei.rikaoday1_02_21.fragment.FaXian;
import com.bawei.rikaoday1_02_21.fragment.ShoYe;
import com.bawei.rikaoday1_02_21.fragment.WoDe;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<String> slist=new ArrayList<>();
    List<Fragment> flist=new ArrayList<>();
    private WoDe woDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tab);
        pager=findViewById(R.id.pager);


        //给tablayout添加引导词
        slist.add("首页");
        slist.add("发现");
        slist.add("我的");

        //获取登陆页面传过来的数据
        //传递到dragment里面
        Intent intent = getIntent();
        String headPic = intent.getStringExtra("headPic");
        //打印传递到信息
        Log.e("aaa",""+headPic);

        woDe = new WoDe();
        Bundle bundle = new Bundle();
        bundle.putString("headPic",headPic);
        woDe.setArguments(bundle);



        //添加fragment页面
        flist.add(new ShoYe());
        flist.add(new FaXian());
        flist.add(woDe);




        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), slist, flist);

        //fragment和底部导航栏连接起来
        tabLayout.setupWithViewPager(pager);


        //展示
        pager.setAdapter(myAdapter);

        //设置点击的改变图标的动画
        tabLayout.getTabAt(0).setIcon(R.drawable.sy);
        tabLayout.getTabAt(1).setIcon(R.drawable.fx);
        tabLayout.getTabAt(2).setIcon(R.drawable.wd);
    }


}
