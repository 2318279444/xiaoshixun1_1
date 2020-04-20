package com.bw.dengxianchao20200414;

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
import bean.ZcBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class ZcActivity extends BaseFragment {
    EditText user,pwd;
    Button zc;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String suser = user.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                Map<String,Object> map=new HashMap<>();
                map.put("phone",suser);
                map.put("pwd",spwd);

                NetUtil.getInstance().Net_Zc(MyUrl.BASEZc, ZcBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        ZcBean zcBean = gson.fromJson(stra, ZcBean.class);
                        String status = zcBean.getStatus();
                        if(status.equals("0000")){
                            Toast.makeText(getActivity(), zcBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getActivity(), zcBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void iniview(View view) {
        user=getActivity().findViewById(R.id.user);
        pwd=getActivity().findViewById(R.id.pwd);
        zc=getActivity().findViewById(R.id.zc);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_zc;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
