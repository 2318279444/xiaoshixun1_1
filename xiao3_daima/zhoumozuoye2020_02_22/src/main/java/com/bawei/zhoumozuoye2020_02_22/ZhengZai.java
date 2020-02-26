package com.bawei.zhoumozuoye2020_02_22;

import androidx.appcompat.app.AppCompatActivity;
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

public class ZhengZai extends BaseFragment implements Icontract.ToCall {
    RecyclerView recyclerView;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pZhengzai(MyUrl.BASEZHENGZAI, ZhengzaiBean.class);
    }

    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.recyc1);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_zheng_zai;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        ZhengzaiBean zhengzaiBean = gson.fromJson(stra, ZhengzaiBean.class);
        MyZhengzaiAdapter myZhengzaiAdapter = new MyZhengzaiAdapter(zhengzaiBean.getSubjects(), getActivity());
        recyclerView.setAdapter(myZhengzaiAdapter);
    }
}
