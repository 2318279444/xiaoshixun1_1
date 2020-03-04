package com.bawei.weiduyingyuan.yingyuan.YingXiangqingFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bawei.weiduyingyuan.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import base.BaseFragment;
import base.BasePresenter;
import bean.Ying.XQLeftBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;

public class MovieXQFragment extends BaseFragment implements Icontract.ToCall {
    RecyclerView recyclerView;
    TextView adress,phone,style;
    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        Object yid = arguments.get("yid");
        Log.e("aaa","XQPJ:"+yid);

        Object sessionId = arguments.get("sessionId");
        Log.e("aaa","XQleft"+sessionId);

        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",13752);

        Map<String,Object> map1=new HashMap<>();
        map1.put("cinemaId",yid);

        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pXqLeft(MyUrl.BASEYING_XQ_LEFT, XQLeftBean.class,map,map1);



    }

    @Override
    protected void iniview(View view) {
//        recyclerView=getActivity().findViewById(R.id.recycXqLeft);
//        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
//        manager.setOrientation(RecyclerView.VERTICAL);
//        recyclerView.setLayoutManager(manager);


        adress=getActivity().findViewById(R.id.XQaddress);
        phone=getActivity().findViewById(R.id.XQphone);
        style=getActivity().findViewById(R.id.XQstyle);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_movie_xqfragment;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        XQLeftBean xqLeftBean = gson.fromJson(stra, XQLeftBean.class);
        Log.e("aaa",""+xqLeftBean.getResult().getAddress());

        adress.setText(xqLeftBean.getResult().getAddress());
        phone.setText(xqLeftBean.getResult().getPhone()+"");
        style.setText(xqLeftBean.getResult().getVehicleRoute());
        Log.e("aaa","xqadapter:"+xqLeftBean.getResult());

//        MyMovieXQLeftAdapter myMovieXQLeftAdapter = new MyMovieXQLeftAdapter( xqLeftBean.getResult(), getActivity());
//        recyclerView.setAdapter(myMovieXQLeftAdapter);
    }
}
