package com.bawei.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bawei.base.BaseFragment;
import com.bawei.base.BasePresenter;
import com.bawei.month1230.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Fenlei extends BaseFragment {


    Button button;



    @Override
    protected void inidata(Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post("1231313213132132");
            }
        });


    }



    @Subscribe
    public void toEvent(String s){
        Toast.makeText(getActivity(), ""+s, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void iniview(View view) {
        button= getActivity().findViewById(R.id.btn);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_fenlei;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
