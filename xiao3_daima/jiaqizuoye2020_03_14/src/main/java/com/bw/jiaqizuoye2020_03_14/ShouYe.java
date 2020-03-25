package com.bw.jiaqizuoye2020_03_14;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.jiaqizuoye2020_03_14.database.MyGwcDao;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.MyAdapter;
import base.BaseActivity;
import base.BasePresenter;
import bean.ShopBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;


public class ShouYe extends BaseActivity implements Icontract.ToCall {
    RecyclerView recyclerView;
    TextView sumc,sump;
    CheckBox checkBox;
    List<ShopBean.ResultBean> list=new ArrayList<>();

    private String sessionId;
    private ShopBean shopBean;
    private boolean zhuangtai;
    private MyAdapter myAdapter;
    private MyGwcDao myGwcDao;
    private MyGwc myGwc;

    @Override
    protected void inidata() {

        myGwcDao = MyApp.getGwc2().getMyGwcDao();

        Intent intent = getIntent();
        sessionId = intent.getStringExtra("sessionId");
        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",27818);
        Log.e("aaa","sessionId"+sessionId);

        if(NetUtil.getInstance().getConnection(ShouYe.this)){
            MyPresenter myPresenter1= (MyPresenter) p;
            myPresenter1.pShop(MyUrl.BASE_SHOP, ShopBean.class,map);
        }else{
            Gson gson = new Gson();
            ShopBean shopBean = gson.fromJson(myGwcDao.loadAll().get(0).getUrl(), ShopBean.class);
            MyAdapter myAdapter = new MyAdapter(shopBean.getResult(), this);
            recyclerView.setAdapter(myAdapter);

//            myAdapter.setToShopCall(new MyAdapter.ToShopCall() {
//                @Override
//                public void bigindex(int position) {
//                    myAdapter.tobigc(position);
//                    sumc.setText(myAdapter.setc()+"");
//                    sump.setText(myAdapter.setp()+"");
//                    myAdapter.notifyDataSetChanged();
//                }
//
//                @Override
//                public void smallindx(int bigposition, int smallposition, boolean zhuangt) {
//                    myAdapter.tosmallc(bigposition,smallposition,zhuangt);
//                    sumc.setText(myAdapter.setc()+"");
//                    sump.setText(myAdapter.setp()+"");
//                    myAdapter.notifyDataSetChanged();
//                }
//
//                @Override
//                public void sumcount(int bigposition, int smallposition, int count) {
//                    myAdapter.tosc(bigposition,smallposition,count);
//                    sumc.setText(myAdapter.setc()+"");
//                    sump.setText(myAdapter.setp()+"");
//                    myAdapter.notifyDataSetChanged();
//                }
//            });

            Toast.makeText(this, "没有网络", Toast.LENGTH_SHORT).show();
        }



        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhuangtai = shopBean.isZhuangtai();
                checkBox.setChecked(zhuangtai);
                shopBean.setZhuangtai(!zhuangtai);
                for (int i = 0; i <list.size() ; i++) {
                    list.get(i).setZhuangtai(zhuangtai);
                    for (int j = 0; j < list.get(i).getShoppingCartList().size(); j++) {
                        list.get(i).getShoppingCartList().get(j).setZhuangtai(zhuangtai);
                        sumc.setText(myAdapter.setc()+"");
                        sump.setText(myAdapter.setp()+"");
                    }
                }
                myAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void iniview() {
        checkBox=findViewById(R.id.chceck1);

        sumc=findViewById(R.id.sumshu);
        sump=findViewById(R.id.sumpri);

        recyclerView=findViewById(R.id.recyc);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shou_ye;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        myGwc = new MyGwc(stra);

        myGwcDao.insert(myGwc);
        Gson gson = new Gson();
        shopBean = gson.fromJson(stra, ShopBean.class);


        list.addAll(shopBean.getResult());
        myAdapter = new MyAdapter(list, this);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setToShopCall(new MyAdapter.ToShopCall() {
            @Override
            public void bigindex(int position) {
                myAdapter.tobigc(position);
                sumc.setText(myAdapter.setc()+"");
                sump.setText(myAdapter.setp()+"");
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void smallindx(int bigposition, int smallposition, boolean zhuangt) {
                myAdapter.tosmallc(bigposition,smallposition,zhuangt);
                sumc.setText(myAdapter.setc()+"");
                sump.setText(myAdapter.setp()+"");
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void sumcount(int bigposition, int smallposition, int count) {
                myAdapter.tosc(bigposition,smallposition,count);
                sumc.setText(myAdapter.setc()+"");
                sump.setText(myAdapter.setp()+"");
                myAdapter.notifyDataSetChanged();
            }
        });



    }
}
