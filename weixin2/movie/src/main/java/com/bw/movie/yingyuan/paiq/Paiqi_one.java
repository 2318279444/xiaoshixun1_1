package com.bw.movie.yingyuan.paiq;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.Select_Seat;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.ShouyeAdapter.My_Paiqi_Adapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.Ying.Ying_PaiqiBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;

public class Paiqi_one extends BaseFragment implements Icontract.ToCall {
    RecyclerView recyclerView;
    private String name;
    List<String> list=new ArrayList<>();
    private Gson gson;
    private Ying_PaiqiBean ying_paiqiBean;
    private Integer yid;
    private String id;
    private String sessionId;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        id = arguments.getString("id");
        //影院id
        yid = Integer.valueOf(id);

        sessionId = arguments.getString("sessionId");
        Log.e("aaa","day1"+ yid);
        Log.e("aaa","排期one:sessionId"+sessionId);


        Map<String,Object> map=new HashMap<>();
        map.put("cinemaId", yid);
        map.put("page",1);
        map.put("count",10);

        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pYing_Paiqi(MyUrl.BASE_YING_PAIQI, Ying_PaiqiBean.class,map);


    }

    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.Recyc_Ying_Paiqi);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_paiqi_one;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        gson = new Gson();
        ying_paiqiBean = gson.fromJson(stra, Ying_PaiqiBean.class);
        My_Paiqi_Adapter my_ying_paiqiAdapter = new My_Paiqi_Adapter(ying_paiqiBean.getResult(), getActivity());
        recyclerView.setAdapter(my_ying_paiqiAdapter);
        Log.e("aaa","排期数据1"+ying_paiqiBean.getResult());

        my_ying_paiqiAdapter.setPaiqiCall(new My_Paiqi_Adapter.PaiqiCall() {
            @Override
            public void onclick(int position) {
                name = ying_paiqiBean.getResult().get(position).getName();
                int movieId = ying_paiqiBean.getResult().get(position).getMovieId();
                String smovieId = String.valueOf(movieId);
                Intent intent = new Intent(getActivity(), Select_Seat.class);
                intent.putExtra("name",name);
                intent.putExtra("smovieId",smovieId);
                intent.putExtra("sessionId",sessionId);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

    }
}
