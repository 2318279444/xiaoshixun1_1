package com.bw.frescotupian;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;

public class FrescoSpimgActivity extends AppCompatActivity {
    private SimpleDraweeView sdv_fresco_spimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco_spimg);

        //初始化控件
        sdv_fresco_spimg = (SimpleDraweeView) findViewById(R.id.sdv_fresco_spimg);
        //所要加载图片的网址
        Uri uri = Uri.parse("http://assets.kgc.cn/upload/openteacher/20160831/1472636067718985.jpg");
        //创建Builder对象,一般创建出参数对象
        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        //创建参数对象,设置其样式为进度条
        GenericDraweeHierarchy hierarchy = builder.setProgressBarImage(new ProgressBarDrawable()).build();
        //将参数对象设置给图片控件
        sdv_fresco_spimg.setHierarchy(hierarchy);
        //控件加载图片,参数:网络图片的网址.
        sdv_fresco_spimg.setImageURI(uri);
    }
}
