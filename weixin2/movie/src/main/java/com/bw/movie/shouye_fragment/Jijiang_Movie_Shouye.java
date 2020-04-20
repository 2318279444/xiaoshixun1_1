
package com.bw.movie.shouye_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.ShouyeAdapter.MyShouye_jijiang2_Adapter;
import adapter.ShouyeAdapter.MyShouye_jijiang_Adapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.shouye.JijiangBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;

public class Jijiang_Movie_Shouye extends BaseFragment implements Icontract.ToCall {
    RecyclerView recyclerView;

    ImageView imageView_yuyue;
    TextView name,time,number;
    List<JijiangBean.ResultBean> list=new ArrayList<>();

    private String sessionId;

    boolean flag=false;




    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        sessionId = arguments.getString("sessionId");
        Log.e("aaa","即将电影:"+sessionId);

        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",13752);



        Map<String,Object> map1=new HashMap<>();
        map1.put("page",1);
        map1.put("count",22);

        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pJijiangMovie(MyUrl.BASE_Jijiang_Movie, JijiangBean.class,map,map1);







    }

    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.recyc_Shouye_jijiang);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

//        imageView_yuyue=getActivity().findViewById(R.id.jijiang_yuyue);

//        imageView=getActivity().findViewById(R.id.Shouye_jijiang_ima);
//        name=getActivity().findViewById(R.id.Shouye_jijiang_moviename);
//        time=getActivity().findViewById(R.id.Shouye_jijiang_ritime);
//        number=getActivity().findViewById(R.id.Shouye_jijiang_personnumber);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_jijiang__movie__shouye;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        JijiangBean jijiangBean = gson.fromJson(stra, JijiangBean.class);

        list.addAll(jijiangBean.getResult());
        Log.e("aaa","首页即将展示result"+jijiangBean.getResult().get(0).getName());

//        for (int i = 0; i < list.size(); i++) {
//            Glide.with(getActivity()).load(jijiangBean.getResult().get(i).getImageUrl()).into(imageView);
//            name.setText(list.get(i).getName());
//
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");
//            String format = simpleDateFormat.format(list.get(i).getReleaseTime());
//            time.setText(format+"");
//
//
//            number.setText(list.get(i).getWantSeeNum()+"");
//        }


        MyShouye_jijiang2_Adapter myShouye_jijiang2_adapter = new MyShouye_jijiang2_Adapter(jijiangBean.getResult(), getActivity());
        recyclerView.setAdapter(myShouye_jijiang2_adapter);

        myShouye_jijiang2_adapter.setToJijiangCall(new MyShouye_jijiang2_Adapter.ToJijiangCall() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), Shouye_XQ.class);
                int movieId = jijiangBean.getResult().get(position).getMovieId();

                String s = String.valueOf(movieId);
                intent.putExtra("movieId",s);
                Log.e("aaa","即将movieId"+movieId);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);
            }


        });





    }
}
