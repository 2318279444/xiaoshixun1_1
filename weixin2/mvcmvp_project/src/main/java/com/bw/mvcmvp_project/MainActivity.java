package com.bw.mvcmvp_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressDialog mProgressDialog;
    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //进行控件初始化
        initView();
        //动态创建一个进度条
        mProgressDialog = new ProgressDialog(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                String name = username.getText().toString().trim();
                String word= password.getText().toString().trim();
                //创建Bean类,然后把数据放到bean类里
                final User user = new User();
                user.username=name;
                user.password=word;

                //判断信息是否为null
                boolean userInfo = submit(user);
                if (userInfo){
                    //显示进度条
                    mProgressDialog.show();
                    //开一个子线程
                    new Thread(){
                        public void run() {

                            //创建网络工具类对象
                            UserLoginNet userLoginNet = new UserLoginNet();
                            //对用户输入的信息进行判断
                            boolean falg = userLoginNet.sendUserLoginINfo(user);
                            if (falg){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        //登录成功的逻辑,谈一个吐司
                                        //关闭进度条
                                        mProgressDialog.dismiss();
                                        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        //登录成功的逻辑,谈一个吐司
                                        //关闭进度条
                                        mProgressDialog.dismiss();
                                        Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                        }
                    }.start();
                }
                break;
        }
    }

    /**
     * 非空判断
     */
    private boolean submit(User user){
        if(TextUtils.isEmpty(user.password) || TextUtils.isEmpty(user.username) ){
            Toast.makeText(MainActivity.this, "不能输入为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void initView() {
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pwd);
        login = (Button) findViewById(R.id.btn);

        login.setOnClickListener(this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
