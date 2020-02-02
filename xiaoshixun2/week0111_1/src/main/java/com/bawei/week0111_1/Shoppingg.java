package com.bawei.week0111_1;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shoppingg extends BaseActivity implements Icontract.ToCall {
    ImageView imageView;
    TextView textView;
    SmartRefreshLayout smartRefreshLayout;


    TextView zongjia,zongliang;

    RecyclerView recyclerView;

    CheckBox che;
    private ShopBean shopBean;

    List<ShopBean.ResultBean> list=new ArrayList<>();
    private MyAdapter myAdapter;
    private boolean status;


    @Override
    protected void inidata() {
        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");

        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",27818);


        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pShop(MyUrl.BaseGWC, ShopBean.class,map);

        smartRefreshLayout.setEnableRefresh(true);
        smartRefreshLayout.setEnableLoadMore(true);
        smartRefreshLayout.finishRefresh();
        smartRefreshLayout.finishLoadMore();




        che.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 shopBean.setStadus(!status);
                status = shopBean.isStadus();
                che.setChecked(status);

                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setStadus(status);
                    for (int j = 0; j < list.get(i).getShoppingCartList().size(); j++) {
                        list.get(i).getShoppingCartList().get(j).setStadus(status);
                    }
                }
                myAdapter.notifyDataSetChanged();
            }
        });




        String pic = intent.getStringExtra("pic");
        Glide.with(this).load(pic)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                .into(imageView);
        String phone = intent.getStringExtra("phone");
        textView.setText(phone);

    }

    @Override
    protected void iniview() {
        smartRefreshLayout=findViewById(R.id.fresh);

        zongjia=findViewById(R.id.zongjia);
        zongliang=findViewById(R.id.zongliang);

        recyclerView=findViewById(R.id.Recyclerview);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

        imageView=findViewById(R.id.ima);
        textView=findViewById(R.id.se);

        che=findViewById(R.id.che);
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
        shopBean = gson.fromJson(stra, ShopBean.class);
        list.addAll(shopBean.getResult());
        myAdapter = new MyAdapter(list, this);
        recyclerView.setAdapter(myAdapter);

        status = shopBean.isStadus();
        che.setChecked(status);

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
