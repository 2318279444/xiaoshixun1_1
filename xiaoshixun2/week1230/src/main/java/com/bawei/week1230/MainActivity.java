package com.bawei.week1230;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.Shop;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements Icontract.ToCall {

    @BindView(R.id.RecyclerView)
    androidx.recyclerview.widget.RecyclerView RecyclerView;

    @Override
    protected void inidata() {

        Map<String, Object> map = new HashMap<>();
        map.put("keyword", "板鞋");
        map.put("page", 1);
        map.put("count", 5);

        MyPresenter myPresenter = (MyPresenter) p;
        myPresenter.toGits(MyUrl.BASEDATE, map, Shop.class);


    }

    @Override
    protected void iniview() {

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        RecyclerView.setLayoutManager(manager);
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
        Gson gson = new Gson();
        Shop shop = gson.fromJson(stra, Shop.class);
        MyAdapter myAdapter = new MyAdapter(shop.getResult(), this);
        RecyclerView.setAdapter(myAdapter);

        myAdapter.setCallBack(new MyAdapter.CallBack() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.this, Tiaozhuan.class);
                startActivity(intent);

            }
        });
    }

}
