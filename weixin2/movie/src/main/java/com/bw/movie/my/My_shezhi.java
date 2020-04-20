package com.bw.movie.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.bw.movie.R;
import com.bw.movie.flzc.LoginActivity;

import base.BaseActivity;

public class My_shezhi extends BaseActivity {
    Button button;


    @Override
    protected void inidata() {
        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");

        Log.e("aaa","我的5"+sessionId);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(My_shezhi.this, LoginActivity.class));
            }
        });

    }

    @Override
    protected void iniview() {
        button=findViewById(R.id.My_fanhuidl);

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_my_shezhi;
    }
}
