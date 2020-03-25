package com.bw.dengxianchao20200224;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.Map;

import adapter.MyAdapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.LiWuBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;

public class MyShou extends BaseFragment implements Icontract.Tocall {

    RecyclerView recyclerView;

    SmartRefreshLayout smartRefreshLayout;

    @Override
    protected void inidata(Bundle savedInstanceState) {

        smartRefreshLayout.setEnableLoadMore(true);
        smartRefreshLayout.setEnableRefresh(true);

        //入参传递的参数
        //传递userid和sessionid
        Map<String,Object> map=new HashMap<>();
        map.put("userId",11);
        map.put("sessionId","158252187763511");

        //传递到是类型,页数,个数
        Map<String,Object> map1=new HashMap<>();
        map1.put("type",1);
        map1.put("page",1);
        map1.put("size",5);
        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pliwu(MyUrl.BASEURL, LiWuBean.class,map,map1);
    }

    @Override
    protected void iniview(View view) {
        //获取id,以及排列方式
        smartRefreshLayout=getActivity().findViewById(R.id.fre1);

        recyclerView=getActivity().findViewById(R.id.recyc1);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_my_shou;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        //解析以及展示数据
        Gson gson = new Gson();
        LiWuBean liWuBean = gson.fromJson(stra, LiWuBean.class);
        MyAdapter myAdapter = new MyAdapter(liWuBean.getResult(), getActivity());
        recyclerView.setAdapter(myAdapter);


        Log.e("aaa",""+liWuBean.getMessage());
    }
}
