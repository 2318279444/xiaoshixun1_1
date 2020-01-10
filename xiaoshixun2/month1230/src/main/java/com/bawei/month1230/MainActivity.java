package com.bawei.month1230;

import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bawei.adapter.MyFragmentAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.DdBean;
import com.bawei.contract.Icontract;

import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity implements Icontract.ToCall {
    ViewPager pager;
    List<Fragment> list=new ArrayList<>();
    @Override
    protected void inidata() {
//        Map<String,Object> map=new HashMap<>();
//        map.put("userId",10962);
//        map.put("sessionId","157857265190410962");
//
//        Map<String,Object> map1=new HashMap<>();
//        map1.put("status",0);
//        map1.put("page",1);
//        map1.put("count",5);
//
//        MyPresenter myPresenter= (MyPresenter) p;
//        myPresenter.pDd(MyUrl.BASEDD, DdBean.class,map,map1);




    }

    @Override
    protected void iniview() {
//        recyclerView=findViewById(R.id.RecyclerView);
//        LinearLayoutManager manager=new LinearLayoutManager(this);
//        manager.setOrientation(RecyclerView.VERTICAL);
//        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {

    }
}
