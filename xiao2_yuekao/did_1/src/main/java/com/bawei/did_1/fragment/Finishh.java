package com.bawei.did_1.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.bawei.did_1.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import adapter.item.MyAdapter5;
import base.BaseFragment;
import base.BasePresenter;
import bean.DingDanBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class Finishh extends BaseFragment {
    RecyclerView recyclerView;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        Object sessionId = arguments.get("sessionId");
        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",27818);

        Map<String,Object> map1=new HashMap<>();
        map1.put("status",9);
        map1.put("page",1);
        map1.put("count",5);

        NetUtil.getInstance().NetDd(MyUrl.BASEDINGDAN, DingDanBean.class, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                DingDanBean dingDanBean = gson.fromJson(stra, DingDanBean.class);
                MyAdapter5 myAdapter = new MyAdapter5(dingDanBean.getOrderList(), getActivity());
                recyclerView.setAdapter(myAdapter);
            }
        });
    }

    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.recyc5);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_finishh;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
