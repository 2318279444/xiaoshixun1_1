package com.bw.movie.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bw.movie.R;

import base.BaseActivity;

public class My_kanguomoview extends BaseActivity {



    @Override
    protected void inidata() {
        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");

        Log.e("aaa","我的3"+sessionId);
    }

    @Override
    protected void iniview() {

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_my_kanguomoview;
    }
}
