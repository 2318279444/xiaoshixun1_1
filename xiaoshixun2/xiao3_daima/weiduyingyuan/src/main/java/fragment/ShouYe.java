package fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.shouye_fragment.ShouyeFragment;
import com.bw.movie.shouye_fragment.Shouye_XQ;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.ShouyeAdapter.MyShouyeAdapter;
import adapter.ShouyeAdapter.MyShouye_jijiang_Adapter;
import base.BaseFragment;
import base.BasePresenter;
import bean.BannerBean;
import bean.shouye.ShouyeBean;
import contract.Icontract;
import presenter.MyPresenter;
import url.MyUrl;
import util.NetUtil;

public class ShouYe extends BaseFragment implements Icontract.ToCall {
    Banner banner;
    List<String> list=new ArrayList<>();
    List<String> listid=new ArrayList<>();


    RecyclerView recyclerView;
    RelativeLayout remore;
    private String sessionId;
    private String movieId;
    private String listid1;
    private List<BannerBean.ResultBean> result;

    @Override
    protected void inidata(Bundle savedInstanceState) {



        //轮播
        inibanner();


//        for (int i = 0; i < 5; i++) {
//            banner.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(getActivity(), Shouye_XQ.class);
//                    intent.putExtra("movieId",23);
//                    intent.putExtra("sessionId",sessionId);
//                }
//            });
//        }



        Bundle arguments = getArguments();
        sessionId = arguments.getString("sessionId");
        Log.e("aaa","shouye:sessionId:"+ sessionId);


        Map<String,Object> map=new HashMap<>();
        map.put("page",1);
        map.put("count",21);

        MyPresenter myPresenter= (MyPresenter) p;
        myPresenter.pShouyeMoview(MyUrl.BASE_ZhengZai_Shangying, ShouyeBean.class,map);

        remore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShouyeFragment.class);
                intent.putExtra("sessionId",sessionId);
                startActivity(intent);
            }
        });



    }

    private void inibanner() {
        NetUtil.getInstance().NetBanner(MyUrl.BASEBANNER, BannerBean.class, new Icontract.ToBannerCall() {
            @Override
            public void seccess(Object o) {
                if(o instanceof BannerBean){
                    result = ((BannerBean) o).getResult();
                    for (int i = 0; i < result.size(); i++) {
                        list.add(result.get(i).getImageUrl());
                        listid1 = result.get(i).getJumpUrl().substring(19, 21);
                        listid.add(listid1);


                    }
                    Log.e("aaa","bannerid:"+listid);
                    Log.e("aaa","bannerid:"+listid.get(1));



                }

                banner.setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(getActivity()).load(path).into(imageView);
                    }
                }).setDelayTime(1500).setImages(list).start();




            }
        });
    }

    @Override
    protected void iniview(View view) {
        banner=getActivity().findViewById(R.id.banner);

        recyclerView= getActivity().findViewById(R.id.recycShouye);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

        remore=getActivity().findViewById(R.id.Shouye_remore);

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shou_ye;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return new MyPresenter();
    }

    @Override
    public void success(String stra) {
        Gson gson = new Gson();
        ShouyeBean shouyeBean = gson.fromJson(stra, ShouyeBean.class);
        MyShouyeAdapter myShouyeAdapter = new MyShouyeAdapter(shouyeBean.getResult(), getActivity());
        recyclerView.setAdapter(myShouyeAdapter);

        myShouyeAdapter.setToJijiangCall(new MyShouye_jijiang_Adapter.ToJijiangCall() {



            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), Shouye_XQ.class);
                int movie = shouyeBean.getResult().get(position).getMovieId();
                movieId = String.valueOf(movie);
                intent.putExtra("movieId", ShouYe.this.movieId);
                Log.e("aaa","首页movieId:"+ ShouYe.this.movieId);
                intent.putExtra("sessionId",sessionId);

                startActivity(intent);
            }
        });
    }
}
