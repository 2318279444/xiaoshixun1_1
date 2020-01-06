package com.bawei.dengxianchao20200106;

import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.adapter.MyCateAdapter;
import com.bawei.adapter.MyShopAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.Catebean;
import com.bawei.bean.Shopbean;
import com.bawei.contract.Icontract;
import com.bawei.dengxianchao20200106.database.DaoMaster;
import com.bawei.dengxianchao20200106.database.DaoSession;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.bawei.util.NetUtil;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity implements Icontract.ToCall {

    RecyclerView recyclerView1,recyclerView2;

    List<String> list=new ArrayList<String>();

    @Override
    protected void inidata() {

        DaoSession cate = DaoMaster.newDevSession(this, "cate");
        boolean connection = NetUtil.getInstance().getConnection(this);

        if(connection){
            MyPresenter myPresenter= (MyPresenter) p;
            myPresenter.pCate(MyUrl.BASECATE, Catebean.class);
        }else {
            Toast.makeText(MainActivity.this,"无网络",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void iniview() {
        recyclerView1=findViewById(R.id.RecyclerView1);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView1.setLayoutManager(manager);


        recyclerView2=findViewById(R.id.RecyclerView2);
        GridLayoutManager manager1=new GridLayoutManager(this,2);
        recyclerView2.setLayoutManager(manager1);
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
    public void success(String stra) {
        Gson gson = new Gson();
        Catebean catebean = gson.fromJson(stra, Catebean.class);
        List<String> category = catebean.getCategory();
            list.addAll(category);


        MyCateAdapter myCateAdapter = new MyCateAdapter(list, this);
        recyclerView1.setAdapter(myCateAdapter);


        myCateAdapter.setCateCallBack(new MyCateAdapter.CateCallBack() {
            @Override
            public void onClick(int position) {
                myCateAdapter.setColor(position);

                EventBus.getDefault().post(category.get(position));

                Toast.makeText(MainActivity.this, category.get(position), Toast.LENGTH_SHORT).show();
                Log.e("aaa",""+category.get(position));
            }
        });
    }

    @Subscribe
    public void toEvent(String s){
        //map传值
        Map<String,Object> map=new HashMap<>();
        map.put("category",s);
        Log.e("aaa","Event"+s);
        NetUtil.getInstance().netShop(MyUrl.BASESHOP, Shopbean.class, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                //解析接口展示列表
                Gson gson1 = new Gson();
                Shopbean shopbean = gson1.fromJson(stra, Shopbean.class);
                MyShopAdapter myShopAdapter = new MyShopAdapter(shopbean.getData(), MainActivity.this);
                recyclerView2.setAdapter(myShopAdapter);
            }
        });
    }


    //注册Eventebus
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }


    //注销Eventbus
    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
