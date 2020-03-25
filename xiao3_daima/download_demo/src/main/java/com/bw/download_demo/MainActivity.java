package com.bw.download_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvname;
    ProgressBar progressBar;
    Button btstop,btstart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvname=findViewById(R.id.tvname);
        progressBar=findViewById(R.id.progressBar);
        btstop=findViewById(R.id.btstop);
        btstart=findViewById(R.id.btstart);


        //创建文件信息对象

        final Fileinfo fileinfo = new Fileinfo(0,"http://dlsw.baidu.com/sw-search-sp/soft/1a/11798/kugou_V7.6.85.17344_setup.1427079848.exe",
                "kugou_V7.6.85.17344_setup.1427079848.exe",0,0);

        //添加事件监听
        btstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过intent传递参数Service
                Intent intent = new Intent(MainActivity.this,DownloadService.class);
                intent.setAction(DownloadService.ACTION_START);
                intent.putExtra("fileinfo",fileinfo);
                startActivity(intent);
            }
        });

        btstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过intent传递参数Service
                Intent intent = new Intent(MainActivity.this,DownloadService.class);
                intent.setAction(DownloadService.ACTION_STOP);
                intent.putExtra("fileinfo",fileinfo);
                startActivity(intent);
            }
        });

    }
}
