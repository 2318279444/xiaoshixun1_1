package com.bw.movie;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private String sessionId;

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



        //更换头像
        pexinxiima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Person_Xinxi.this, "...", Toast.LENGTH_SHORT).show();
//
//
//                File file= new File("http://mobile.bwstudent.com/images/movie/stills/zgjz/zgjz1.jpg");
//
//                Map map = new HashMap();
//                map.put("userId",13752);
//                map.put("sessionId",sessionId);
//
//
//                Map map1 = new HashMap();
//                map1.put("image", file);
//
//                NetUtil.getInstance().Net_Huan_Ima(MyUrl.BASE_huan_Ima, My_Huan_imaBean.class, map, map1, new Icontract.ToCall() {
//                    @Override
//                    public void success(String stra) {
//                        Gson gson = new Gson();
//                        My_Huan_imaBean my_huan_imaBean = gson.fromJson(stra, My_Huan_imaBean.class);
//                        String status = my_huan_imaBean.getStatus();
//                        if(status.equals("0000")){
//                            Toast.makeText(Person_Xinxi.this, my_huan_imaBean.getMessage(), Toast.LENGTH_SHORT).show();
//                        }else {
//                            Toast.makeText(Person_Xinxi.this, my_huan_imaBean.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });


            }
        });




   





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
        sessionId = intent.getStringExtra("sessionId");
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
