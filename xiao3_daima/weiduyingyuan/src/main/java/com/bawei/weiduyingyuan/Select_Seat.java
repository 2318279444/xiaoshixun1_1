package com.bawei.weiduyingyuan;

import android.content.Intent;
import android.widget.TextView;

import base.BaseActivity;

public class Select_Seat extends BaseActivity {
    TextView textView;

    @Override
    protected void inidata() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        textView.setText(name);
    }

    @Override
    protected void iniview() {
        textView=findViewById(R.id.select_name);

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_select__seat;
    }
}
