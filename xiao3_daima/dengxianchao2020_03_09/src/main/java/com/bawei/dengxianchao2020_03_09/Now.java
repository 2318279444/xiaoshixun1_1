package com.bawei.dengxianchao2020_03_09;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.dengxianchao2020_03_09.database.MyMoviesjDao;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.MyNowAdapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.NowMovieBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class Now extends BaseFragment implements Icontract.ToCall {
    RecyclerView recyclerView;

    List<NowMovieBean.ResultBean> list=new ArrayList<>();
    SmartRefreshLayout smartRefreshLayout;
    private MyMoviesjDao myMoviesjDao;
    //    private MovieDaoDao movieDaoDao;

    @Override
    protected void inidata(Bundle savedInstanceState) {
//        movieDaoDao = MyApp.getMovie().getMovieDaoDao();

        myMoviesjDao = MyApp.getMovie2().getMyMoviesjDao();



        //传入参数的页数和个数
        Map<String,Object> map=new HashMap<>();
        map.put("page",1);
        map.put("count",20);



        boolean connetion = NetUtil.getInstance().getConnetion(getActivity());
        if(connetion){
            MyPresenter myPresenter= (MyPresenter) p;
            myPresenter.pNow(MyUrl.BASE_NOW, NowMovieBean.class,map);
        }else {



            Gson gson = new Gson();
            NowMovieBean nowMovieBean = gson.fromJson(myMoviesjDao.loadAll().get(0).getUrl(), NowMovieBean.class);
            MyNowAdapter myNowAdapter = new MyNowAdapter(nowMovieBean.getResult(), getActivity());
            recyclerView.setAdapter(myNowAdapter);


            Toast.makeText(getActivity(), "没有网络", Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    protected void iniview(View view) {
        //recyclerview获取控件,排列方式
        recyclerView=getActivity().findViewById(R.id.recyc1);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_now;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        //解析展示数据
        Gson gson = new Gson();
        NowMovieBean nowMovieBean = gson.fromJson(stra, NowMovieBean.class);
        MyNowAdapter myNowAdapter = new MyNowAdapter(nowMovieBean.getResult(), getActivity());
        recyclerView.setAdapter(myNowAdapter);


        MyMoviesj myMoviesj = new MyMoviesj(stra);

        myMoviesjDao.insert(myMoviesj);




    }
}
