package com.bawei.weiduyingyuan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import fragment.ShouYe;
import fragment.WoDe;
import fragment.YingYuan;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager;
    RadioGroup radioGroup;
    DrawerLayout dralay;
    private ShouYe shouYe;
    private YingYuan yingYuan;
    private WoDe woDe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=findViewById(R.id.rg);
        dralay=findViewById(R.id.drawlay);

        iniActionBar();

        Intent intent = getIntent();
        String sessionId = intent.getStringExtra("sessionId");
        Bundle bundle = new Bundle();
        bundle.putString("sessionId",sessionId);

        Log.e("aaa","main:sessionId:"+sessionId);
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

    private void iniActionBar() {

        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,dralay, R.string.open, R.string.close);



    }
}
