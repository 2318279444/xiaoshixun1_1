package com.bw.zhoumozuoye2020_02_22;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;

import adapter.MyZhengzaiAdapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.ZhengzaiBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class JiJang extends BaseFragment  {
    RecyclerView recyclerView;


    @Override
    protected void inidata(Bundle savedInstanceState) {

        NetUtil.getInstance().NetJi(MyUrl.BASEZHENGZAI, ZhengzaiBean.class, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                ZhengzaiBean zhengzaiBean = gson.fromJson(stra, ZhengzaiBean.class);
                MyZhengzaiAdapter myZhengzaiAdapter = new MyZhengzaiAdapter(zhengzaiBean.getSubjects(), getActivity());
                recyclerView.setAdapter(myZhengzaiAdapter);
            }
        });

    }

    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.recyc2);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_ji_jang;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }


}
