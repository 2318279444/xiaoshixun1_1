package fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bawei.weiduyingyuan.R;
import com.bawei.weiduyingyuan.YingFragment.YingAction;
import com.bawei.weiduyingyuan.YingFragment.YingFuJin;
import com.bawei.weiduyingyuan.YingFragment.YingTuiJian;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.MyYingFragmentAdapter;
import base.BaseFragment;
import base.BasePresenter;

public class YingYuan extends BaseFragment {
    TabLayout tabLayout;
    ViewPager pager;
    List<String> sl=new ArrayList<>();
    List<Fragment> fl=new ArrayList<>();
    LinearLayout locationbeijing;




    @Override
    protected void inidata(Bundle savedInstanceState) {
        inis();

        inif();

        inilocationbj();

        MyYingFragmentAdapter myYingFragmentAdapter = new MyYingFragmentAdapter(getFragmentManager(), sl, fl);

        tabLayout.setupWithViewPager(pager);
        pager.setAdapter(myYingFragmentAdapter);


    }

    private void inilocationbj() {
        locationbeijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "暂不支持换区域", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inif() {
        fl.add(new YingTuiJian());
        fl.add(new YingFuJin());
        fl.add(new YingAction());
    }

    private void inis() {
        sl.add("推荐影院");
        sl.add("附近影院");
        sl.add("海淀区︾");
    }

    @Override
    protected void iniview(View view) {
        tabLayout= getActivity().findViewById(R.id.tab);
        pager= getActivity().findViewById(R.id.yPager);
        locationbeijing=getActivity().findViewById(R.id.locationbeijing);
    }

    @Override
    protected int inilayout() {
        return R.layout.activity_ying_yuan;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }
}
