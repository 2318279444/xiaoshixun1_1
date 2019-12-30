package com.bawei.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
 *@auther:邓先超
 *@Date: 2019/12/30
 *@Time:14:55
 *@Description:
 **/
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(inilayout());

        iniview();

        inidata();
    }

    protected abstract void inidata();

    protected abstract void iniview();

    protected abstract int inilayout();
}
