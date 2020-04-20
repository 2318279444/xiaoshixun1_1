package com.bw.dengxianchao20200414;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import base.BaseFragment;
import base.BasePresenter;
import bean.DlBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class DlActivity extends BaseFragment {
    EditText user,pwd;
    Button dl;


    @Override
    protected void inidata(Bundle savedInstanceState) {
        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String suser = user.getText().toString().trim();
                String spwd = pwd.getText().toString().trim();
                String s = EncryptUtils.encryptMD5ToString(spwd);
                Log.e("aaa","md5加密"+s);

                Map<String,Object> map=new HashMap<>();
                map.put("phone",suser);
                map.put("pwd",spwd);

                NetUtil.getInstance().Net_Dl(MyUrl.BASEDl, DlBean.class, map, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        DlBean dlBean = gson.fromJson(stra, DlBean.class);
                        String status = dlBean.getStatus();
                        if(status.equals("0000")){
                            Intent intent = new Intent(getActivity(), ShouYe.class);
                            startActivity(intent);
                            Log.e("aaa","staus"+status);
                            Toast.makeText(getActivity(), dlBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getActivity(), dlBean.getMessage(), Toast.LENGTH_SHORT).show();
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
        dl=getActivity().findViewById(R.id.dl);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_dl;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
