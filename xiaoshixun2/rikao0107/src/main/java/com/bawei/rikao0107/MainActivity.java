package com.bawei.rikao0107;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.Shops;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity implements Icontract.ToCall {
    RecyclerView recyclerView;


    @Override
    protected void inidata() {
        Map<String,Object> map=new HashMap<>();
        map.put("sessionId","157835834666510962");
        map.put("userId",10962);
        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pShop(MyUrl.BASEURL, Shops.class,map);
    }

    @Override
    protected void iniview() {
        recyclerView=findViewById(R.id.Recyclerview);

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
    public void success(String stra) {
        Gson gson = new Gson();
        Shops shops = gson.fromJson(stra, Shops.class);
        MyAdapter myAdapter = new MyAdapter(shops.getResult(), this);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setShopCallBack(new MyAdapter.ShopCallBack() {
            @Override
            public void bigindex(int position) {
                myAdapter.bigindex(position);
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}
