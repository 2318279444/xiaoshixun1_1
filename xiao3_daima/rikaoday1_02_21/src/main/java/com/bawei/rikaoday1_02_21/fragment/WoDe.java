package com.bawei.rikaoday1_02_21.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.rikaoday1_02_21.DengCe;
import com.bawei.rikaoday1_02_21.R;
import com.bumptech.glide.Glide;

import base.BaseFragment;
import base.BasePresenter;

public class WoDe extends BaseFragment {
    TextView dz;
    ImageView imageView;

    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();

        String headPic = arguments.getString("headPic");

        Glide.with(getActivity()).load(headPic).into(imageView);


        dz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DengCe.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void iniview(View view) {
        dz=getActivity().findViewById(R.id.dz);
        imageView=getActivity().findViewById(R.id.ima);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_wo_de;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
