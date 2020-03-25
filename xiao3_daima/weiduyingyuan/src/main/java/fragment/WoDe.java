package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.Person_Xinxi;
import com.bw.movie.R;
import com.bw.movie.wo_fragment.Wode_xxi;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

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
                intent.putExtra("cstime", cstime);
                intent.putExtra("email", email);

                startActivity(intent);
            }
        });



    }


    @Override
    protected void iniview(View view) {
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
