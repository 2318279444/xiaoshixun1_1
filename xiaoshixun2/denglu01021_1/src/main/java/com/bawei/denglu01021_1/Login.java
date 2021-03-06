package com.bawei.denglu01021_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.base.Shops;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Login extends BaseActivity implements Icontract.ToShopCall {
    RecyclerView recyclerView;
    @Override
    protected void inidata() {

        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");

        Map<String,Object> map=new HashMap<>();
        map.put("userId",10962);
        map.put("sessionId",sessionId);
        Log.e("aaa",""+intent.getStringExtra("sessionId"));
        MyPresenter myPresenter= (MyPresenter) p;
         myPresenter.pShop(MyUrl.BASEGWC, Shops.class,map);
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
        return R.layout.activity_login;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        Shops shops = gson.fromJson(stra, Shops.class);
        MyAdapter myAdapter = new MyAdapter(shops.getResult(), this);
        recyclerView.setAdapter(myAdapter);
    }
}
