package com.bawei.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
 *@auther:邓先超
 *@Date: 2020/1/6
 *@Time:17:00
 *@Description:
 **/
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(inilayout());
        p=Ipresenter();
        if(p!=null){
            p.attach(this);
        }

        iniview();

        inidata();
    }

    protected abstract void inidata();


    protected abstract void iniview();

    protected abstract int inilayout();
    protected abstract P Ipresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(p!=null){
            p.unatach();
            p=null;
        }
    }
}
