package com.bawei.erweima;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


//* 流程：
//        * 1、生成二维码
//        * 从edt从拿到字符串，调用 CodeUtils.createImage
//        *
//        * 2、长按识别
//        * 给imageview设置长按监听，调用 CodeUtils.analyzeByImageView，直接接收结果
//        *
//        * 3、相册识别
//        * 第一步  调用 CodeUtils.analyzeByPhotos() 去打开相机
//        * 第二步重写 onActivityResult 方法
//        * 第三步 在 onActivityResult 方法中将结果交给 CodeUtils.onActivityResult 去处理
//        *
//        * 4、相机扫一扫识别
//        * 第一步  调用 CodeUtils.analyzeByCamera() 去打开相机
//        * 第二步重写 onActivityResult 方法
//        * 第三步 在 onActivityResult 方法中将结果交给 CodeUtils.onActivityResult 去处理


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.edit)
    EditText edit;
    @BindView(R.id.erweima)
    Button erweima;
    @BindView(R.id.xiangce)
    Button xiangce;
    @BindView(R.id.xiangji)
    Button xiangji;
    @BindView(R.id.ima)
    ImageView ima;
    @BindView(R.id.tex)
    TextView tex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CodeUtils.init(this);


        ima.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(ima, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(MainActivity.this, "" + result, Toast.LENGTH_SHORT).show();
                        tex.setText(result);
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(MainActivity.this, "识别失败", Toast.LENGTH_SHORT).show();
                    }
                });
                return false;
            }
        });


    }


    @OnClick({R.id.erweima, R.id.xiangce, R.id.xiangji})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.erweima:

                String string = edit.getText().toString().trim();
                if (string.isEmpty()) {
                    Toast.makeText(MainActivity.this, "不可以为空", Toast.LENGTH_SHORT).show();
                } else {
                    Bitmap image = CodeUtils.createImage(string, 500, 500, BitmapFactory.decodeResource(getResources(),R.mipmap.aa3));
                    ima.setImageBitmap(image);
                }

                break;
            case R.id.xiangce:
                CodeUtils.analyzeByPhotos(this);
                break;
            case R.id.xiangji:
                CodeUtils.analyzeByCamera(this);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CodeUtils.onActivityResult(this, requestCode, resultCode, data, new CodeUtils.AnalyzeCallback() {
            @Override
            public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                Toast.makeText(MainActivity.this, "" + result, Toast.LENGTH_SHORT).show();
                tex.setText(result);
            }

            @Override
            public void onAnalyzeFailed() {
                Toast.makeText(MainActivity.this, "识别失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
