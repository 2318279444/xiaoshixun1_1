package com.bawei.zuheshi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    jiajianqi jiajianqi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jiajianqi=findViewById(R.id.addjiajian);
        jiajianqi.setnumber(6);



    }
}
