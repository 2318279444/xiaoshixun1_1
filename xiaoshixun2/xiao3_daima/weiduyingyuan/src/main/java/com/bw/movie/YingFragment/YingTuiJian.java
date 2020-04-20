package com.bw.movie.YingFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.yingyuan.YingTuiJianXiangqing;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.Map;

import adapter.YingAdapter.MyMovieRecommendAdapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.Ying.YingTuijianBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;

public class YingTuiJian extends BaseFragment implements Icontract.ToCall {
    RecyclerView recyclerView;
    SmartRefreshLayout smartRefreshLayout;
    private String sessionId;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        sessionId = arguments.getString("sessionId");
        Log.e("aaa","yingtuijian:sessionId:"+ sessionId);




        Map<String,Object> map=new HashMap<>();
        map.put("sessionId", sessionId);
        map.put("userId",13752);

        HashMap<String,Object> map1=new HashMap<>();
        map1.put("page",1);
        map1.put("count",15);

        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.preCommendMovie(MyUrl.BASERecommendMove, YingTuijianBean.class,map,map1);

    }

    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.recycTuijian);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_ying_tui_jian;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        YingTuijianBean yingTuijianBean = gson.fromJson(stra, YingTuijianBean.class);
        MyMovieRecommendAdapter myMovieRecommendAdapter = new MyMovieRecommendAdapter(yingTuijianBean.getResult(), getActivity());
        recyclerView.setAdapter(myMovieRecommendAdapter);

        myMovieRecommendAdapter.setOnRecommendMovieCallBack(new MyMovieRecommendAdapter.onRecommendMovieCallBack() {
            @Override
            public void onClick(int position) {
                String name = yingTuijianBean.getResult().get(position).getName();
                String address = yingTuijianBean.getResult().get(position).getAddress();
                int id = yingTuijianBean.getResult().get(position).getId();
                String yid = String.valueOf(id);
                Intent intent = new Intent(getActivity(), YingTuiJianXiangqing.class);
                intent.putExtra("name",name);
                intent.putExtra("address",address);
                intent.putExtra("yid",yid);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);
            }
        });
    }
}
