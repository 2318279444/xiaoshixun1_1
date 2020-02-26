package com.bawei.dengxianchao20200224;

import androidx.appcompat.app.AppCompatActivity;
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
import adapter.MyAdapter2;
import base.BaseFragment;
import base.BasePresenter;
import bean.LiWuBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class MySong extends BaseFragment {
    RecyclerView recyclerView;
    SmartRefreshLayout smartRefreshLayout;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        //支持上拉刷新和下拉加载
        smartRefreshLayout.setEnableLoadMore(true);
        smartRefreshLayout.setEnableRefresh(true);
        //入参传递的参数
        //传递userid和sessionid
        Map<String,Object> map=new HashMap<>();
        map.put("userId",11);
        map.put("sessionId","158252187763511");

        //传递类型页数个数
        Map<String,Object> map1=new HashMap<>();
        map1.put("type",2);
        map1.put("page",1);
        map1.put("size",5);

        NetUtil.getInstance().NetLiwu(MyUrl.BASEURL, LiWuBean.class, map, map1, new Icontract.Tocall() {
            @Override
            public void success(String stra) {
                //解析数据以及展示数据
                Gson gson = new Gson();
                LiWuBean liWuBean = gson.fromJson(stra, LiWuBean.class);
                MyAdapter2 myAdapter = new MyAdapter2(liWuBean.getResult(), getActivity());
                recyclerView.setAdapter(myAdapter);

                Log.e("aaa",""+liWuBean.getMessage());
            }
        });
    }

    @Override
    protected void iniview(View view) {

        //获取控件id和排列方式;
        smartRefreshLayout=getActivity().findViewById(R.id.fre2);

        recyclerView=getActivity().findViewById(R.id.recyc2);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_my_song;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
