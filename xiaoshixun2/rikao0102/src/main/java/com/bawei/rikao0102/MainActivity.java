package com.bawei.rikao0102;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.Shop;
import com.bawei.contract.Iconytact;
import com.bawei.presenter.MyPresenter;
import com.bawei.rikao0102.database.MybeanDao;
import com.bawei.url.MyUrl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements Iconytact.ToCall {

    RecyclerView recyclerView;
    private MybeanDao mybeanDao;

    @Override
    protected void inidata() {
        mybeanDao = MyApp.getRikao0102().getMybeanDao();
        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pShop(MyUrl.BASEURL, Shop.class);
    }

    @Override
    protected void iniview() {
        recyclerView=findViewById(R.id.RecyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
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
    public void success(String json) {
        Gson gson = new Gson();
        Shop shop = gson.fromJson(json, Shop.class);
        MyAdapter myAdapter = new MyAdapter(shop.getResult().getMlss().getCommodityList(), this);
        recyclerView.setAdapter(myAdapter);
    }
}
