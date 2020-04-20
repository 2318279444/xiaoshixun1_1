package com.bw.movie.shouye_fragment.shouye_jsyp;


import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import base.BaseFragment;
import base.BasePresenter;
import bean.shouye.Shouye_JuzhaoBean;
import contract.Icontract;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import url.MyUrl;
import util.NetUtil;

public class Shouye_Mx_Yugao extends BaseFragment {


    private String movie;
    private Integer movieId;
    private String sessionId;

    RecyclerView recyclerView;

    JCVideoPlayerStandard jc1,jc2,jc3;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        movie = arguments.getString("movieId");
        movieId = Integer.valueOf(movie);

        Log.e("aaa","首页预告"+ this.movieId);
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

                jc1.setUp(shouye_juzhaoBean.getResult().getShortFilmList().get(0).getVideoUrl(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");

                jc2.setUp(shouye_juzhaoBean.getResult().getShortFilmList().get(1).getVideoUrl(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");
                jc3.setUp(shouye_juzhaoBean.getResult().getShortFilmList().get(2).getVideoUrl(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");


            }
        });

    }

    @Override
    protected void iniview(View view) {
        jc1=getActivity().findViewById(R.id.jiecao1);
        jc2=getActivity().findViewById(R.id.jiecao2);
        jc3=getActivity().findViewById(R.id.jiecao3);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shouye__mx__yugao;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }


}
