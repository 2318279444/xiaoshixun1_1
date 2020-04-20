package com.bw.dengxianchao20200414;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import adapter.MuAdapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.GwcBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class GwcActivity extends BaseFragment implements Icontract.ToCall {
    RecyclerView recyclerView;

    TextView textView;

    CheckBox checkBox;

    List<GwcBean.OrderListBean> list=new ArrayList<>();

    private MuAdapter muAdapter;
    private GwcBean gwcBean;

    @Override
    protected void inidata(Bundle savedInstanceState) {

        //全选


        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean stus = gwcBean.isStus();
                checkBox.setChecked(stus);
                gwcBean.setStus(!stus);
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setStus(stus);
                    for (int j = 0; j < list.get(i).getDetailList().size(); j++) {
                        list.get(i).getDetailList().get(j).setStus(stus);
                        textView.setText(muAdapter.sum()+"");
                    }
                    muAdapter.notifyDataSetChanged();
                }
            }
        });




        //商家选定商品,价格联动
        NetUtil.getInstance().Net_Gwc(MyUrl.BASEGWC, GwcBean.class, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                gwcBean = gson.fromJson(stra, GwcBean.class);
                list.addAll(gwcBean.getOrderList());
                muAdapter = new MuAdapter(list, getActivity());
                recyclerView.setAdapter(muAdapter);

                muAdapter.setShopCall(new MuAdapter.ShopCall() {
                    @Override
                    public void bigindex(int bigpo) {
                        muAdapter.big(bigpo);
                        textView.setText(muAdapter.sum()+"");
                        muAdapter.notifyDataSetChanged();
                    }



                    @Override
                    public void smallindex(int bigpo, int smallpo, boolean stus) {
                        muAdapter.small(bigpo,smallpo,stus);
                        textView.setText(muAdapter.sum()+"");
                        muAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void addindex(int bigpo, int smallpo, int count) {
                        muAdapter.add(bigpo,smallpo,count);
                        textView.setText(muAdapter.sum()+"");
                        muAdapter.notifyDataSetChanged();
                    }
                });


            }
        });
//        MyPresenter myPresenter= (MyPresenter) p;
//
//        myPresenter.p_Gwc();
    }

    @Override
    protected void iniview(View view) {
        checkBox=getActivity().findViewById(R.id.check);

        textView=getActivity().findViewById(R.id.zongjia);

        recyclerView=getActivity().findViewById(R.id.recyc);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_gwc;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {

    }
}
