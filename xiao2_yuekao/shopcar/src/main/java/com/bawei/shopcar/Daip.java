package com.bawei.shopcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.bawei.shopcar.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import adapter.MyAdapter4;
import base.BaseFragment;
import base.BasePresenter;
import bean.DingdanBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class Daip extends BaseFragment {
    RecyclerView recyclerView;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String sessionId = arguments.getString("sessionId");

        Map<String,Object> map1=new HashMap<>();
        map1.put("sessionId",sessionId);
        map1.put("userId",27818);
        Map<String,Object> map=new HashMap<>();
        map.put("status",3);
        map.put("page",1);
        map.put("count",5);

        NetUtil.getInstance().NetDingDan(MyUrl.DINGDAN, DingdanBean.class, map1, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                DingdanBean dingdanBean = gson.fromJson(stra, DingdanBean.class);
                MyAdapter4 myAdapter4 = new MyAdapter4(dingdanBean.getOrderList(), getActivity());
                recyclerView.setAdapter(myAdapter4);
            }
        });



    }

    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.recyc4);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_daip;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
