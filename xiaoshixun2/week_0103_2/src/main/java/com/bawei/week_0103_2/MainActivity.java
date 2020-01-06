package com.bawei.week_0103_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.bawei.adapter.MyFenleiAdapter;
import com.bawei.adapter.MyXiangqingAdapter;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.FenleiBean;
import com.bawei.bean.Xiangqingbean;
import com.bawei.contract.Icontract;
import com.bawei.presenter.MyPresenter;
import com.bawei.url.MyUrl;
import com.bawei.util.NetUtil;
import com.bawei.week_0103_2.R;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity implements Icontract.ToCall {
    RecyclerView recyclerView1,recyclerView2;

    List<FenleiBean.ResultBean.SecondCategoryVoBean> list=new ArrayList<>();
    private MyFenleiAdapter myFenleiAdapter;
    private MyPresenter myPresenter;
    private static Map<String, Object> map;

    @Override
    protected void inidata() {

        myPresenter = (MyPresenter) p;
        myPresenter.pFenlei(MyUrl.BASEFENLEI, FenleiBean.class);


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
    public void success(final String stra) {
        Gson gson = new Gson();
        FenleiBean fenleiBean = gson.fromJson(stra, FenleiBean.class);
         List<FenleiBean.ResultBean> result = fenleiBean.getResult();

        for (int i = 0; i < result.size(); i++) {
            list.addAll(result.get(i).getSecondCategoryVo());
        }

        myFenleiAdapter = new MyFenleiAdapter(list, this);
        recyclerView1.setAdapter(myFenleiAdapter);






        myFenleiAdapter.setFenleiCallBack(new MyFenleiAdapter.FenleiCallBack() {
            @Override
            public void onclick(int position) {
                myFenleiAdapter.setColorposition(position);
                //Eventbus传值
                EventBus.getDefault().post(list.get(position).getId());
                //
                String id = list.get(position).getId();

            }
        });
        myFenleiAdapter.notifyDataSetChanged();
        //dianji
    }
    @Subscribe
    public  void toEvent(String s){
        map = new HashMap<>();
        map.put("categoryId",s);
        map.put("page",1);
        map.put("count",10);
        Log.e("ann",""+s);

        NetUtil.getInstance().netxiangqing(MyUrl.BASEXIANGQING, Xiangqingbean.class, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson1 = new Gson();
                Xiangqingbean xiangqingbean = gson1.fromJson(stra, Xiangqingbean.class);
                MyXiangqingAdapter myXiangqingAdapter = new MyXiangqingAdapter(xiangqingbean.getResult(), MainActivity.this);
                recyclerView2.setAdapter(myXiangqingAdapter);
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
