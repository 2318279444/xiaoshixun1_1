package com.bw.zhoumozuoye_2020_03_07.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.zhoumozuoye_2020_03_07.R;
import com.google.gson.Gson;

import adapter.MyAdapter;
import adapter.MyAdapter2;
import base.BaseFragment;
import base.BasePresenter;
import bean.MovieBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class Movie extends BaseFragment {
    RecyclerView recyclerView1,recyclerView2;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        NetUtil.getInstance().NetMovie(MyUrl.BASEMOVIE, MovieBean.class, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                final Gson gson = new Gson();
                final MovieBean movieBean = gson.fromJson(stra, MovieBean.class);
                final MyAdapter myAdapter = new MyAdapter(movieBean.getCategory(), getActivity());
                recyclerView1.setAdapter(myAdapter);

                myAdapter.setCallBack(new MyAdapter.CallBack() {
                    @Override
                    public void onClick(final int position) {
                        myAdapter.setColor(position);

                        NetUtil.getInstance().NetMovie(MyUrl.BASEMOVIE, MovieBean.class, new Icontract.ToCall() {
                            @Override
                            public void success(String stra) {
                                final MovieBean movieBean1 = gson.fromJson(stra, MovieBean.class);
                                final MyAdapter2 myAdapter2 = new MyAdapter2(movieBean1.getCategory().get(position).getChilds(), getActivity());
                                recyclerView2.setAdapter(myAdapter2);

                                myAdapter2.setCallBack2(new MyAdapter2.CallBack2() {
                                    @Override
                                    public void onClick(int position) {
                                        myAdapter2.setColor2(position);
                                        Toast.makeText(getActivity(), movieBean1.getCategory().get(position).getTitle(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });

                    }
                });



            }
        });

//        NetUtil.getInstance().NetMovie(MyUrl.BASEMOVIE, Movie.class, new Icontract.ToCall() {
//            @Override
//            public void success(String stra) {
//
//            }
//        });
    }

    @Override
    protected void iniview(View view) {
        recyclerView1=getActivity().findViewById(R.id.recyc1);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView1.setLayoutManager(manager);

        recyclerView2=getActivity().findViewById(R.id.recyc2);
        LinearLayoutManager manager2=new LinearLayoutManager(getActivity());
        manager2.setOrientation(RecyclerView.VERTICAL);
        recyclerView2.setLayoutManager(manager2);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_movie;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }




}
