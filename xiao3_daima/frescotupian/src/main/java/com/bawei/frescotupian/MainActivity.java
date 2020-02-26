package com.bawei.frescotupian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt_fresco_spimg;
    private Button bt_fresco_crop;
    private Button bt_fresco_circleAndCorner;
    private Button bt_fresco_jpeg;
    private Button bt_fresco_gif;
    private Button bt_fresco_multi;
    private Button bt_fresco_listener;
    private Button bt_fresco_resize;
    private Button bt_fresco_modifyImg;
    private Button bt_fresco_autoSizeImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniview();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // 带进度条的图片
            case R.id.bt_fresco_spimg:
                Intent spimgIntent = new Intent(this, FrescoSpimgActivity.class);
                startActivity(spimgIntent);
                break;

            //对图片进行不同的裁剪
            case R.id.bt_fresco_crop:
                Intent cropIntent = new Intent(this, FrescoCropActivity.class);
                startActivity(cropIntent);
                break;

            //圆形和圆角图片
            case R.id.bt_fresco_circleAndCorner:
                Intent circleAndCorner = new Intent(this, FrescoCircleAndCornerActivity.class);
                startActivity(circleAndCorner);
                break;

            // 渐进式展示图片
            case R.id.bt_fresco_jpeg:
                Intent JpegIntent = new Intent(this, FrescoJpegActivity.class);
                startActivity(JpegIntent);
                break;

            //GIF动画图片
            case R.id.bt_fresco_gif:
                Intent GifIntent = new Intent(this, FrescoGifAcitivity.class);
                startActivity(GifIntent);
                break;

            //多图请求及图片复用
            case R.id.bt_fresco_multi:
                Intent MultiIntent = new Intent(this, FrescoMultiActivity.class);
                startActivity(MultiIntent);
                break;

            //图片加载监听
            case R.id.bt_fresco_listener:
                Intent ListenerIntent = new Intent(this, FrescoListenerActivity.class);
                startActivity(ListenerIntent);
                break;

            //图片修改和旋转
            case R.id.bt_fresco_resize:
                Intent ResizeIntent = new Intent(this,FrescoResizeActivity.class);
                startActivity(ResizeIntent);
                break;

            //修改图片
            case R.id.bt_fresco_modifyImg:
                Intent ModifyIntent = new Intent(this, FrescoModifyActivity.class);
                startActivity(ModifyIntent);
                break;

            //动态展示图片
            case R.id.bt_fresco_autoSizeImg:
                Intent AutoSizeIntent = new Intent(this, FrescoAutoSizeActivity.class);
                startActivity(AutoSizeIntent);
                break;
        }
    }

    private void iniview() {
        bt_fresco_spimg = (Button) findViewById(R.id.bt_fresco_spimg);
        bt_fresco_crop = (Button) findViewById(R.id.bt_fresco_crop);
        bt_fresco_circleAndCorner = (Button) findViewById(R.id.bt_fresco_circleAndCorner);
        bt_fresco_jpeg = (Button) findViewById(R.id.bt_fresco_jpeg);
        bt_fresco_gif = (Button) findViewById(R.id.bt_fresco_gif);
        bt_fresco_multi = (Button) findViewById(R.id.bt_fresco_multi);
        bt_fresco_listener = (Button) findViewById(R.id.bt_fresco_listener);
        bt_fresco_resize = (Button) findViewById(R.id.bt_fresco_resize);
        bt_fresco_modifyImg = (Button) findViewById(R.id.bt_fresco_modifyImg);
        bt_fresco_autoSizeImg = (Button) findViewById(R.id.bt_fresco_autoSizeImg);

        bt_fresco_spimg.setOnClickListener(this);
        bt_fresco_crop.setOnClickListener(this);
        bt_fresco_circleAndCorner.setOnClickListener(this);
        bt_fresco_jpeg.setOnClickListener(this);
        bt_fresco_gif.setOnClickListener(this);
        bt_fresco_multi.setOnClickListener(this);
        bt_fresco_listener.setOnClickListener(this);
        bt_fresco_resize.setOnClickListener(this);
        bt_fresco_modifyImg.setOnClickListener(this);
        bt_fresco_autoSizeImg.setOnClickListener(this);
    }


}
