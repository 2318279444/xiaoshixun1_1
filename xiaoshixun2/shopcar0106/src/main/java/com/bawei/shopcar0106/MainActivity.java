package com.bawei.shopcar0106;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.ShopBean;
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
        map.put("sessionId","157831180048710962");
        map.put("userId",10962);

        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pShop(MyUrl.BASEURL, ShopBean.class,map);
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
        ShopBean shopBean = gson.fromJson(stra, ShopBean.class);
        MyAdapter myAdapter = new MyAdapter(shopBean.getResult(), this);
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
