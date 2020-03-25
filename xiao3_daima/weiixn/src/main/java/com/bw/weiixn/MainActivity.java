package com.bw.weiixn;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParallaxListView plv = (ParallaxListView) findViewById(R.id.plv);

        View headerView = View.inflate(this, R.layout.layout_header, null);
        plv.addHeaderView(headerView);

        ImageView iv_header = (ImageView) headerView.findViewById(R.id.iv_header);

        plv.setIv_header(iv_header);

        //使用ListView的ArrayAdapter,设置适配器
        plv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Cheeses.NAMES));
    }
}
