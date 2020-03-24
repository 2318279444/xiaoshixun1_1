package com.bawei.weiduyingyuan.shouye_fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.weiduyingyuan.R;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import base.BaseActivity;
import bean.shouye.Shouye_Movie_XQBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class Shouye_XQ extends BaseActivity {
//    RecyclerView recyclerView;
    private String sessionId;
    private String movieId;

    ImageView imageView;
    TextView name,time,sy,xq;
    List<String> list=new ArrayList<>();
    private Integer movieidsss;

    Button redeyp,group;
    private String namemovie;
    ImageView imageViewsc;

    @Override
    protected void inidata() {

        //关注电影
        iniima();


        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Shouye_XQ.this, ShouYe_Goupiao.class);
//                intent.putExtra("namemovie",namemovie);
//                intent.putExtra("movieId",movieId);
//                intent.putExtra("sessionId",sessionId);
//                startActivity(intent);
            }
        });



        Intent intent = getIntent();
        movieId = intent.getStringExtra("movieId");
        movieidsss = Integer.valueOf(movieId);
        sessionId = intent.getStringExtra("sessionId");

        Log.e("aaa","XQ数据:"+movieId+","+sessionId);


        xq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Shouye_XQ.this, Shouye_Mx.class);
                intent1.putExtra("movieId",movieId);
                intent1.putExtra("sessionId",sessionId);
                startActivity(intent1);
            }
        });


        Map<String,Object> map=new HashMap<>();
        map.put("userId",13752);
        map.put("sessionId", sessionId);


        Map<String,Object> map1=new HashMap<>();
        map1.put("movieId", movieidsss);
        Log.e("aaa","首页电影详情movieId"+movieId);

        NetUtil.getInstance().Net_Shouye_Movie_XQ(MyUrl.BASE_Shouye_Movie_XQ, Shouye_Movie_XQBean.class, map, map1, new Icontract.ToCall() {

            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                Shouye_Movie_XQBean shouye_movie_xqBean = gson.fromJson(stra, Shouye_Movie_XQBean.class);



                Glide.with(Shouye_XQ.this).load(shouye_movie_xqBean.getResult().getImageUrl()).into(imageView);
                namemovie = shouye_movie_xqBean.getResult().getName();
                name.setText(namemovie);

                time.setText(shouye_movie_xqBean.getResult().getDuration());

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd");
                String format = simpleDateFormat.format(shouye_movie_xqBean.getResult().getReleaseTime());
                sy.setText(format+"");
            }
        });






    }

    private void iniima() {
        imageViewsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageViewsc.setImageResource(R.drawable.sc);
            }
        });
    }

    @Override
    protected void iniview() {
        imageViewsc=findViewById(R.id.Shouye_XQ_sc);

//        recyclerView=findViewById(R.id.recyc_Shouye_Movie_XQ);
//        LinearLayoutManager manager=new LinearLayoutManager(this);
//        manager.setOrientation(RecyclerView.VERTICAL);
//        recyclerView.setLayoutManager(manager);
        imageView=findViewById(R.id.Shouye_XQ_ima);
        name=findViewById(R.id.Shouye_XQ_name);
        time=findViewById(R.id.Shouye_XQ_time);
        sy=findViewById(R.id.Shouye_XQ_sy);
        xq=findViewById(R.id.Shouye_Movie_XQ_MX);


        redeyp=findViewById(R.id.Shouye_XQ_readepj);
        group=findViewById(R.id.Shouye_XQ_group);


    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shouye__xq;
    }
}
