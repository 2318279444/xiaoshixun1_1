package com.bw.movie;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.flzc.wx.MyApp;
import com.google.gson.Gson;
import com.tencent.mm.opensdk.modelpay.PayReq;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.selectpalAdapter.RowAdapter;
import adapter.selectpalAdapter.ZuoAdapter;
import base.BaseActivity;
import bean.selectpal2.OrderBean;
import bean.selectpal2.RowBean;
import bean.selectpal2.XiaDanBean;
import bean.selectpal2.ZuoBean;
import bean.shouye.Shouye_JuzhaoBean;
import contract.Icontract;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import url.MyUrl;
import util.NetUtil;

public class Select_Seat extends BaseActivity implements View.OnClickListener {
    TextView textView;
    private Integer idd;
    private Integer movieId;

    private ImageView seat_Back;
    private TextView seat_Name;
    private JCVideoPlayerStandard sear_JieCao;
    private RecyclerView seat_Xuan_Zuo;
    private RecyclerView seat_Xinxi;
    private Button seat_but;

    private List<RowBean.ResultBean> mRowList = new ArrayList<>();
    private List<ZuoBean.ResultBean> mList = new ArrayList<>();

    private ZuoAdapter zuoAdapter;
    private RowAdapter rowAdapter;
    private String zuo;
    private String s;
    private int id;
    private int userId=13848;
    private double jiage;
    private String sessionId;
    private int id1;
    private String orderId;
    private String s2;

    @Override
    protected void inidata() {

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        textView.setText(name);

        String id = intent.getStringExtra("id");

        sessionId = intent.getStringExtra("sessionId");
        //影院id
        idd = Integer.valueOf(id);
        Log.e("aaa","影院id:"+idd);

        String smovieId = intent.getStringExtra("smovieId");
        //电影id
        movieId = Integer.valueOf(smovieId);
        Log.e("aaa","电影id:"+movieId);
        Log.e("aaa","电影sessionId购票:"+sessionId);


        inijc();




        Map<String,Object> map=new HashMap<>();
        map.put("movieId",movieId);
        map.put("cinemaId",idd);
        NetUtil.getInstance().Net_MOVIE_PAIQI(MyUrl.PAIQIURL, RowBean.class, map, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                RowBean rowBean = gson.fromJson(stra, RowBean.class);

                RowAdapter rowAdapter = new RowAdapter(Select_Seat.this, rowBean.getResult());
                seat_Xinxi.setAdapter(rowAdapter);


                rowAdapter.setOnItemClick(new RowAdapter.onItemClick() {
                    @Override
                    public void setOnItemClick(int index, int scheduleId, int hallId, double price) {
                        int hallId1 = rowBean.getResult().get(index).getHallId();


                        id1 = scheduleId;
//                        s = EncryptUtils.encryptMD5ToString(userId + id1 + "movie");
//                        s2 = EncryptUtils.encryptMD5ToString(13752 + id1 + "movie");


                        Log.e("aaa","userId"+userId+"id1"+id1+"movie");

                        Map<String,Object> map1=new HashMap<>();
                        map1.put("hallId",hallId1);

                        NetUtil.getInstance().Net_YingTing(MyUrl.ZUOWEIURL, ZuoBean.class, map1, new Icontract.ToCall() {
                            @Override
                            public void success(String stra) {
                                ZuoBean zuoBean = gson.fromJson(stra, ZuoBean.class);
                                ZuoAdapter zuoAdapter = new ZuoAdapter(Select_Seat.this, zuoBean.getResult());
                                seat_Xuan_Zuo.setAdapter(zuoAdapter);

                                zuoAdapter.setOnItemClick(new ZuoAdapter.onItemClick() {
                                    @Override
                                    public void setOnItemClick(List<String> list) {
                                        if (list.size() == 0) {
                                            zuo = "";
                                        } else {
                                            for (int i = 0; i < list.size(); i++) {
                                                if (i == 0) {
                                                    zuo = list.get(0);
                                                } else {
                                                    zuo += "," + list.get(i);
                                                }

                                            }
                                        }
                                        seat_but.setText("应支付￥" + jiage + list.size());

                                    }
                                });



                            }
                        });
                    }
                });
            }
        });




