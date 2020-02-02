package com.bawei.jiaqizuoye111;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseActivtity;
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

public class GwcActivity extends BaseActivtity implements Icontract.ToCall {
    RecyclerView recyclerView;
    TextView zongliang,zongjia;
    private Shops shops;
    CheckBox che;
    private List<Shops.ResultBean> list=new ArrayList<>();
    private MyAdapter myAdapter;
    private boolean stau;

    @Override
    protected void inidata() {

        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");
        Map<String,Object> map=new HashMap<>();
         Log.e("aaa","sessionId:"+sessionId);
        map.put("sessionId",sessionId);
        map.put("userId",27818);

        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pShop(MyUrl.BASEGWC,Shops.class,map);

        che.setOnClickListener(new View.OnClickListener() {

            private boolean stau;

            @Override
            public void onClick(View v) {
                stau = shops.isStau();
                che.setChecked(stau);
                shops.setStau(!stau);
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setStau(stau);
                    for (int j = 0; j < list.get(i).getShoppingCartList().size(); j++) {
                        list.get(i).getShoppingCartList().get(j).setStau(stau);
                        zongjia.setText(myAdapter.setpri()+"");
                        zongliang.setText(myAdapter.setCount()+"");
                    }
                }
                myAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void iniview() {
        che=findViewById(R.id.che);

        zongjia=findViewById(R.id.zongjia);
        zongliang=findViewById(R.id.zongliang);

        recyclerView=findViewById(R.id.Recyclerview);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_gwc;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void seccess(String stra) {
        Gson gson = new Gson();
        shops = gson.fromJson(stra, Shops.class);
        Log.e("aaa","vvv"+stra);
//        Log.e("aaa",""+shops.getResult().get(0).getShoppingCartList().get(0).getCommodityName());
list.addAll(shops.getResult());
        myAdapter = new MyAdapter(list,this);
        recyclerView.setAdapter(myAdapter);

        stau = shops.isStau();
        che.setChecked(stau);

        myAdapter.setShopCallBack(new MyAdapter.ShopCallBack() {
            @Override
            public void bindex(int position) {
                myAdapter.bigCallBack(position);
                zongjia.setText(myAdapter.setpri()+"");
                zongliang.setText(myAdapter.setCount()+"");
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void smallindex(int bigindex, int smallindex, boolean status) {
                myAdapter.smallCallBack(bigindex,smallindex,status);
                zongjia.setText(myAdapter.setpri()+"");
                zongliang.setText(myAdapter.setCount()+"");
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void addcount(int bigindex, int smallindex, int count) {
                myAdapter.addCallBack(bigindex,smallindex,count);
                zongjia.setText(myAdapter.setpri()+"");
                zongliang.setText(myAdapter.setCount()+"");
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}
