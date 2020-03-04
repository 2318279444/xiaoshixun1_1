package fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.weiduyingyuan.R;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import base.BaseFragment;
import base.BasePresenter;
import bean.BannerBean;
import contract.Icontract;
import url.MyUrl;
import util.NetUtil;

public class ShouYe extends BaseFragment {
    Banner banner;
    List<String> list=new ArrayList<>();
    RecyclerView recyclerView;


    @Override
    protected void inidata(Bundle savedInstanceState) {
        //轮播
        inibanner();
        Bundle arguments = getArguments();
        String sessionId = arguments.getString("sessionId");
        Log.e("aaa","shouye:sessionId:"+sessionId);


    }

    private void inibanner() {
        NetUtil.getInstance().NetBanner(MyUrl.BASEBANNER, BannerBean.class, new Icontract.ToBannerCall() {
            @Override
            public void seccess(Object o) {
                if(o instanceof BannerBean){
                    List<BannerBean.ResultBean> result = ((BannerBean) o).getResult();
                    for (int i = 0; i < result.size(); i++) {
                        list.add(result.get(i).getImageUrl());
                    }
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

    }

    @Override
    protected int inilayout() {
        return R.layout.activity_shou_ye;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
