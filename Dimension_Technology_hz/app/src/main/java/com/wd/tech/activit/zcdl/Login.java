package com.wd.tech.activit.zcdl;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.tech.MainActivity;
import com.wd.tech.R;
import com.wd.tech.mvp.MyUrl;
import com.wd.tech.mvp.base.BaseActivity;
import com.wd.tech.mvp.base.BasePresenter;
import com.wd.tech.mvp.presenter.PresenterImpl;
import com.wd.tech.rsa.RsaCoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wd.tech.bean.dlzc.DlBean;

public class Login extends BaseActivity {
    EditText phone ,pwd;
    Button dl;
    private String sspwd;
    TextView kszc;

    List<DlBean.ResultBean> list=new ArrayList<>();
    private String headPic;
    private String status;
    private String sphone;
    private String spwd;


    @Override
    protected void startCoding() {


        kszc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Regist.class);


                startActivity(intent);

            }
        });


        //登录点击事件
        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sphone = phone.getText().toString().trim();
                spwd = pwd.getText().toString().trim();

                //rsa加密

                try {
                    sspwd = RsaCoder.encryptByPublicKey(spwd);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                Map<String,Object> map=new HashMap<>();
                map.put("phone",sphone);
                map.put("pwd",sspwd);
                mPresenter.startpostInfoHava(MyUrl.BASE_DL, DlBean.class,map);

            }
        });




    }

    @Override
    protected BasePresenter initPresenter() {
        return new PresenterImpl();
    }

    @Override
    protected void initView() {
        dl=findViewById(R.id.dl);
        phone=findViewById(R.id.phone);
        pwd=findViewById(R.id.pwd);
        kszc=findViewById(R.id.kszc);
    }

    @Override
    protected int Layout() {
        return R.layout.activity_login;
    }

    @Override
    public void onSuccess(Object o) {
        if(o instanceof DlBean){
            headPic = ((DlBean) o).getResult().getHeadPic();
            status = ((DlBean) o).getStatus();
            if(status.equals("0000")){
                Toast.makeText(this, ((DlBean) o).getMessage(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this, MainActivity.class);

                startActivity(intent);
            }else {
                Toast.makeText(this, ((DlBean) o).getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

    }

    @Override
    public void onError(String error) {

    }
}
