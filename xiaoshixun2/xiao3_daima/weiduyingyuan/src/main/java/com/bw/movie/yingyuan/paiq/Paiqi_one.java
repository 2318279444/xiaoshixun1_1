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

import adapter.ShouyeAdapter.MyShouye_jijiang_Adapter;
import adapter.YingAdapter.My_Ying_PaiqiAdapter;
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

    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String id = arguments.getString("id");
        Integer yid = Integer.valueOf(id);
        Log.e("aaa","day1"+yid);


        Map<String,Object> map=new HashMap<>();
        map.put("cinemaId",yid);
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
        Gson gson = new Gson();
        Ying_PaiqiBean ying_paiqiBean = gson.fromJson(stra, Ying_PaiqiBean.class);
        for (int i = 0; i < ying_paiqiBean.getResult().size(); i++) {
            name = ying_paiqiBean.getResult().get(i).getName();
            list.add(name);
        }
        My_Ying_PaiqiAdapter my_ying_paiqiAdapter = new My_Ying_PaiqiAdapter(ying_paiqiBean.getResult(), getActivity());
        recyclerView.setAdapter(my_ying_paiqiAdapter);

        my_ying_paiqiAdapter.setToJijiangCall(new MyShouye_jijiang_Adapter.ToJijiangCall() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), Select_Seat.class);
                intent.putExtra("name",list.get(position));
                startActivity(intent);
            }
        });

    }
}
