package com.bawei.dengxianchao20191231;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.adapter.MyAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.Xinxi;
import com.bawei.contract.Ictract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.bawei.util.NetUtil;
import com.google.gson.Gson;

public class MainActivity extends BaseActivity implements Ictract.ToCall {
    RecyclerView recyclerView;
    TextView textView;

    @Override
    protected void inidata() {

        boolean connection = NetUtil.getInstance().getConnection(MainActivity.this);
        if(connection){
            MyPresenter myPresenter= (MyPresenter) p;
            myPresenter.ppxinxi(MyUrl.BASEURL,Xinxi.class);


            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, TZ.class);
                    startActivity(intent);
                }
            });
        }else {

        }


    }

    @Override
    protected void iniview() {
        textView=findViewById(R.id.fenxiang);

        recyclerView=findViewById(R.id.RecyclerView);
        LinearLayoutManager manager=new LinearLayoutManager((Context) this);
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
        Xinxi xinxi = gson.fromJson(stra, Xinxi.class);
        MyAdapter myAdapter = new MyAdapter(xinxi.getRanking(), this);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setCallBack(new MyAdapter.CallBack() {
            @Override
            public void onclick(int position) {
                Toast.makeText(MainActivity.this, ""+xinxi.getRanking().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
