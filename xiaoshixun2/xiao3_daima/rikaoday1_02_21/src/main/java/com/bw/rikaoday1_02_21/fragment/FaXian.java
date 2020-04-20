package com.bw.rikaoday1_02_21.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bw.rikaoday1_02_21.Main2ActivityDD;
import com.bw.rikaoday1_02_21.R;
import com.bw.rikaoday1_02_21.fragment.ddfragment.DaiAll;
import com.bw.rikaoday1_02_21.fragment.ddfragment.DaiFinish;
import com.bw.rikaoday1_02_21.fragment.ddfragment.DaiFu;
import com.bw.rikaoday1_02_21.fragment.ddfragment.DaiShou;
import com.bw.rikaoday1_02_21.fragment.ddfragment.Daipj;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import base.BaseFragment;
import base.BasePresenter;

public class FaXian extends BaseFragment {

    LinearLayout fax;

    TabLayout tabLayout;
    ViewPager pager;
    List<String> sl=new ArrayList<>();
    List<Fragment> fl=new ArrayList<>();
    private DaiAll daiAll;
    private DaiFu daiFu;
    private DaiShou daiShou;
    private Daipj daipj;
    private DaiFinish daiFinish;
    private String sessionId;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        sl.add("查看全部");
        sl.add("待付款");
        sl.add("待收货");
        sl.add("待评价");
        sl.add("已完成");

        Bundle arguments = getArguments();
        sessionId = arguments.getString("sessionId");

        Log.e("aaa","faxiansessionId:"+ sessionId);

        Bundle bundle = new Bundle();
        bundle.putString("sessionId", sessionId);






        fax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main2ActivityDD.class);
                intent.putExtra("sessionId",sessionId);


                startActivity(intent);
            }
        });



    }

    @Override

    protected void iniview(View view) {
        fax=getActivity().findViewById(R.id.fax);



        tabLayout=getActivity().findViewById(R.id.tab);
        pager=getActivity().findViewById(R.id.pager);

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_fa_xian;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
