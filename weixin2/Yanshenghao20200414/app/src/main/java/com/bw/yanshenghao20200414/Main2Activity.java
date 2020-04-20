package com.bw.yanshenghao20200414;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.bw.yanshenghao20200414.bean.ShopBean;
import com.bw.yanshenghao20200414.mvp.base.BaseActivity;
import com.bw.yanshenghao20200414.mvp.base.BasePresenter;

import com.bw.yanshenghao20200414.mvp.presenter.PresenterImpl;

import java.util.ArrayList;

public class Main2Activity extends BaseActivity {


    private RecyclerView recy;
    private  ArrayList<ShopBean.OrderListBean> list = new ArrayList<>();
    private OneAdapter oneAdapter;

    String url="http://blog.zhaoliang5156.cn/api/shop/month_order.json";

    @Override
    protected void startCoding() {
        oneAdapter = new OneAdapter(list,this);
        recy.setAdapter(oneAdapter);
        mPresenter.startgetInfo(url,ShopBean.class);
        oneAdapter.setCallback(new OneAdapter.ShoppingCallback() {
            @Override
            public void bigCheckClick(int bigIndex) {
                boolean b = oneAdapter.setBigCheck(bigIndex);
                oneAdapter.setBigCheckStatus(bigIndex, !b);
                oneAdapter.notifyDataSetChanged();

            }

            @Override
            public void smallCheckClick(int bigIndex, int smallIndex) {
                boolean status = list.get(bigIndex).getDetailList().get(smallIndex).isStatus();
                oneAdapter.setSmallCheck(bigIndex, smallIndex, !status);
                oneAdapter.notifyDataSetChanged();

            }

            @Override
            public void smallCheckClickCount(int bigIndex, int smallIndex, int number) {
                list.get(bigIndex).getDetailList().get(smallIndex);
                oneAdapter.notifyDataSetChanged();

            }
        });

    }

    @Override
    protected void initView() {
        recy = findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    protected int Layout() {
        return R.layout.activity_main2;
    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }



    @Override
    public void onSuccess(Object o) {
        if(o instanceof ShopBean){
            list.clear();
            list.addAll(((ShopBean)o).getOrderList());
            oneAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
