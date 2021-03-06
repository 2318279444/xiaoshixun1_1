package com.bawei.week1230;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.bean.Beandata;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Tiaozhuan extends AppCompatActivity {

    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.erweima)
    Button erweima;
    @BindView(R.id.btncamera)
    Button btncamera;
    @BindView(R.id.btn_xiangce)
    Button btnXiangce;
    @BindView(R.id.timage)
    ImageView timage;
    @BindView(R.id.jieshou)
    Button jieshou;
    @BindView(R.id.btnfasongg)
    Button btnfasongg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiaozhuan);
        ButterKnife.bind(this);
        CodeUtils.init(this);


        timage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(timage, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(Tiaozhuan.this, "" + result, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(Tiaozhuan.this, "失败", Toast.LENGTH_LONG).show();
                    }
                });
                return true;
            }
        });


    }

    @OnClick({R.id.erweima, R.id.btncamera, R.id.btn_xiangce})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.erweima:
                String string = edit.getText().toString();
                if (string.isEmpty()) {
                    Toast.makeText(Tiaozhuan.this, "不可以为空", Toast.LENGTH_LONG).show();
                } else {
                    Bitmap image = CodeUtils.createImage(string, 500, 500, BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                    timage.setImageBitmap(image);
                }

                break;
            case R.id.btncamera:
                CodeUtils.analyzeByCamera(this);
                break;
            case R.id.btn_xiangce:
                CodeUtils.analyzeByPhotos(this);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CodeUtils.onActivityResult(this, requestCode, resultCode, data, new CodeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                Toast.makeText(Tiaozhuan.this, "" + result, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAnalyzeFailed() {
                Toast.makeText(Tiaozhuan.this, "失败", Toast.LENGTH_LONG).show();

            }
        });
    }


    @OnClick(R.id.jieshou)
    public void onViewClicked() {
        EventBus.getDefault().post("123");
    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe
    public void getJsonBean(String json) {
        Toast.makeText(this, "接受" + json, Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.btnfasongg)
    public void onViewClickedfasongg() {
        EventBus.getDefault().postSticky(new Beandata("邓先超"));
    }


    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getJsonBean(Beandata beandata) {
        Toast.makeText(this, "接受" + beandata.getName(), Toast.LENGTH_SHORT).show();
    }

}
