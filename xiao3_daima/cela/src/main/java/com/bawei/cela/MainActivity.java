package com.bawei.cela;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        iniAcionBar();

        iniview();

    }

    private void iniview() {
        tabLayout=findViewById(R.id.tab);
        pager=findViewById(R.id.pager);
        dl=findViewById(R.id.dl);
    }

    private void iniAcionBar() {
        //获取系统的CitonBar
        ActionBar supportActionBar = getSupportActionBar();
        //默认设置图片
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        //关联DrawLayout
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);

//        actionBarDrawerToggle.syncState();
//
//        dl.addDrawerListener(actionBarDrawerToggle);

    }
}
