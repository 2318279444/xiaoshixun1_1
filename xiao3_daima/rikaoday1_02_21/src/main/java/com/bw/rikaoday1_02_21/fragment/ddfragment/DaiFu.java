package com.bw.rikaoday1_02_21.fragment.ddfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.rikaoday1_02_21.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import adapter.adapterr.MyDDAdapter2;
import base.BaseFragment;
import base.BasePresenter;
import bean.DdBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class DaiFu extends BaseFragment {
    RecyclerView recyclerView;


    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String sessionId = arguments.getString("sessionId");
        Log.e("aaa","全部,收货,付款"+sessionId);
        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",27818);
        Map<String,Object> map1=new HashMap<>();
        map1.put("status",1);
        map1.put("page",1);
        map1.put("count",5);

        NetUtil.getInstance().NetDD(MyUrl.BASEDD, DdBean.class, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                DdBean ddBean = gson.fromJson(stra, DdBean.class);
                MyDDAdapter2 myDDAdapter1 = new MyDDAdapter2(ddBean.getOrderList(), getActivity());
                recyclerView.setAdapter(myDDAdapter1);

            }
        });
    }

    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.recyc2);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);




    }

    @Override
    protected int inilayout() {
        return R.layout.activity_dai_fu;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
