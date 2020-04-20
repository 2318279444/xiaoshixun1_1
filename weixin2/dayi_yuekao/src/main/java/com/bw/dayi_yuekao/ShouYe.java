package com.bw.dayi_yuekao;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import adapter.MyAdapter;
import base.BaseActivity;
import base.BasePresenter;
import bean.GwcBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;

public class ShouYe extends BaseActivity implements Icontract.ToCall {
    RecyclerView recyclerView;
    TextView textView;
    CheckBox checkBox;
    private GwcBean gwcBean;
    private MyAdapter myAdapter;

    List<GwcBean.OrderListBean> list=new ArrayList<>();

    @Override
    protected int inilayout() {
        return R.layout.activity_shou_ye;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    protected void inidata() {

        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.p_Gwc(MyUrl.BASEGWC, GwcBean.class);


        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean stus = gwcBean.isStus();
                checkBox.setChecked(stus);
                gwcBean.setStus(!stus);
                for (int i = 0; i <list.size() ; i++) {
                    list.get(i).setStus(stus);
                    for (int j = 0; j < list.get(i).getDetailList().size(); j++) {
                        list.get(i).getDetailList().get(j).setStus(stus);
                        textView.setText(myAdapter.sum()+"");
                    }
                }
                myAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void iniview() {

        checkBox=findViewById(R.id.check);

        textView=findViewById(R.id.zongjia);

        recyclerView=findViewById(R.id.recyc);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        gwcBean = gson.fromJson(stra, GwcBean.class);
        list.addAll(gwcBean.getOrderList());
        myAdapter = new MyAdapter(list, ShouYe.this);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setShopCall(new MyAdapter.ShopCall() {
            @Override
            public void bigindex(int bigpo) {
                myAdapter.setBig(bigpo);
                textView.setText(myAdapter.sum()+"");
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void smallindex(int bigpo, int smallpo, boolean stus) {
                myAdapter.setsmall(bigpo,smallpo,stus);
                textView.setText(myAdapter.sum()+"");
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void addnetA(int bigpo, int smallpo, int count) {
                myAdapter.addnet(bigpo,smallpo,count);
                textView.setText(myAdapter.sum()+"");
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}
