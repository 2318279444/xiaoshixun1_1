package com.bawei.rikao0107;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.bawei.adapter.MyAdapter;
import com.bawei.adapter.MyAdressAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.Adressbean;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Adress extends BaseActivity implements Icontract.adressCallBack {
    RecyclerView recyclerView;
    @Override
    protected void inidata() {
        //map传值
        Map<String,Object> map=new HashMap<>();
        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");
        map.put("userId",10962);
        map.put("sessionId",sessionId);
        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pAdress(MyUrl.BASEADRESS, Adressbean.class,map);
    }

    @Override
    protected void iniview() {
        recyclerView=findViewById(R.id.adressRecyclervire);

        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_adress;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        Adressbean adressbean = gson.fromJson(stra, Adressbean.class);
        MyAdressAdapter myAdressAdapter = new MyAdressAdapter(adressbean.getResult(), Adress.this);
        recyclerView.setAdapter(myAdressAdapter);
    }
}
