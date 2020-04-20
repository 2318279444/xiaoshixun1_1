package com.bw.dengxianchao20200316;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.dengxianchao20200316.database.MyShopDao;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import adapter.MyAdapter;
import base.BaseActivity;
import bean.ShopBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class Shouye extends BaseActivity {
    RecyclerView recyclerView;

    TextView zongjia;

    CheckBox checkBox;
    private ShopBean shopBean;

    List<ShopBean.OrderDataBean> list=new ArrayList<>();
    private MyShopDao myShopDao;


    @Override
    protected void inidata() {

        myShopDao = MyApp.getShop6().getMyShopDao();



        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean zhuangtai = shopBean.isZhuangtai();
                checkBox.setChecked(!zhuangtai);
                shopBean.setZhuangtai(zhuangtai);
                for (int i = 0; i <list.size() ; i++) {
                    list.get(i).setZhuanttai(zhuangtai);
                    for (int j = 0; j < list.get(i).getCartlist().size(); j++) {
                        list.get(i).getCartlist().get(j).setZhuangtai(zhuangtai);
                    }
                }

            }
        });


        if(NetUtil.getInstance().getConnection(Shouye.this)){
            //解析展示数据
            NetUtil.getInstance().NetShop(MyUrl.BASESHOPURL, ShopBean.class, new Icontract.ToCall() {
                @Override
                public void success(String stra) {

                    MyShop myShop = new MyShop(stra);
                    myShopDao.insert(myShop);

                    Gson gson = new Gson();
                    shopBean = gson.fromJson(stra, ShopBean.class);
                    list.addAll(shopBean.getOrderData());

                    final MyAdapter myAdapter = new MyAdapter(list, Shouye.this);
                    recyclerView.setAdapter(myAdapter);

                    //点击全选全部选,总价联动
                    myAdapter.setToShopCall(new MyAdapter.ToShopCall() {
                        @Override
                        public void bigindex(int position) {
                            myAdapter.tobig(position);
                            zongjia.setText(myAdapter.sumprice()+"");
                            myAdapter.notifyDataSetChanged();
                        }

                        @Override
                        public void smallindex(int bposition, int sposition, boolean zhuangtai) {
                            myAdapter.tosmall(bposition,sposition,zhuangtai);
                            zongjia.setText(myAdapter.sumprice()+"");
                            myAdapter.notifyDataSetChanged();
                        }

                        @Override
                        public void sumcount(int bposition, int sposition, int count) {
                            myAdapter.tosum(bposition,sposition,count);
                            zongjia.setText(myAdapter.sumprice()+"");
                            myAdapter.notifyDataSetChanged();
                        }
                    });


                }
            });
        }else {
            Gson gson = new Gson();
            ShopBean shopBean = gson.fromJson(myShopDao.loadAll().get(0).getUrl(), ShopBean.class);
            MyAdapter myAdapter = new MyAdapter(shopBean.getOrderData(), Shouye.this);
            recyclerView.setAdapter(myAdapter);

            Toast.makeText(this, "无网络", Toast.LENGTH_SHORT).show();
        }
       
    }

    @Override
    protected void iniview() {
        checkBox=findViewById(R.id.Check_Shouye);

        zongjia=findViewById(R.id.zongjia);

        recyclerView=findViewById(R.id.recyc_Shouye);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shouye;
    }
}
