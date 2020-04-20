package com.bw.yanshenghao20200414;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.yanshenghao20200414.bean.LoginBean;

import com.bw.yanshenghao20200414.mvp.app.MyApp;
import com.bw.yanshenghao20200414.mvp.base.BaseFragment;
import com.bw.yanshenghao20200414.mvp.base.BasePresenter;

import com.bw.yanshenghao20200414.mvp.presenter.PresenterImpl;
import com.bw.yanshenghao20200414.mvp.url.MyUrl;

import java.util.HashMap;


public class LoginFragment extends BaseFragment {


    private EditText login_phone;
    private EditText login_pwd;
    private Button login;
    private String phone="^1[0-9]{10}$";
    private SharedPreferences yan;

    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView(View view) {
        login_phone = view.findViewById(R.id.login_phone);
        login_pwd = view.findViewById(R.id.login_pwd);
        login = view.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = login_phone.getText().toString().trim();
                String b = login_pwd.getText().toString().trim();


                boolean matches = a.matches(phone);
                if(matches){


                    HashMap<String, Object> map = new HashMap<>();
                    map.put("phone",a);
                    map.put("pwd",b);
                    mPresenter.startpostInfoHava(MyUrl.login, LoginBean.class,map);
                }else{
                    Toast.makeText(getContext(), "手机格式不正确", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    protected int Layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof LoginBean){
            LoginBean.ResultBean result = ((LoginBean) o).getResult();
            if(((LoginBean) o).getStatus().equals("0000")){
                Toast.makeText(getContext(), ((LoginBean) o).getMessage(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),Main2Activity.class);
                startActivity(intent);
            }


        }

    }

    @Override
    public void onError(String error) {

    }


}
