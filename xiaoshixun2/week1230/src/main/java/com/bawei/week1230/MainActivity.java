package com.bawei.week1230;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.GsmCellLocation;

import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.Shop;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends BaseActivity implements Icontract.ToCall {
    RecyclerView recyclerView;

    @Override
    protected void inidata() {
        EventBus.getDefault().post("发送数据");
        MyPresenter myPresenter= (MyPresenter) p;
         myPresenter.toGits(MyUrl.BASEDATE, Shop.class);
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
        MyAdapter myAdapter = new MyAdapter(shop.getResult().getMlss().getCommodityList(), this);
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
