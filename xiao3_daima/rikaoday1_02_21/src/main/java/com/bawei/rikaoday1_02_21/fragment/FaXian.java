package com.bawei.rikaoday1_02_21.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.rikaoday1_02_21.R;

import base.BaseFragment;
import base.BasePresenter;

public class FaXian extends BaseFragment {


    @Override
    protected void inidata(Bundle savedInstanceState) {

    }

    @Override
    protected void iniview(View view) {

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_fa_xian;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
