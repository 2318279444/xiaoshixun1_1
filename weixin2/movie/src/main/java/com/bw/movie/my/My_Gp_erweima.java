package com.bw.movie.my;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import base.BaseActivity;

public class My_Gp_erweima extends BaseActivity {
    TextView textView;
    ImageView imageView;



    @Override
    protected void inidata() {

        Intent intent = getIntent();
        String movieName = intent.getStringExtra("movieName");
        textView.setText(movieName);


        Bitmap image = CodeUtils.createImage(movieName, 300, 300, null);
        imageView.setImageBitmap(image);


        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(imageView, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(My_Gp_erweima.this, ""+result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(My_Gp_erweima.this, "识别失败", Toast.LENGTH_SHORT).show();
                    }
                });
                return false;
            }
        });

    }

    @Override
    protected void iniview() {
        textView=findViewById(R.id.My_movie_ewm_name);
        imageView=findViewById(R.id.My_movie_ewm_ima);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_my__gp_erweima;
    }
}
