package com.bw.movie;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import base.BaseActivity;

public class Person_Xinxi extends BaseActivity {


    private String headPic;
    private String nickName;
    private String sex;
    private String cstime;
    private String email;

    ImageView imageViewfanhui;

    ImageView pexinxiima;
    TextView pexinxiname,pexinxisex,pexinxitime,pexinxiemail;

    @Override
    protected void inidata() {
        //获取个人信息
        inibundle();
        //返回我的
        inifanhui();

        Glide.with(this).load(headPic)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                .into(pexinxiima);
        pexinxiname.setText(nickName);


        Integer integer = Integer.valueOf(sex);
        if(integer==1){

            pexinxisex.setText("男");
        }else {

            pexinxisex.setText("女");
        }


//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd");
//        String format = simpleDateFormat.format(cstime);
//        Integer format2 = Integer.valueOf(format);
        pexinxitime.setText(cstime);

        pexinxiemail.setText(email);



    }

    private void inifanhui() {
        imageViewfanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void inibundle() {
        Intent intent = getIntent();
        headPic = intent.getStringExtra("headPic");
        nickName = intent.getStringExtra("nickName");
        sex = intent.getStringExtra("sex");
        cstime = intent.getStringExtra("cstime");
        email = intent.getStringExtra("email");
    }

    @Override
    protected void iniview() {
        imageViewfanhui=findViewById(R.id.wode_pexinxi_fanhui);
        pexinxiima=findViewById(R.id.pexinxi_ima);

        pexinxiname=findViewById(R.id.pexinxi_name);
        pexinxisex=findViewById(R.id.pexinxi_sex);
        pexinxitime=findViewById(R.id.pexinxi_time);
        pexinxiemail=findViewById(R.id.pexinxi_email);

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_person__xinxi;
    }
}
