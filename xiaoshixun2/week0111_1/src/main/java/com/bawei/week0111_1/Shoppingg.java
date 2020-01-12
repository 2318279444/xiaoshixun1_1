package com.bawei.week0111_1;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.ShopBean;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Shoppingg extends BaseActivity implements Icontract.ToCall {
    ImageView imageView;
    TextView textView;


    TextView zongjia,zongliang;

    RecyclerView recyclerView;


    @Override
    protected void inidata() {
        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");

        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",10962);


        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pShop(MyUrl.BaseGWC, ShopBean.class,map);




        String pic = intent.getStringExtra("pic");
        Glide.with(this).load(pic)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                .into(imageView);
        String phone = intent.getStringExtra("phone");
        textView.setText(phone);



    }

    @Override
    protected void iniview() {

        zongjia=findViewById(R.id.zongjia);
        zongliang=findViewById(R.id.zongliang);

        recyclerView=findViewById(R.id.Recyclerview);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

        imageView=findViewById(R.id.ima);
        textView=findViewById(R.id.se);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shopping;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }



    @Override
    public void successshop(String stra) {
        Gson gson = new Gson();
        ShopBean shopBean = gson.fromJson(stra, ShopBean.class);
        MyAdapter myAdapter = new MyAdapter(shopBean.getResult(), this);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setShopCallBack(new MyAdapter.ShopCallBack() {
            @Override
            public void bigindex(int bigindex) {
                myAdapter.bigindexCallBack(bigindex);
                zongliang.setText(myAdapter.sumcount()+"");
                zongjia.setText(myAdapter.sumprice()+"");
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void samllindex(int bigindex, int smallindex, boolean stadus) {
                myAdapter.smallindexCallBack(bigindex,smallindex,stadus);
                zongliang.setText(myAdapter.sumcount()+"");
                zongjia.setText(myAdapter.sumprice()+"");
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void addindex(int bigindex, int smallindex, int count) {
                myAdapter.addindexCallBack(bigindex,smallindex,count);
                zongliang.setText(myAdapter.sumcount()+"");
                zongjia.setText(myAdapter.sumprice()+"");
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}
