package com.bawei.weiduyingyuan.YingFragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bawei.weiduyingyuan.R;
import com.bawei.weiduyingyuan.yingyuan.YingTuiJianXiangqing;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import adapter.YingAdapter.MyMovieFujinAdapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.Ying.YingFujinBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;

public class YingFuJin extends BaseFragment implements Icontract.ToCall {
    RecyclerView recyclerView;
    private String sessionId;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        sessionId = arguments.getString("sessionId");
        Log.e("aaa","yingfujin:sessionId:"+ sessionId);

        Map<String,Object> map=new HashMap<>();
        map.put("sessionId", sessionId);
        map.put("userId",13752);

        Map<String,Object> map1=new HashMap<>();
        map1.put("longitude","116.30551391385724");
        map1.put("latitude","40.04571807462411");
        map1.put("page",1);
        map1.put("count",10);

        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pFujinMovie(MyUrl.BASEYING_FUJIN, YingFujinBean.class,map,map1);

    }

    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.recyc_fujin);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_ying_fu_jin;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        YingFujinBean yingFujinBean = gson.fromJson(stra, YingFujinBean.class);
        MyMovieFujinAdapter myMovieFujinAdapter = new MyMovieFujinAdapter(yingFujinBean.getResult(), getActivity());
        recyclerView.setAdapter(myMovieFujinAdapter);

        myMovieFujinAdapter.setOnFujinMovieCallBack(new MyMovieFujinAdapter.onFujinMovieCallBack() {
            @Override
            public void onClick(int position) {
                String name = yingFujinBean.getResult().get(position).getName();
                String address = yingFujinBean.getResult().get(position).getAddress();
                int id = yingFujinBean.getResult().get(position).getId();
                String yid= String.valueOf(id);
                Intent intent = new Intent(getActivity(), YingTuiJianXiangqing.class);
                intent.putExtra("name",name);
                intent.putExtra("address",address);
                intent.putExtra("sessionId",sessionId);
                intent.putExtra("yid",yid);
                startActivity(intent);
            }
        });
    }
}
