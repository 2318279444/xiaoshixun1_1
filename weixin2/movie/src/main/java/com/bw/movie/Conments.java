package com.bw.movie;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import base.BaseActivity;
import bean.MyBean.My_PlunBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class Conments extends BaseActivity {
    RatingBar ratingBar;
    EditText editText;
    Button button;

    private String sessionId;
    private Integer movieId;
    private Double ratin;
    private String edittext;
    private float ra;

    @Override
    protected void inidata() {
        Intent intent = getIntent();
        sessionId = intent.getStringExtra("sessionId");
        String mi = intent.getStringExtra("movieId");
        movieId = Integer.valueOf(mi);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ra = ratingBar.getRating() * 2;
                ratin = Double.valueOf(ra);
                Log.e("aaa","星星评分:"+ ratin);

            }
        });






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittext = editText.getText().toString().trim();
                Map<String,Object> map=new HashMap<>();
                map.put("sessionId",sessionId);
                map.put("userId",13752);

                Map<String,Object> map1=new HashMap<>();
                map1.put("movieId",movieId);
                map1.put("commentContent",edittext);
                map1.put("score",ratin);

                Log.e("aaa","评论sessionId"+sessionId);
                Log.e("aaa","评论movieId"+movieId);
                Log.e("aaa","评论commentContent"+edittext);
                Log.e("aaa","评论ratin"+ratin);



                NetUtil.getInstance().Net_Moviepl(MyUrl.BASE_Plun, My_PlunBean.class, map, map1, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        My_PlunBean my_plunBean = gson.fromJson(stra, My_PlunBean.class);
                        String status = my_plunBean.getStatus();
                        if(status.equals("0000")){
                            Toast.makeText(Conments.this, my_plunBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Conments.this, my_plunBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });




    }

    @Override
    protected void iniview() {
        ratingBar=findViewById(R.id.xing_plun);
        editText=findViewById(R.id.edit_plun);
        button=findViewById(R.id.btn_plun);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_conments;
    }
}
