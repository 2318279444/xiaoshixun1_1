package com.bawei.dengxianchao2020218;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bawei.dengxianchao2020218.R;
import com.bawei.dengxianchao2020218.dao.MyDao;
import com.bawei.dengxianchao2020218.database.DaoMaster;
import com.bawei.dengxianchao2020218.database.DaoSession;
import com.bawei.dengxianchao2020218.database.MyDaoDao;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.MyAdapter;
import base.BaseActivity;
import base.BaseFragment;
import base.BasePresenter;
import bean.DingdanBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class Quanbu extends BaseFragment implements Icontract.ToCall{
    RecyclerView recyclerView;
    private MyDaoDao myDaoDao;

    @Override
    protected void inidata(Bundle savedInstanceState) {

        boolean connettion = NetUtil.getInstance().getConnettion(getActivity());

        Bundle arguments = getArguments();
        Object sessionId = arguments.get("sessionId");
        Log.e("aaa","s2:"+sessionId);

        //map传值sessionId,sessionId
        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",27818);

        //map传值状态码和页数个数
        Map<String,Object> map1=new HashMap<>();
        map1.put("status",0);
        map1.put("page",1);
        map1.put("count",5);

        if(connettion){
            //展示
            MyPresenter myPresenter= (MyPresenter) p;
            myPresenter.pDD(MyUrl.BASEDINGDAN, DingdanBean.class,map,map1);
        }else {
            List<MyDao> list=myDaoDao.queryBuilder().list();
            for(int i=0;i<list.size();i++){
                MyDao myDao = list.get(i);
                String pic = myDao.getPic();
                DingdanBean dingdanBean = new Gson().fromJson(pic, DingdanBean.class);
                List<DingdanBean.OrderListBean> orderList = dingdanBean.getOrderList();
                LinearLayoutManager manager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(new MyAdapter(orderList,getActivity()));
            }
        }



    }

    @Override
    protected void iniview(View view) {
        recyclerView= getActivity().findViewById(R.id.recyc1);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);


        DaoSession daoSession = DaoMaster.newDevSession(getActivity(), "dingdan.dp");
        myDaoDao = daoSession.getMyDaoDao();
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_quanbu;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }




//    @Override
//    public void success(DingdanBean dingdanBean) {
//        String s = new Gson().toJson(dingdanBean);
//        myDaoDao.insert(new MyDao(s));
//        MyAdapter myAdapter = new MyAdapter(dingdanBean.getOrderList(), getActivity());
//        recyclerView.setAdapter(myAdapter);
//    }

    @Override
    public void success(String stra) {
        DingdanBean dingdanBean = new Gson().fromJson(stra, DingdanBean.class);
        recyclerView.setAdapter(new MyAdapter(dingdanBean.getOrderList(),getActivity()));
    }
}
