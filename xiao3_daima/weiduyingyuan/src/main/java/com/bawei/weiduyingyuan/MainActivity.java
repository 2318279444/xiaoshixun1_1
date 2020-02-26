package com.bawei.weiduyingyuan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.RadioGroup;

import fragment.ShouYe;
import fragment.WoDe;
import fragment.YingYuan;

public class MainActivity extends AppCompatActivity {
    FragmentManager manager;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=findViewById(R.id.rg);


        ShouYe shouYe = new ShouYe();
        YingYuan yingYuan = new YingYuan();
        WoDe woDe = new WoDe();


        manager=getSupportFragmentManager();

        manager.beginTransaction()
                .add(R.id.frag,shouYe)
                .add(R.id.frag,yingYuan)
                .add(R.id.frag,woDe)
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
