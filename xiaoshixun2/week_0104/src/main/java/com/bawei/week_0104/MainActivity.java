package com.bawei.week_0104;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bawei.adapter.MyFenAdapter;
import com.bawei.adapter.MyXingAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.Fenbean;
import com.bawei.bean.Xiangbean;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.bawei.util.NetUtil;
import com.bawei.week_0104.database.DaoMaster;
import com.bawei.week_0104.database.DaoSession;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity implements Icontract.ToCall {
    RecyclerView recyclerView1,recyclerView2;
    List<Fenbean.ResultBean.SecondCategoryVoBean> list=new ArrayList<>();
    private MyPresenter myPresenter;
    private MyFenAdapter myFenAdapter;
    private Map<String, Object> map;
    private DaoSession fenye;

    @Override
    protected void inidata() {
        myPresenter = (MyPresenter) p;
        myPresenter.pFen(MyUrl.BASEFEN, Fenbean.class);

        fenye = DaoMaster.newDevSession(this, "fenye");



    }

    @Override
    protected void iniview() {
        recyclerView1=findViewById(R.id.RecyclerView1);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView1.setLayoutManager(manager);


        recyclerView2=findViewById(R.id.RecyclerView2);
        GridLayoutManager manager1=new GridLayoutManager(this,3);
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
        Fenbean fenbean = gson.fromJson(stra, Fenbean.class);
        List<Fenbean.ResultBean> result = fenbean.getResult();

        for (int i = 0; i < result.size(); i++) {
            list.addAll(result.get(i).getSecondCategoryVo());
        }

        myFenAdapter = new MyFenAdapter(list, this);
        recyclerView1.setAdapter(myFenAdapter);



        myFenAdapter.setFenCallBack(new MyFenAdapter.FenCallBack() {
            @Override
            public void onClick(int position) {
                myFenAdapter.setColorposition(position);

                EventBus.getDefault().post(list.get(position).getId());
                Toast.makeText(MainActivity.this, list.get(position).getId(), Toast.LENGTH_SHORT).show();

            }
        });
        myFenAdapter.notifyDataSetChanged();
    }


    @Subscribe
    public void toEvent(String s){

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        map = new HashMap<>();
        map.put("categoryId",s);
        map.put("page",1);
        map.put("count",10);
        Log.e("aa",""+s);
       NetUtil.getInstance().netXiang(MyUrl.BASEXIANG, Xiangbean.class, map, new Icontract.ToCall() {
           @Override
           public void success(String stra) {
               Gson gosn1 = new Gson();
               Xiangbean xiangbean = gosn1.fromJson(stra, Xiangbean.class);
               MyXingAdapter myXingAdapter = new MyXingAdapter(xiangbean.getResult(), MainActivity.this);
               recyclerView2.setAdapter(myXingAdapter);
           }
       });
    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
