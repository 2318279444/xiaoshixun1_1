package com.bawei.jiaqizuoye222;

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

public class GwcActivityyyy extends BaseActivity implements Icontract.ToCall {
    RecyclerView recyclerView;
    private TextView co,pr;
    private CheckBox che;
    private Shops shops;
    List<Shops.ResultBean> list=new ArrayList<>();
    private boolean stu;
    private MyAdapter myAdapter;

    @Override
    protected void inidata() {
        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");
        Log.e("aaa","sessionIdsessionId:"+sessionId);

        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",27818);

        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pShop(MyUrl.BASEGWC, Shops.class,map);


        che.setOnClickListener(new View.OnClickListener() {

            private boolean stu;

            @Override
            public void onClick(View v) {
                stu = shops.isStu();
                che.setChecked(stu);
                shops.setStu(!stu);
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setStu(stu);
                    for (int j = 0; j < list.get(i).getShoppingCartList().size(); j++) {
                        list.get(i).getShoppingCartList().get(j).setStu(stu);

                        co.setText(myAdapter.sumc()+"");
                        pr.setText(myAdapter.sump()+"");
                    }

                }
                myAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void iniview() {
        che=findViewById(R.id.che);

        co=findViewById(R.id.zl);
        pr=findViewById(R.id.zj);

        recyclerView=findViewById(R.id.RecyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_gwc_activityyyy;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        shops = gson.fromJson(stra, Shops.class);


        stu = shops.isStu();
        che.setChecked(stu);

        list.addAll(shops.getResult());
        myAdapter = new MyAdapter(list, this);
        recyclerView.setAdapter(myAdapter);



        myAdapter.setShopCallBack(new MyAdapter.ShopCallBack() {
            @Override
            public void bigindex(int bigposition) {
                myAdapter.bigCallBack(bigposition);
                co.setText(myAdapter.sumc()+"");
                pr.setText(myAdapter.sump()+"");
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void smallidnex(int bigposition, int smallposition, boolean stuuuu) {
                myAdapter.smallCallBack(bigposition,smallposition,stuuuu);
                co.setText(myAdapter.sumc()+"");
                pr.setText(myAdapter.sump()+"");
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void addin(int bigposition, int smallposition, int count) {
                myAdapter.addCallAdapter(bigposition,smallposition,count);
                co.setText(myAdapter.sumc()+"");
                pr.setText(myAdapter.sump()+"");
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}
