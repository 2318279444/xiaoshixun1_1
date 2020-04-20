package com.bw.movie.shouye_fragment.shouye_jsyp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.ShouyeAdapter.My_Mx_Juzhao_Adapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.shouye.Shouye_JuzhaoBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class Shouye_Mx_Juzhao extends BaseFragment implements Icontract.ToCall {


    private String movie;
    private Integer movieId;
    private String sessionId;

    List<String> list=new ArrayList<>();

    ImageView ima1,ima2,ima3,ima4,ima5,ima6;

    RecyclerView recyclerView;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        movie = arguments.getString("movieId");
        movieId = Integer.valueOf(movie);

        Log.e("aaa","首页剧照"+ this.movieId);
        sessionId = arguments.getString("sessionId");

        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",13752);

        Map<String,Object> map1=new HashMap<>();
        map1.put("movieId",movieId);

        NetUtil.getInstance().Net_Juzhao(MyUrl.BASE_JUZHAO, Shouye_JuzhaoBean.class, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                Shouye_JuzhaoBean shouye_juzhaoBean = gson.fromJson(stra, Shouye_JuzhaoBean.class);


//        for (int i = 0; i < shouye_juzhaoBean.getResult().getPosterList().size(); i++) {
//            List<String> posterList = shouye_juzhaoBean.getResult().getPosterList();
//            list.add(posterList.get(i));
//            imageView.se
//        }
                list.addAll(shouye_juzhaoBean.getResult().getPosterList());
                Log.e("aaa","剧照"+list);
                for (int i = 0; i <list.size() ; i++) {

                }

                Glide.with(getActivity()).load(list.get(0)).into(ima1);
                Glide.with(getActivity()).load(list.get(1)).into(ima2);
                Glide.with(getActivity()).load(list.get(2)).into(ima3);
                Glide.with(getActivity()).load(list.get(3)).into(ima4);
                Glide.with(getActivity()).load(list.get(4)).into(ima5);
                Glide.with(getActivity()).load(list.get(5)).into(ima6);
            }
        });


    }

    @Override
    protected void iniview(View view) {
            ima1=getActivity().findViewById(R.id.shouye_juzhaoima1);
            ima2=getActivity().findViewById(R.id.shouye_juzhaoima2);
            ima3=getActivity().findViewById(R.id.shouye_juzhaoima3);
            ima4=getActivity().findViewById(R.id.shouye_juzhaoima4);
            ima5=getActivity().findViewById(R.id.shouye_juzhaoima5);
            ima6=getActivity().findViewById(R.id.shouye_juzhaoima6);

//        recyclerView=getActivity().findViewById(R.id.Shouye_juzhao_recyc);
//        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
//
//        recyclerView.setLayoutManager(manager);


    }


    @Override
    protected int inilayout() {
        return R.layout.activity_shouye__mx__juzhao;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }

    @Override
    public void success(String stra) {

    }
}
