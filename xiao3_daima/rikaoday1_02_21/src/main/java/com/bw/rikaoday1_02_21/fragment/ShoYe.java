package com.bw.rikaoday1_02_21.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.rikaoday1_02_21.R;
import com.google.gson.Gson;

import adapter.MyShouyeAdapter;
import adapter.MyShouyeAdapter2;
import base.BaseFragment;
import base.BasePresenter;
import bean.ShouyeBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;





/*
*
*
*3、	简述事件分发的流程，在Android Studio中新建txt编写即可（20分）
* 从Activity传到fragment传到LinnerLayout,传到Textview
* 关键词是disTouchEvent,是事件分发   onInterceptTouchEVent是事件拦截,OnTouchEvent
* 时间拦截可以判断是否在本层处理和传到下层
*
*
4、	简述解决事件冲突的思路，在Android Studio中新建txt编写即可（20分）
        首先是disTouchEvent接受到事件,然后向下传递,由onInterceptTouchEVent判断
        *是否在本层处理和传到下一层,如果全程都没有处理,则会由内向外再一次传递,
        事件拦截可以判断是否在本层处理和传到下层
*
*
*
*
* */
public class ShoYe extends BaseFragment {
    RecyclerView recyclerView,recyclerView2;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        iniShouye();
    }



    @Override
    protected void iniview(View view) {
        recyclerView=getActivity().findViewById(R.id.recycrx);
        GridLayoutManager manager=new GridLayoutManager(getActivity(),3);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);


        recyclerView2=getActivity().findViewById(R.id.recycml);
        LinearLayoutManager manager1=new LinearLayoutManager(getActivity());
        manager1.setOrientation(RecyclerView.VERTICAL);
        recyclerView2.setLayoutManager(manager1);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_sho_ye;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }

    private void iniShouye() {
        NetUtil.getInstance().NetShouyr(MyUrl.BASESHOUYE, ShouyeBean.class, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                ShouyeBean shouyeBean = gson.fromJson(stra, ShouyeBean.class);
                MyShouyeAdapter myShouyeAdapter = new MyShouyeAdapter(shouyeBean.getResult().getRxxp().getCommodityList(), getActivity());
                recyclerView.setAdapter(myShouyeAdapter);



            }
        });


        NetUtil.getInstance().NetShouyr(MyUrl.BASESHOUYE, ShouyeBean.class, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                ShouyeBean shouyeBean = gson.fromJson(stra, ShouyeBean.class);
                MyShouyeAdapter2 myShouyeAdapter = new MyShouyeAdapter2(shouyeBean.getResult().getMlss().getCommodityList(), getActivity());
                recyclerView2.setAdapter(myShouyeAdapter);



            }
        });
    }

}
