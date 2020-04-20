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
import adapter.ShouyeAdapter.My_Paiqi_Adapter;
import adapter.YingAdapter.My_Ying_PaiqiAdapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.Ying.Ying_PaiqiBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class Paiqi_five extends BaseFragment {
    RecyclerView recyclerView;
    private String name;

    List<String> list=new ArrayList<>();
    private Gson gson;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String id = arguments.getString("id");
        Integer yid = Integer.valueOf(id);
        Log.e("aaa","day5"+yid);

        Map<String,Object> map=new HashMap<>();
        map.put("cinemaId",yid);
        map.put("page",1);
        map.put("count",10);

        NetUtil.getInstance().Net_Ying_Paiqi(MyUrl.BASE_YING_PAIQI, Ying_PaiqiBean.class, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                gson = new Gson();
                Ying_PaiqiBean ying_paiqiBean = gson.fromJson(stra, Ying_PaiqiBean.class);

                My_Paiqi_Adapter my_ying_paiqiAdapter = new My_Paiqi_Adapter(ying_paiqiBean.getResult(), getActivity());
                recyclerView.setAdapter(my_ying_paiqiAdapter);
                Log.e("aaa","排期数据5"+ying_paiqiBean.getResult());

                my_ying_paiqiAdapter.setPaiqiCall(new My_Paiqi_Adapter.PaiqiCall() {
                    @Override
                    public void onclick(int position) {name = ying_paiqiBean.getResult().get(position).getName();
                        Intent intent = new Intent(getActivity(), Select_Seat.class);
                        intent.putExtra("name",name);
                        startActivity(intent);
                    }
                });
            }
        });
    }

    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.Recyc_Ying_Paiqi5);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_paiqi_five;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }
}
