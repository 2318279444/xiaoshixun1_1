package com.bawei.rikao0111;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.bawei.base.BaseActivity;

public class Pay extends BaseActivity {


    @Override
    protected void inidata() {
        Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void iniview() {

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_pay;
    }
}
