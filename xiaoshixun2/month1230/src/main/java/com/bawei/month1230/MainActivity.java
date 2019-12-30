package com.bawei.month1230;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bawei.adapter.MyFragmentAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.fragment.Fenlei;
import com.bawei.fragment.Gouwuche;
import com.bawei.fragment.Shoucang;
import com.bawei.fragment.Shouye;
import com.bawei.fragment.Wode;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    ViewPager pager;
    TabLayout tabLayout;
    List<String> slist=new ArrayList<>();
    List<Fragment> flist=new ArrayList<>();
    MyFragmentAdapter adapter;

    @Override
    protected void inidata() {
        inis();
        inif();

        adapter=new MyFragmentAdapter(getSupportFragmentManager(),slist,flist);

        pager.setAdapter(adapter);

        tabLayout.setupWithViewPager(pager);

        tabLayout.getTabAt(0).setIcon(R.drawable.shouye);
        tabLayout.getTabAt(1).setIcon(R.drawable.fl);
        tabLayout.getTabAt(2).setIcon(R.drawable.gw);
        tabLayout.getTabAt(3).setIcon(R.drawable.sc);
        tabLayout.getTabAt(4).setIcon(R.drawable.wd);


    }

    private void inif() {
        flist.add(new Shouye());
        flist.add(new Fenlei());
        flist.add(new Gouwuche());
        flist.add(new Shoucang());
        flist.add(new Wode());
    }

    private void inis() {
        slist.add("首页");
        slist.add("分类");
        slist.add("购物车");
        slist.add("收藏");
        slist.add("我的");
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
