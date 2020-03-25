package com.bw.dengxianchao20200316;

import android.content.Intent;
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
import bean.DengluBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;

public class DengluMain extends BaseFragment implements Icontract.ToCall {
    EditText phone ,pwd;
    Button denglu;


    @Override
    protected void inidata(Bundle savedInstanceState) {

        denglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sphone = phone.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
//                Pattern pattern = Pattern.compile("^1[0-9]{10}$");
//                Matcher matcher = pattern.matcher(sphone);
//                if(matcher.matches()){
                    Map<String,Object> map=new HashMap<>();
                    map.put("phone",sphone);
                    map.put("pwd",spwd);
                    MyPresenter myPresenter= (MyPresenter) p;
                    myPresenter.pDenglu(MyUrl.BASEDENGLU, DengluBean.class,map);
//                }else {
//                    Toast.makeText(getActivity(), "非法手机号", Toast.LENGTH_SHORT).show();
//                }
               
            }
        });
    }

    @Override
    protected void iniview(View view) {
        phone=getActivity().findViewById(R.id.phone);
        pwd=getActivity().findViewById(R.id.pwd);
        denglu=getActivity().findViewById(R.id.denglu);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_denglu_main;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        DengluBean dengluBean = gson.fromJson(stra, DengluBean.class);
        String status = dengluBean.getStatus();
        if(status.equals("0000")){
            Intent intent = new Intent(getActivity(), Shouye.class);
            startActivity(intent);
            Toast.makeText(getActivity(), dengluBean.getMessage(), Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getActivity(), dengluBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
