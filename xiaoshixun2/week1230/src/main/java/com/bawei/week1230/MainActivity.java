package com.bawei.week1230;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.GsmCellLocation;
import android.widget.Toast;

import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.Shop;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity implements Icontract.ToCall {
    RecyclerView recyclerView;

    @Override
    protected void inidata() {

        Map<String,Object> map=new HashMap<>();
        map.put("keyword","板鞋");
        map.put("page",1);
        map.put("count",5);

        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.toGits(MyUrl.BASEDATE,map, Shop.class);


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
    public void success(String stra) {
        Gson gson = new Gson();
        Shop shop = gson.fromJson(stra, Shop.class);
        MyAdapter myAdapter = new MyAdapter(shop.getResult(), this);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setCallBack(new MyAdapter.CallBack() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.this, Tiaozhuan.class);
                startActivity(intent);

            }
        });
    }
}
