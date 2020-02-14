package com.bawei.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bawei.adapter.MyAdapter;
import com.bawei.adapter.MyAdapter2;
import com.bawei.base.BaseFragment;
import com.bawei.base.BasePresenter;
import com.bawei.bean.Shops;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.rikao0111.Pay;
import com.bawei.rikao0111.R;
import com.bawei.url.MyUrl;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Quanbu extends BaseFragment implements Icontract.ToCall {
    RecyclerView recyclerView;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        Map<String,Object> map=new HashMap<>();
        map.put("sessionId","158140189585227818");
        map.put("userId",27818);
        Map<String,Object> map1=new HashMap<>();
        map1.put("status",0);
        map1.put("page",1);
        map1.put("count",5);


        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pDingDan(MyUrl.BASEDD, Shops.class,map,map1);
    }

    @Override
    protected void iniview(View view) {

        recyclerView=getActivity().findViewById(R.id.RecyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_quanbu;
    }

    @Override
    protected BasePresenter Opresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        Shops shops = gson.fromJson(stra, Shops.class);
        MyAdapter myAdapter = new MyAdapter(shops.getOrderList(), getActivity());
        recyclerView.setAdapter(myAdapter);


    }
}
