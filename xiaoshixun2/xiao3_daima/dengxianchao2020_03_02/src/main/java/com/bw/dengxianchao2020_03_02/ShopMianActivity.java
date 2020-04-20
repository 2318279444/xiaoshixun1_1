package com.bw.dengxianchao2020_03_02;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Toast;

import com.google.gson.Gson;

import adapter.MyAdapter;
import adapter.MyAdapter2;
import adapter.MyAdapter3;
import base.BaseAcitivity;
import base.BasePresenter;
import bean.ShopBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;
import util.NetWork1;

public class ShopMianActivity extends BaseAcitivity implements Icontract.ToCall {
    RecyclerView recyclerView1,recyclerView2,recyclerView3;


    @Override
    protected void inidata() {

        //网络判断
        boolean b = NetWork1.getConnection(ShopMianActivity.this);
        if(b){
            //信息展示
            ininet();
        }else {
            Toast.makeText(this, "无网络", Toast.LENGTH_SHORT).show();
            NetUtil.getInstance().NetShop(MyUrl.BASESHOP, ShopBean.class, new Icontract.ToCall() {
                @Override
                public void success(String stra) {
                    Gson gson = new Gson();
                    ShopBean shopBean = gson.fromJson(stra, ShopBean.class);
                    MyAdapter myAdapter = new MyAdapter(shopBean.getResult().getRxxp().getCommodityList(),ShopMianActivity.this);
                    recyclerView1.setAdapter(myAdapter);
                }
            });

            NetUtil.getInstance().NetShop(MyUrl.BASESHOP, ShopBean.class, new Icontract.ToCall() {
                @Override
                public void success(String stra) {
                    Gson gson = new Gson();
                    ShopBean shopBean = gson.fromJson(stra, ShopBean.class);
                    MyAdapter3 myAdapter = new MyAdapter3(shopBean.getResult().getPzsh().getCommodityList(),ShopMianActivity.this);
                    recyclerView3.setAdapter(myAdapter);
                }
            });


            NetUtil.getInstance().NetShop(MyUrl.BASESHOP, ShopBean.class, new Icontract.ToCall() {
                @Override
                public void success(String stra) {
                    Gson gson = new Gson();
                    ShopBean shopBean = gson.fromJson(stra, ShopBean.class);
                    MyAdapter2 myAdapter = new MyAdapter2(shopBean.getResult().getMlss().getCommodityList(),ShopMianActivity.this);
                    recyclerView2.setAdapter(myAdapter);
                }
            });
        }



    }



    @Override
    protected void iniview() {
        recyclerView1=findViewById(R.id.recyc1);
        GridLayoutManager manager=new GridLayoutManager(this,3);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView1.setLayoutManager(manager);

        recyclerView2=findViewById(R.id.recyc2);
        LinearLayoutManager manager2=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView2.setLayoutManager(manager2);

        recyclerView3=findViewById(R.id.recyc3);
        GridLayoutManager manager3=new GridLayoutManager(this,2);
        manager3.setOrientation(RecyclerView.VERTICAL);
        recyclerView3.setLayoutManager(manager3);

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shop_mian;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }

    @Override
    public void success(String stra) {

    }

    private void ininet() {
        NetUtil.getInstance().NetShop(MyUrl.BASESHOP, ShopBean.class, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                ShopBean shopBean = gson.fromJson(stra, ShopBean.class);
                MyAdapter myAdapter = new MyAdapter(shopBean.getResult().getRxxp().getCommodityList(),ShopMianActivity.this);
                recyclerView1.setAdapter(myAdapter);
            }
        });

        NetUtil.getInstance().NetShop(MyUrl.BASESHOP, ShopBean.class, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                ShopBean shopBean = gson.fromJson(stra, ShopBean.class);
                MyAdapter3 myAdapter = new MyAdapter3(shopBean.getResult().getPzsh().getCommodityList(),ShopMianActivity.this);
                recyclerView3.setAdapter(myAdapter);
            }
        });


        NetUtil.getInstance().NetShop(MyUrl.BASESHOP, ShopBean.class, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                ShopBean shopBean = gson.fromJson(stra, ShopBean.class);
                MyAdapter2 myAdapter = new MyAdapter2(shopBean.getResult().getMlss().getCommodityList(),ShopMianActivity.this);
                recyclerView2.setAdapter(myAdapter);
            }
        });
    }
}
