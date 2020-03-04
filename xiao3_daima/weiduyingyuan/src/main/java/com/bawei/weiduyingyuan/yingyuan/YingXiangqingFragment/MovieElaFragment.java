package com.bawei.weiduyingyuan.yingyuan.YingXiangqingFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.weiduyingyuan.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.YingAdapter.MyMoviePLRightAdapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.Ying.PLRightBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;

public class MovieElaFragment extends BaseFragment implements Icontract.ToCall {
    RecyclerView recyclerView;
    ImageView imageView;
    TextView time,name,shu,pl;

    List<PLRightBean.ResultBean> list=new ArrayList<>();

    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        Object yid = arguments.get("yid");
        Log.e("aaa","plplplp:"+yid);

        Object sessionId = arguments.get("sessionId");
        Log.e("aaa","plplplplplp2"+sessionId);

        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",13752);

        Map<String,Object> map1=new HashMap<>();
        map1.put("cinemaId",yid);
        map1.put("page",1);
        map1.put("count",10);

        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pPLRight(MyUrl.BASEYING_PL_RIGHT, PLRightBean.class,map,map1);

//        NetUtil.getInstance().NetPLRight(MyUrl.BASEYING_PL_RIGHT, PLRightBean.class, map, map1, new Icontract.ToCall() {
//            @Override
//            public void success(String stra) {
//                Gson gson = new Gson();
//                PLRightBean plRightBean = gson.fromJson(stra, PLRightBean.class);
//                MyMoviePLRightAdapter myMoviePLRightAdapter = new MyMoviePLRightAdapter(plRightBean.getResult(), getActivity());
//                recyclerView.setAdapter(myMoviePLRightAdapter);
//            }
//        });


    }

    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.recyc_pl);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);


//        imageView=getActivity().findViewById(R.id.pl_right_ima);
//        time=getActivity().findViewById(R.id.pl_right_time);
//        name=getActivity().findViewById(R.id.pl_right_name);
//        shu=getActivity().findViewById(R.id.pl_right_shuliang);
//        pl=getActivity().findViewById(R.id.pl_right_pl);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_movie_ela_fragment;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        PLRightBean plRightBean = gson.fromJson(stra, PLRightBean.class);
        list.addAll(plRightBean.getResult());
        MyMoviePLRightAdapter myMoviePLRightAdapter = new MyMoviePLRightAdapter(plRightBean.getResult(), getActivity());
        recyclerView.setAdapter(myMoviePLRightAdapter);
        Log.e("aaa",""+plRightBean.getResult().get(0).getCommentTime());

//        for (int i = 0; i < list.size(); i++) {
//            Log.e("aaa","li.size:"+list.size());
//            Glide.with(getActivity()).load(list.get(i).getCommentHeadPic())
//                    .error(R.drawable.ic_launcher_background)
//                    .placeholder(R.drawable.ic_launcher_background)
//                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
//                    .into(imageView);
//
//            name.setText(list.get(i).getCommentUserName());
//            Log.e("aaa","pladapter"+list.get(i).getCommentHeadPic());
//
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM_dd HH:mm");
//            String format = simpleDateFormat.format(list.get(i).getCommentTime());
//            time.setText(format+"");
//
//            pl.setText(list.get(i).getCommentContent());
//
//            shu.setText(list.get(i).getGreatNum()+"");
//        }


    }
}





