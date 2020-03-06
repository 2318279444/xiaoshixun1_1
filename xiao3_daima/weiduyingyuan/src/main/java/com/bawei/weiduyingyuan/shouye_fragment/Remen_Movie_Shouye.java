package com.bawei.weiduyingyuan.shouye_fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.weiduyingyuan.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import adapter.ShouyeAdapter.MyShouye_Remne_Adapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.shouye.RemenBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;

public class Remen_Movie_Shouye extends BaseFragment implements Icontract.ToCall {
    RecyclerView recyclerView;


    @Override
    protected void inidata(Bundle savedInstanceState) {
        Map<String,Object> map=new HashMap<>();
        map.put("page",1);
        map.put("count",22);

        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pRemenMovie(MyUrl.BASE_Remen_Movie, RemenBean.class,map);
    }

    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.remen_Shouye_Movie);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_remen__movie__shouye;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        RemenBean remenBean = gson.fromJson(stra, RemenBean.class);
        MyShouye_Remne_Adapter myShouye_remne_adapter = new MyShouye_Remne_Adapter(remenBean.getResult(), getActivity());
        recyclerView.setAdapter(myShouye_remne_adapter);
    }
}
