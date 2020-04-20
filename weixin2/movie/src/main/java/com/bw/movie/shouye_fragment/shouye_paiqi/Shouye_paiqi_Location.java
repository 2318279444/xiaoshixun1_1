package com.bw.movie.shouye_fragment.shouye_paiqi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.yingyuan.YingTuiJianXiangqing;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import adapter.YingAdapter.MyLocationAdapter;
import adapter.YingAdapter.MyLocationRightAdapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.Ying.Location_RightBean;
import bean.Ying.Location_leftBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class Shouye_paiqi_Location extends BaseFragment {
    RecyclerView recyclerView1,recyclerView2;
    private Location_RightBean location_rightBean;
    private MyLocationRightAdapter myLocationRightAdapter;
    private int id;
    private String address;
    private String name;
    private String movieId;
    private String sessionId;
    private int regionId;


    @Override
    protected void inidata(Bundle savedInstanceState) {


        Bundle arguments = getArguments();
        movieId = arguments.getString("movieId");
        sessionId = arguments.getString("sessionId");


        NetUtil.getInstance().Net_Location_Left(MyUrl.BASE_Location_left, Location_leftBean.class, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                Location_leftBean location_leftBean = gson.fromJson(stra, Location_leftBean.class);
                MyLocationAdapter myLocationAdapter = new MyLocationAdapter(location_leftBean.getResult(), getActivity());
                recyclerView1.setAdapter(myLocationAdapter);

                regionId = location_leftBean.getResult().get(0).getRegionId();

                Map<String,Object> map = new HashMap<>();
                map.put("regionId",regionId);
                NetUtil.getInstance().NetLocation_Right(MyUrl.BASE_Location_Right, Location_RightBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        location_rightBean = gson.fromJson(stra, Location_RightBean.class);
                        myLocationRightAdapter = new MyLocationRightAdapter(location_rightBean.getResult(), getActivity());
                        recyclerView2.setAdapter(myLocationRightAdapter);
                        myLocationRightAdapter.setLocation_rightCallBack(new MyLocationRightAdapter.Location_RightCallBack() {
                            @Override
                            public void onClick(int position) {
                                name = location_rightBean.getResult().get(position).getName();
                                address = location_rightBean.getResult().get(position).getName();
                                id = location_rightBean.getResult().get(position).getId();
                                String yid = String.valueOf(id);

                                Log.e("aaa","Location id:"+ yid);
                                Intent intent = new Intent(getActivity(), YingTuiJianXiangqing.class);
                                intent.putExtra("name", name);
                                intent.putExtra("address", address);
                                intent.putExtra("yid", yid);
                                intent.putExtra("sessionId",sessionId);
                                Log.e("aaa","Locationyid:yid"+ yid);
                                Log.e("aaa","影院选择详情sessionId:"+sessionId);
                                Log.e("aaa","Locationname"+ name);
                                Log.e("aaa","Locationaddress"+ address);
                                startActivity(intent);



                            }
                        });
                    }
                });


                myLocationAdapter.setLocationCallBack(new MyLocationAdapter.LocationCallBack() {
                    @Override
                    public void onclick(int position) {
                        myLocationAdapter.setColor(position);
                        regionId = location_leftBean.getResult().get(position).getRegionId();

                        Map<String,Object> map=new HashMap<>();
                        map.put("regionId", regionId);
                        Log.e("aaa","Location_Left"+ regionId);

                        NetUtil.getInstance().NetLocation_Right(MyUrl.BASE_Location_Right, Location_RightBean.class, map, new Icontract.ToCall() {
                            @Override
                            public void success(String stra) {
                                location_rightBean = gson.fromJson(stra, Location_RightBean.class);
                                myLocationRightAdapter = new MyLocationRightAdapter(location_rightBean.getResult(), getActivity());
                                recyclerView2.setAdapter(myLocationRightAdapter);

                                myLocationRightAdapter.setLocation_rightCallBack(new MyLocationRightAdapter.Location_RightCallBack() {
                                    @Override
                                    public void onClick(int position) {
                                        name = location_rightBean.getResult().get(position).getName();
                                        address = location_rightBean.getResult().get(position).getName();
                                        id = location_rightBean.getResult().get(position).getId();
                                        String yid = String.valueOf(id);

                                        Log.e("aaa","Location id:"+ yid);
                                        Intent intent = new Intent(getActivity(), YingTuiJianXiangqing.class);
                                        intent.putExtra("name", name);
                                        intent.putExtra("address", address);
                                        intent.putExtra("yid", yid);
                                        intent.putExtra("sessionId", sessionId);
                                        Log.e("aaa","Locationyid:yid"+ yid);
                                        Log.e("aaa","LocationysessionId"+ sessionId);
                                        Log.e("aaa","Locationname"+ name);
                                        Log.e("aaa","Locationaddress"+ address);
                                        startActivity(intent);



                                    }
                                });
                            }
                        });
                    }
                });


            }
        });
    }

    @Override
    protected void iniview(View view) {
        recyclerView1=getActivity().findViewById(R.id.recyc_Shouye_Paiqi_Location111);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView1.setLayoutManager(manager);



        recyclerView2=getActivity().findViewById(R.id.recyc_Shouye_Paiqi_Location222);
        LinearLayoutManager manager1=new LinearLayoutManager(getActivity());
        manager1.setOrientation(RecyclerView.VERTICAL);
        recyclerView2.setLayoutManager(manager1);


    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shouye_paiqi__location;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
