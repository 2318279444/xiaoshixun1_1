package com.bawei.rikao0107;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.Shops;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



//购物车就是在接口里面候区数据.真实数据,页面可以实现联动效果,又全选和反选,以及价格数量商品总价的一个联动



//加密算法有对称加密和非对称加密,对此加密是AES和DES,非对称加密是RSA,还有MD5
//MD5是一个不可逆的加密方式,还有https



public class MainActivity extends BaseActivity implements Icontract.ToCall {
    RecyclerView recyclerView;
    TextView textViewprice,textViewcount;
    Button button;
    CheckBox checkBox;
    private Shops shops;
    private String sessionId;

    @Override
    protected void inidata() {



        Map<String,Object> map=new HashMap<>();

        Intent intent = getIntent();
        sessionId = intent.getStringExtra("sessionId");
        map.put("sessionId", sessionId);
        map.put("userId",10962);
        MyPresenter myPresenter= (MyPresenter) p;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        myPresenter.pShop(MyUrl.BASEURL, Shops.class,map);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Login.class));
            }
        });
    }

    @Override
    protected void iniview() {
        checkBox=findViewById(R.id.checkwai);

        button=findViewById(R.id.dd);

        textViewprice=findViewById(R.id.zongjia);
        textViewcount=findViewById(R.id.zongliang);

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
        shops = gson.fromJson(stra, Shops.class);
        MyAdapter myAdapter = new MyAdapter(shops.getResult(), this);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setShopCallBack(new MyAdapter.ShopCallBack() {
            @Override
            public void bigindex(int position) {
                myAdapter.bigindex(position);
                textViewprice.setText(myAdapter.sumprice()+"");
                textViewcount.setText(myAdapter.sumcount()+"");
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void smallindex(int bigposition, int smallposition, boolean stats) {
                myAdapter.smallindex(bigposition,smallposition,stats);
                textViewprice.setText(myAdapter.sumprice()+"");
                textViewcount.setText(myAdapter.sumcount()+"");
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void jiajian(int bigposition, int smallposition, int count) {
                myAdapter.jiajiancount(bigposition,smallposition,count);
                textViewprice.setText(myAdapter.sumprice()+"");
                textViewcount.setText(myAdapter.sumcount()+"");
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.this, Adress.class);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);
            }
        });
    }
}