////请求排期
//        if (movieId != 0 && cinemaId != 0) {
//            Map map = new HashMap();
//            map.put("movieId", movieId);
//            map.put("cinemaId", cinemaId);
//            mPresenter.startGetParam(MyUrls.PAIQIURL, map, RowBean.class);
//        }
//
//        Log.e("movieID", movieId + "");
//        Log.e("cinemaId", cinemaId + "");
//
//        //请求电影
//        if (movieId != 0) {
//            Map map = new HashMap();
//            map.put("movieId", movieId);
//            mPresenter.startGetParam(MyUrls.DETAILSURL, map, DetaBean.class);
//        }
//
//
//        zuoAdapter = new ZuoAdapter(this, mList);
//        seat_Xuan_Zuo.setAdapter(zuoAdapter);
//
//        rowAdapter = new RowAdapter(this, mRowList);
//        seat_Xinxi.setAdapter(rowAdapter);
//
//
//        zuoAdapter.setOnItemClick(new ZuoAdapter.onItemClick() {
//            @Override
//            public void setOnItemClick(List<String> list) {
//                if (list.size() == 0) {
//                    zuo = "";
//                } else {
//                    for (int i = 0; i < list.size(); i++) {
//                        if (i == 0) {
//                            zuo = list.get(0);
//                        } else {
//                            zuo += "," + list.get(i);
//                        }
//
//                    }
//                }
//                seat_but.setText("应支付￥" + jiage + list.size());
//            }
//        });
//
//        rowAdapter.setOnItemClick(new RowAdapter.onItemClick() {
//            @Override
//            public void setOnItemClick(int index, int scheduleId, int hallId, double price) {
//
//                rowAdapter.setmIndex(index);
//
//                Map map = new HashMap();
//                map.put("hallId", hallId);
//                mPresenter.startGetParam(MyUrls.ZUOWEIURL, map, ZuoBean.class);
//
//                Log.e("scheduleId", scheduleId + "");
//
//                SharedPreferences pss = getSharedPreferences("pss", MODE_PRIVATE);
//
//                String userId = pss.getString("userId", "");
//
//                id = scheduleId;
//
//                s = MD5(userId + id + "movie");
//                Log.e("s", s);
//
//                jiage = price;
//
//            }
//        });

    }

    private void inijc() {
        Map<String,Object> map=new HashMap<>();
        map.put("sessionId",sessionId);
        map.put("userId",13752);

        Map<String,Object> map1=new HashMap<>();
        map1.put("movieId",movieId);

        NetUtil.getInstance().Net_Juzhao(MyUrl.BASE_JUZHAO, Shouye_JuzhaoBean.class, map, map1, new Icontract.ToCall() {
            @Override
            public void success(String stra) {
                Gson gson = new Gson();
                Shouye_JuzhaoBean shouye_juzhaoBean = gson.fromJson(stra, Shouye_JuzhaoBean.class);

                sear_JieCao.setUp(shouye_juzhaoBean.getResult().getShortFilmList().get(0).getVideoUrl(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");



            }
        });

    }


    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    protected void iniview() {
        textView=findViewById(R.id.select_name);
        seat_Back = (ImageView) findViewById(R.id.seat_Back);
        seat_Name = (TextView) findViewById(R.id.seat_Name);
        sear_JieCao = (JCVideoPlayerStandard) findViewById(R.id.sear_JieCao);
        seat_Xuan_Zuo = (RecyclerView) findViewById(R.id.seat_Xuan_Zuo);
        seat_Xinxi = (RecyclerView) findViewById(R.id.seat_Xinxi);
        seat_but = (Button) findViewById(R.id.seat_but);


        seat_Xuan_Zuo.setLayoutManager(new GridLayoutManager(this, 8));
        seat_Xinxi.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        seat_but.setOnClickListener(this);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_select__seat;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.seat_but:
                Map map = new HashMap();
                map.put("userId",13848);
                map.put("sessionId",sessionId);



                Map map1 = new HashMap();
                map1.put("scheduleId", id1);
                map1.put("seat", zuo);
                map1.put("sign",MD5("13848"+id1+"movie"));

                Log.e("aaa","影厅id"+id1);
                Log.e("aaa","座位信息"+zuo);
                NetUtil.getInstance().Net_Xiadan(MyUrl.XIADANURL, XiaDanBean.class, map, map1, new Icontract.ToCall() {
                    @Override
                    public void success(String stra) {
                        Gson gson = new Gson();
                        XiaDanBean xiaDanBean = gson.fromJson(stra, XiaDanBean.class);
                        orderId = xiaDanBean.getOrderId();
                        Log.e("aaa","下单单号:"+orderId);
                        Toast.makeText(Select_Seat.this, xiaDanBean.getMessage(), Toast.LENGTH_SHORT).show();


                        Map map = new HashMap();
                        map.put("userId",13848);
                        map.put("sessionId",sessionId);


                        Map map1 = new HashMap();
                        map1.put("payType", "1");
                        map1.put("orderId", orderId);

                        NetUtil.getInstance().Net_pal(MyUrl.ZHIFUURL, OrderBean.class, map, map1, new Icontract.ToCall() {
                            @Override
                            public void success(String stra) {
                                OrderBean orderBean = gson.fromJson(stra, OrderBean.class);
//                                String status = orderBean.getStatus();

                                PayReq req = new PayReq();

                                req.appId = orderBean.getAppId();
                                req.nonceStr = orderBean.getNonceStr();
                                req.partnerId = orderBean.getPartnerId();
                                req.prepayId = orderBean.getPrepayId();
                                req.sign = orderBean.getSign();
                                req.timeStamp = orderBean.getTimeStamp();
                                req.packageValue = orderBean.getPackageValue();

                                //去调微信
                                MyApp.mWxApi.sendReq(req);
                            }
                        });



                    }
                });

                break;
        }
    }





    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }





}
