package com.bw.movie.shouye_fragment.shouye_jsyp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import adapter.YingAdapter.MyMoviePLRightAdapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.Ying.PLRightBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class Shouye_MX_YingPin extends BaseFragment implements Icontract.ToCall {

    RecyclerView recyclerView;
    private String movieId;
    private String sessionId;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        movieId = arguments.getString("movieId");
        sessionId = arguments.getString("sessionId");
        Log.e("aaa","首页影评id:"+movieId);


        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",13752);

        Map<String,Object> map1=new HashMap<>();
        map1.put("cinemaId",movieId);
        map1.put("page",1);
        map1.put("count",10);

//        MyPresenter myPresenter= (MyPresenter) p;
//        myPresenter.pPLRight(MyUrl.BASEYING_PL_RIGHT, PLRightBean.class,map,map1);


        NetUtil.getInstance().NetPLRight(MyUrl.BASEYING_PL_RIGHT, PLRightBean.class, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                PLRightBean plRightBean = gson.fromJson(stra, PLRightBean.class);
                MyMoviePLRightAdapter myMoviePLRightAdapter = new MyMoviePLRightAdapter(plRightBean.getResult(), getActivity());
                recyclerView.setAdapter(myMoviePLRightAdapter);
            }
        });


    }

    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.recyc_Shouye_Yingopin);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shouye__mx__ying_pin;

    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {

    }
}
