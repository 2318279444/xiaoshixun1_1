package com.bawei.dengxianchao20200316;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import base.BaseFragment;
import base.BasePresenter;
import bean.ZhuceBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;

public class ZhuceMain extends BaseFragment implements Icontract.ToCall {
    EditText phone ,pwd;
    Button zhuce;



    @Override
    protected void inidata(Bundle savedInstanceState) {
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sphone = phone.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                Map<String,Object> map=new HashMap<>();
                map.put("phone",sphone);
                map.put("pwd",spwd);
                MyPresenter myPresenter= (MyPresenter) p;
                myPresenter.pZhuce(MyUrl.BASEZHUCE, ZhuceBean.class,map);
            }
        });
    }

    @Override
    protected void iniview(View view) {
        phone=getActivity().findViewById(R.id.phone);
        pwd=getActivity().findViewById(R.id.pwd);
        zhuce=getActivity().findViewById(R.id.zhuce);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_zhuce_main;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        ZhuceBean zhuceBean = gson.fromJson(stra, ZhuceBean.class);
        String status = zhuceBean.getStatus();
        if(status.equals("0000")){
            Toast.makeText(getActivity(), zhuceBean.getMessage(), Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getActivity(), zhuceBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
