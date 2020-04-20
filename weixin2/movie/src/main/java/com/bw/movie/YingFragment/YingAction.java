package com.bw.movie.YingFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.yingyuan.YingTuiJianXiangqing;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.YingAdapter.MyLocationAdapter;
import adapter.YingAdapter.MyLocationRightAdapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.Ying.Location_RightBean;
import bean.Ying.Location_leftBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class YingAction extends BaseFragment implements Icontract.ToCall {
    RecyclerView recyclerViewleft,recyclerViewright;
    private String sessionId;
    private Location_RightBean location_rightBean;
    private String name;
    private String address;
    private int id;
    private MyLocationRightAdapter myLocationRightAdapter;
    private Map<String, Object> map;
    List<Integer> list=new ArrayList<>();
    private int regionId;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        sessionId = arguments.getString("sessionId");
        Log.e("aaa","yingaction:sessionId:"+ sessionId);


        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.p_Location_Left(MyUrl.BASE_Location_left, Location_leftBean.class);


    }

    @Override
    protected void iniview(View view) {
        recyclerViewleft=getActivity().findViewById(R.id.recyc_location_left);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewleft.setLayoutManager(manager);

        recyclerViewright=getActivity().findViewById(R.id.recyc_location_right);
        LinearLayoutManager manager1=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewright.setLayoutManager(manager1);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_ying_action;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        Location_leftBean location_leftBean = gson.fromJson(stra, Location_leftBean.class);
        MyLocationAdapter myLocationAdapter = new MyLocationAdapter(location_leftBean.getResult(), getActivity());
        recyclerViewleft.setAdapter(myLocationAdapter);


        regionId = location_leftBean.getResult().get(0).getRegionId();

        map = new HashMap<>();
        map.put("regionId",regionId);
        NetUtil.getInstance().NetLocation_Right(MyUrl.BASE_Location_Right, Location_RightBean.class, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                location_rightBean = gson.fromJson(stra, Location_RightBean.class);
                myLocationRightAdapter = new MyLocationRightAdapter(location_rightBean.getResult(), getActivity());
                recyclerViewright.setAdapter(myLocationRightAdapter);
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
                        Log.e("aaa","LocationysessionId"+sessionId);
                        Log.e("aaa","Locationname"+ name);
                        Log.e("aaa","Locationaddress"+ address);
                        startActivity(intent);



                    }
                });
            }
        });

//        for (int i = 0; i < location_leftBean.getResult().size(); i++) {
//            regionId = location_leftBean.getResult().get(i).getRegionId();
//            list.add(regionId);
//            map = new HashMap<>();
//            map.put("regionId",list.get(i));
//        }
//
//
//
//        Log.e("aaa","Location_Left"+regionId);
//        recyclerViewright.setAdapter(myLocationRightAdapter);


        myLocationAdapter.setLocationCallBack(new MyLocationAdapter.LocationCallBack() {
            @Override
            public void onclick(int position) {
                myLocationAdapter.setColor(position);
                regionId = location_leftBean.getResult().get(position).getRegionId();

                map = new HashMap<>();
                map.put("regionId",regionId);
                NetUtil.getInstance().NetLocation_Right(MyUrl.BASE_Location_Right, Location_RightBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        location_rightBean = gson.fromJson(stra, Location_RightBean.class);
                        myLocationRightAdapter = new MyLocationRightAdapter(location_rightBean.getResult(), getActivity());
                        recyclerViewright.setAdapter(myLocationRightAdapter);
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
                                Log.e("aaa","LocationysessionId"+sessionId);
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
}
