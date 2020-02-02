package com.bawei.rikao0111;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.bawei.adapter.MyFragmentAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.fragment.Daifk;
import com.bawei.fragment.Daipj;
import com.bawei.fragment.Daish;
import com.bawei.fragment.Quanbu;
import com.bawei.fragment.Yiwc;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    TabLayout tabLayout;
    ViewPager pager;

    List<String> slist=new ArrayList<>();
    List<Fragment> flist=new ArrayList<>();
    @Override
    protected void inidata() {
        inis();

        inif();

        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), slist, flist);

        pager.setAdapter(myFragmentAdapter);
        tabLayout.setupWithViewPager(pager);
    }

    private void inif() {
        flist.add(new Quanbu());
        flist.add(new Daifk());
        flist.add(new Daish());
        flist.add(new Daipj());
        flist.add(new Yiwc());
    }

    private void inis() {
        slist.add("全部");
        slist.add("待付款");
        slist.add("待收货");
        slist.add("待评价");
        slist.add("已完成");
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
