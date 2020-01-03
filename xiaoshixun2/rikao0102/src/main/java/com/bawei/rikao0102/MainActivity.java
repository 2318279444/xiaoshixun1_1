package com.bawei.rikao0102;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.widget.ImageView;

import com.bawei.adapter.MyAdapter;
import com.bawei.adapter.MypzshAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.Bannerbean;
import com.bawei.bean.Shop;
import com.bawei.contract.Iconytact;
import com.bawei.presenter.MyPresenter;
import com.bawei.rikao0102.database.MybeanDao;
import com.bawei.url.MyUrl;
import com.bawei.util.NetUtil;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements Iconytact.ToCall {

    RecyclerView recyclerView;
    private MybeanDao mybeanDao;
    List<String> list=new ArrayList<>();
    Banner banner;


    RecyclerView recyclerView2;


    @Override
    protected void inidata() {
        mybeanDao = MyApp.getRikao0102().getMybeanDao();
        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pShop(MyUrl.BASEURL, Shop.class);



        NetUtil.getInstance().netBanner(MyUrl.BASEBANNER, Bannerbean.class, new Iconytact.CallBanner() {
            @Override
            public void success(Object o) {
                if(o instanceof Bannerbean){
                    List<Bannerbean.ResultBean> result = ((Bannerbean) o).getResult();
                    for (int i = 0; i < result.size(); i++) {
                        list.add(result.get(i).getImageUrl());
                    }
                }
                banner.setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView);
                    }
                }).setDelayTime(1000).setImages(list).start();
            }
        });



        inirxxp();
    }

    private void inirxxp() {
        NetUtil.getInstance().netShop(MyUrl.BASEURL, Shop.class, new Iconytact.ToCall() {
            @Override
            public void success(String json) {

            }
        });
    }

    @Override
    protected void iniview() {
        recyclerView2=findViewById(R.id.RecyclerView2);
        GridLayoutManager manager2=new GridLayoutManager(this,2);
        recyclerView2.setLayoutManager(manager2);


        banner=findViewById(R.id.banner);
        recyclerView=findViewById(R.id.RecyclerView);
        LinearLayoutManager manager=new LinearLayoutManager((Context) this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String json) {
        Gson gson = new Gson();
        Shop shop = gson.fromJson(json, Shop.class);
        MyAdapter myAdapter = new MyAdapter(shop.getResult().getMlss().getCommodityList(), this);
        recyclerView.setAdapter(myAdapter);


        Shop shop2 = gson.fromJson(json, Shop.class);
        MypzshAdapter myrxxpAdapter = new MypzshAdapter(shop.getResult().getPzsh().getCommodityList(), this);
        recyclerView2.setAdapter(myrxxpAdapter);
    }
}
