package com.bw.dengxianchao2020_03_09;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.dengxianchao2020_03_09.database.MyMoviesjDao;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.Map;

import adapter.MyHotAdapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.HotMovieBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class Hot extends BaseFragment implements Icontract.ToCall {

    RecyclerView recyclerView;
    SmartRefreshLayout smartRefreshLayout;
    private MyMoviesjDao myMoviesjDao;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        myMoviesjDao = MyApp.getMovie2().getMyMoviesjDao();


        //传入参数展示页数和个数
        Map<String,Object> map=new HashMap<>();
        map.put("page",1);
        map.put("count",20);

        boolean connetion = NetUtil.getInstance().getConnetion(getActivity());
        if(connetion){
            MyPresenter myPresenter= (MyPresenter) p;
            myPresenter.pHot(MyUrl.BASE_HOT, HotMovieBean.class,map);
        }else {

            Gson gson = new Gson();
            HotMovieBean hotMovieBean = gson.fromJson(myMoviesjDao.loadAll().get(0).getUrl(), HotMovieBean.class);
            MyHotAdapter myHotAdapter = new MyHotAdapter(hotMovieBean.getResult(), getActivity());
            recyclerView.setAdapter(myHotAdapter);
            Toast.makeText(getActivity(), "无网络", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void iniview(View view) {
        //获取控件id
        recyclerView=getActivity().findViewById(R.id.recyc2);
        //排列方式
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        //使用recyclerview展示
        recyclerView.setLayoutManager(manager);
    }


    @Override
    protected int inilayout() {
        return R.layout.activity_hot;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        HotMovieBean hotMovieBean = gson.fromJson(stra, HotMovieBean.class);
        MyHotAdapter myHotAdapter = new MyHotAdapter(hotMovieBean.getResult(), getActivity());
        recyclerView.setAdapter(myHotAdapter);

        MyMoviesj myMoviesj = new MyMoviesj(stra);
        myMoviesjDao.insert(myMoviesj);
    }
}
