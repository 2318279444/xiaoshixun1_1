package com.bw.movie;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.tencent.mm.opensdk.modelmsg.SendAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        but = (Button) findViewById(R.id.but);

        but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but:

                if (!MyApp.mWxApi.isWXAppInstalled()) {
                    return;
                }

                final SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "diandi_wx_login";
                MyApp.mWxApi.sendReq(req);

                break;
        }

    }



}
