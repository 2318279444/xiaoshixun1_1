package com.bw.movie;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import fragment.ShouYe;
import fragment.WoDe;
import fragment.YingYuan;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager;
    RadioGroup radioGroup;
    DrawerLayout dralay;
    Fragment fragment;
    private ShouYe shouYe;
    private YingYuan yingYuan;
    private WoDe woDe;
    private String headPic;
    private String nickName;
    private String sex;
    private String cstime;
    private String email;
    private String sessionId;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=findViewById(R.id.rg1);



        Intent intent = getIntent();
        sessionId = intent.getStringExtra("sessionId");

        headPic = intent.getStringExtra("headPic");
        nickName = intent.getStringExtra("nickName");
        sex = intent.getStringExtra("sex");
        cstime = intent.getStringExtra("cstime");
        email = intent.getStringExtra("email");
        userId = intent.getStringExtra("userId");



        Bundle bundle = new Bundle();
        bundle.putString("sessionId", sessionId);
        bundle.putString("headPic",headPic);
        bundle.putString("nickName",nickName);
        bundle.putString("sex",sex);
        bundle.putString("cstime",cstime);
        bundle.putString("email",email);
        bundle.putString("sessionId",sessionId);
        bundle.putString("userId",userId);


        Log.e("aaa","main:sessionId:"+ sessionId);
        shouYe = new ShouYe();
        shouYe.setArguments(bundle);
        yingYuan = new YingYuan();
        yingYuan.setArguments(bundle);
        woDe = new WoDe();
        woDe.setArguments(bundle);


        manager=getSupportFragmentManager();

        manager.beginTransaction()
                .add(R.id.frag, shouYe)
                .add(R.id.frag, yingYuan)
                .add(R.id.frag, woDe)
                .show(shouYe).hide(yingYuan).hide(woDe)
                .commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radio1:
                        manager.beginTransaction().show(shouYe).hide(yingYuan).hide(woDe).commit();
                        break;

                    case R.id.radio2:
                        manager.beginTransaction().show(yingYuan).hide(shouYe).hide(woDe).commit();
                        break;

                    case R.id.radio3:
                        manager.beginTransaction().show(woDe).hide(shouYe).hide(yingYuan).commit();
                        break;

                }
            }
        });

    }


}
