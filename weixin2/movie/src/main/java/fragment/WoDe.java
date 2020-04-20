package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bw.movie.Person_Xinxi;
import com.bw.movie.R;
import com.bw.movie.my.My_goupiaojilu;
import com.bw.movie.my.My_guanzhu;
import com.bw.movie.my.My_kanguomoview;
import com.bw.movie.my.My_pnglun;
import com.bw.movie.my.My_shezhi;
import com.bw.movie.my.My_yijianfankui;
import com.bw.movie.my.My_yuyue;
import com.bw.movie.wo_fragment.Wode_xxi;

import base.BaseFragment;
import base.BasePresenter;

public class WoDe extends BaseFragment {
    ImageView imageView,heaima;

    TextView username;
    LinearLayout pexinxi;
    private String headPic;
    private String nickName;
    private String sex;
    private String cstime;
    private String email;

    LinearLayout wode_guanzhu,wode_yuyue,wode_goupiaojilu,wode_kanguomoview,wode_pnglun,wode_yijianfankui,wode_shezhi;
    private String sessionId;


    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String sessionId = arguments.getString("sessionId");
        Log.e("aaa","wode:sessionId:"+sessionId);

        //信息跳转
        inixxi();

        //获取bundle传值
        inibundle();


    }

    private void inibundle() {
        Bundle arguments = getArguments();
        headPic = arguments.getString("headPic");
        nickName = arguments.getString("nickName");
        sex = arguments.getString("sex");
        cstime = arguments.getString("cstime");
        email = arguments.getString("email");

        sessionId = arguments.getString("sessionId");

        Log.e("aaa","wode_xinxi"+ headPic);
        Log.e("aaa","wode_xinxi"+ nickName);
        Log.e("aaa","wode_xinxi"+ sex);
        Log.e("aaa","wode_xinxi"+ cstime);
        Log.e("aaa","wode_xinxi"+ email);

        Glide.with(getActivity()).load(headPic)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(300)))
                .into(heaima);
        username.setText(nickName);

        pexinxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Person_Xinxi.class);
                intent.putExtra("headPic", headPic);
                intent.putExtra("nickName", nickName);
                intent.putExtra("sex", sex);
                intent.putExtra("sessionId", sessionId);
                intent.putExtra("cstime", cstime);
                intent.putExtra("email", email);

                startActivity(intent);
            }
        });



    }


    @Override
    protected void iniview(View view) {

//        ImageView wode_guanzhu,wode_yuyue,wode_goupiaojilu,wode_kanguomoview,wode_pnglun,,wode_shezhi;

        wode_guanzhu=getActivity().findViewById(R.id.wode_guanzhu);
        wode_yuyue=getActivity().findViewById(R.id.wode_yuyue);
        wode_goupiaojilu=getActivity().findViewById(R.id.wode_goupiaojilu);
        wode_kanguomoview=getActivity().findViewById(R.id.wode_kanguomoview);
        wode_pnglun=getActivity().findViewById(R.id.wode_pnglun);
        wode_yijianfankui=getActivity().findViewById(R.id.wode_yijianfankui);
        wode_shezhi=getActivity().findViewById(R.id.wode_shezhi);



        pexinxi=getActivity().findViewById(R.id.pexinxi);
        username=getActivity().findViewById(R.id.text_wode);
        imageView=getActivity().findViewById(R.id.wode_xinxi_ima);
        heaima=getActivity().findViewById(R.id.imahea_wode);

    }


    private void inixxi() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Wode_xxi.class);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);
            }
        });


        wode_guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), My_guanzhu.class);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);
            }
        });



        wode_yuyue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), My_yuyue.class);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);
            }
        });



        wode_goupiaojilu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), My_goupiaojilu.class);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);
            }
        });



        wode_kanguomoview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), My_kanguomoview.class);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);
            }
        });



        wode_pnglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), My_pnglun.class);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);
            }
        });



        wode_yijianfankui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), My_yijianfankui.class);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);
            }
        });



        wode_shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), My_shezhi.class);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);
            }
        });



    }

    @Override
    protected int inilayout() {
        return R.layout.activity_wo_de;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
