package com.bw.yanshenghao20200414;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.yanshenghao20200414.bean.RegisterBean;

import com.bw.yanshenghao20200414.mvp.base.BaseFragment;
import com.bw.yanshenghao20200414.mvp.base.BasePresenter;

import com.bw.yanshenghao20200414.mvp.presenter.PresenterImpl;
import com.bw.yanshenghao20200414.mvp.url.MyUrl;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends BaseFragment {


    private EditText phone;
    private EditText pwd;
    private Button register;

    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView(View view) {
        phone = view.findViewById(R.id.phone);
        pwd = view.findViewById(R.id.pwd);
        register = view.findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = phone.getText().toString().trim();
                String b = pwd.getText().toString().trim();
                HashMap<String, Object> map = new HashMap<>();
                map.put("phone",a);
                map.put("pwd",b);
                mPresenter.startpostInfoHava(MyUrl.register, RegisterBean.class,map);
            }
        });
    }

    @Override
    protected int Layout() {
        return R.layout.fragment_register;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof RegisterBean){
            String message = ((RegisterBean) o).getMessage();
            if(message.equals("注册成功")){
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onError(String error) {

    }
}
