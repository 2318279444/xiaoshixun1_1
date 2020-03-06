package com.bawei.weiduyingyuan.shouye_fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.weiduyingyuan.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import adapter.ShouyeAdapter.MyShouyeAdapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.shouye.ShouyeBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class Now_Movie_Shouye extends BaseFragment {

    RecyclerView recyclerView;


    @Override
    protected void inidata(Bundle savedInstanceState) {

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
