package com.bw.movie.shouye_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import adapter.ShouyeAdapter.MyShouye_Remne_Adapter;
import adapter.ShouyeAdapter.MyShouye_jijiang_Adapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.shouye.RemenBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;

public class Remen_Movie_Shouye extends BaseFragment implements Icontract.ToCall {
    RecyclerView recyclerView;
    private String sessionId;


    @Override
    protected void inidata(Bundle savedInstanceState) {

        Bundle arguments = getArguments();
        sessionId = arguments.getString("sessionId");

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

        myShouye_remne_adapter.setToJijiangCall(new MyShouye_jijiang_Adapter.ToJijiangCall() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), Shouye_XQ.class);
                int movieId = remenBean.getResult().get(position).getMovieId();

                String s = String.valueOf(movieId);
                intent.putExtra("movieId",s);
                Log.e("aaa","即将movieId"+movieId);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);
            }
        });
    }
}
