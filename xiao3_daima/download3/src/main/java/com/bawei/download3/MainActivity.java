package com.bawei.download3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String loadUrl = "http://gdown.baidu.com/data/wisegame/d2fbbc8e64990454/wangyiyunyinle_87.apk";
    private String filePath = Environment.getExternalStorageDirectory() + "/" + "qq音乐.apk";
    private DownLoadFile mDown;
    private ProgressBar mProgress;
    private TextView progressTv;
    private Button download;
    private Button pause;
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        SharedPreferences sp = getSharedPreferences("download_file", MODE_PRIVATE);
        int length = sp.getInt("curr_length", 0);
        int mfileLength = sp.getInt("fileLength", 0);
        if (mfileLength != 0) {
            int progress = (int) ((float) length / (float) mfileLength * 100);
            progressTv.setText("当前进度 ：" + progress + " %");
            mProgress.setProgress(progress);
        }

        mDown = new DownLoadFile(filePath, loadUrl, this);

        mDown.setmDownListener(new DownLoadFile.DownListener() {
            @Override
            public void onProgress(int progress) {
                SharedPreferences sp = getSharedPreferences("download_file", MODE_PRIVATE);
                progressTv.setText("当前进度 ：" + progress + " %");
                mProgress.setProgress(progress);
            }

            @Override
            public void onSuccess(String success) {
                Toast.makeText(MainActivity.this, success, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String error) {
                Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initView() {

        mProgress = findViewById(R.id.progress);
        mProgress.setMax(100);
        progressTv = (TextView) findViewById(R.id.progressTv);
        download = (Button) findViewById(R.id.download);
        pause = (Button) findViewById(R.id.pause);
        start = (Button) findViewById(R.id.start);

        download.setOnClickListener(this);
        pause.setOnClickListener(this);
        start.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.download:
                mDown.downLoad();//开始下载
                break;
            case R.id.pause:
                mDown.pause();//暂停
                break;
            case R.id.start:
                mDown.start();//继续下载
                break;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (mDown!=null){
            mDown.onDestroy();
        }
    }
}
