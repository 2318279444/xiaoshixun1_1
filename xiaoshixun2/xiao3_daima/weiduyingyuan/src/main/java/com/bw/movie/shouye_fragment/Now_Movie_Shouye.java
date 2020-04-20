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

import adapter.ShouyeAdapter.MyShouyeAdapter;
import adapter.ShouyeAdapter.MyShouye_jijiang_Adapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.shouye.ShouyeBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class Now_Movie_Shouye extends BaseFragment {

    RecyclerView recyclerView;
    private String sessionId;


    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        sessionId = arguments.getString("sessionId");


        //正在上映
        ininow();

    }





    private void ininow() {
        Map<String,Object> map=new HashMap<>();
        map.put("page",1);
        map.put("count",21);

        NetUtil.getInstance().Net_Shouye_Movie(MyUrl.BASE_ZhengZai_Shangying, ShouyeBean.class, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                ShouyeBean shouyeBean = gson.fromJson(stra, ShouyeBean.class);
                MyShouyeAdapter myShouyeAdapter = new MyShouyeAdapter(shouyeBean.getResult(), getActivity());
                recyclerView.setAdapter(myShouyeAdapter);

                myShouyeAdapter.setToJijiangCall(new MyShouye_jijiang_Adapter.ToJijiangCall() {
                    @Override
                    public void onClick(int position) {
                        Intent intent = new Intent(getActivity(), Shouye_XQ.class);
                        int movieId = shouyeBean.getResult().get(position).getMovieId();

                        String s = String.valueOf(movieId);
                        intent.putExtra("movieId",s);
                        Log.e("aaa","即将movieId"+movieId);
                        intent.putExtra("sessionId",sessionId);
                        startActivity(intent);
                    }
                });
            }
        });
    }

    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.recyc_Shouye_Now);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_now__movie__shouye;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }
}
