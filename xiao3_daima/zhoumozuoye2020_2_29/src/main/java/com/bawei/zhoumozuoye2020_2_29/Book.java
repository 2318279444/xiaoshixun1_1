package com.bawei.zhoumozuoye2020_2_29;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.google.gson.Gson;

import adapter.MyAdapter;
import base.BaseActivity;
import base.BasePresenter;
import bean.BookBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class Book extends BaseActivity {
    RecyclerView recyclerView;


    @Override
    protected void inidata() {
        NetUtil.getInstance().NetBook(MyUrl.BASEBOOK2, BookBean.class, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                BookBean bookBean = gson.fromJson(stra, BookBean.class);
                MyAdapter myAdapter = new MyAdapter(bookBean.getData().getContent(),Book.this);
                recyclerView.setAdapter(myAdapter);
            }
        });
    }

    @Override
    protected void iniview() {
        recyclerView=findViewById(R.id.recyc);
        GridLayoutManager manager=new GridLayoutManager(this,2);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_book;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
