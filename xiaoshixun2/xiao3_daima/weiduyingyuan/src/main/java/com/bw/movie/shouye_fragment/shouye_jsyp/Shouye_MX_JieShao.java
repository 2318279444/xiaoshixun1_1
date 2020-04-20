package com.bw.movie.shouye_fragment.shouye_jsyp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.ShouyeAdapter.My_mx_Yanyuan_Adapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.shouye.Shouye_Movie_XQBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class Shouye_MX_JieShao extends BaseFragment implements Icontract.ToCall {
    RecyclerView recyclerView,recyclerView2;
    private String movie;
    private String sessionId;
    private Integer movieId;
    ImageView imageView;
    TextView jieshao,name;
    List<Shouye_Movie_XQBean.ResultBean> list=new ArrayList<>();




    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        movie = arguments.getString("movieId");
        movieId = Integer.valueOf(movie);

        Log.e("aaa","明细"+ this.movieId);
        sessionId = arguments.getString("sessionId");



        Map<String,Object> map=new HashMap<>();
        map.put("userId",13752);
        map.put("sessionId", sessionId);


        Map<String,Object> map1=new HashMap<>();
        map1.put("movieId", this.movieId);
        Log.e("aaa","首页电影详情movieId"+ this.movieId);




        NetUtil.getInstance().Net_Shouye_Movie_XQ(MyUrl.BASE_Shouye_Movie_XQ, Shouye_Movie_XQBean.class, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                Shouye_Movie_XQBean shouye_movie_xqBean = gson.fromJson(stra, Shouye_Movie_XQBean.class);
                Log.e("aaa","剧情介绍"+shouye_movie_xqBean.getResult().getSummary());

                 Glide.with(getActivity()).load(shouye_movie_xqBean.getResult().getMovieDirector().get(0).getPhoto()).into(imageView);
                jieshao.setText(shouye_movie_xqBean.getResult().getSummary());
                 name.setText(shouye_movie_xqBean.getResult().getMovieDirector().get(0).getName());


                Shouye_Movie_XQBean shouye_movie_xqBean1 = gson.fromJson(stra, Shouye_Movie_XQBean.class);
                My_mx_Yanyuan_Adapter my_mx_yanyuan_adapter = new My_mx_Yanyuan_Adapter(shouye_movie_xqBean1.getResult().getMovieActor(), getActivity());
                recyclerView2.setAdapter(my_mx_yanyuan_adapter);

            }
        });


    }

    @Override
    protected void iniview(View view) {
        recyclerView2=getActivity().findViewById(R.id.recyc_mx_yanyuan);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView2.setLayoutManager(manager);

        imageView=getActivity().findViewById(R.id.mx_ima);
        jieshao=getActivity().findViewById(R.id.mx_jieshao);
        name=getActivity().findViewById(R.id.mx_dyname);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shouye__mx__jie_shao;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {


    }
}
