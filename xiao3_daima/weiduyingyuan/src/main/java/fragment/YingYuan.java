package fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bawei.weiduyingyuan.R;
import com.bawei.weiduyingyuan.YingFragment.YingAction;
import com.bawei.weiduyingyuan.YingFragment.YingFuJin;
import com.bawei.weiduyingyuan.YingFragment.YingTuiJian;
import com.bawei.weiduyingyuan.yingyuanjump.YingYuanSouSuo;
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
    EditText yingedit;
    private String sessionId;
    private YingTuiJian yingTuiJian;
    private YingFuJin yingFuJin;
    private YingAction yingAction;


    @Override
    protected void inidata(Bundle savedInstanceState) {

        Bundle arguments = getArguments();
        sessionId = arguments.getString("sessionId");
        Log.e("aaa","YingYuan:sessionId:"+ sessionId);
        //添加tab标签
        inis();
        //添加tab页面
        inif();

        //土司提示不可切换区域
        inilocationbj();

        //搜索框搜索信息
        iniss();

        MyYingFragmentAdapter myYingFragmentAdapter = new MyYingFragmentAdapter(getFragmentManager(), sl, fl);

        tabLayout.setupWithViewPager(pager);
        pager.setAdapter(myYingFragmentAdapter);


    }

    private void iniss() {
        yingedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), YingYuanSouSuo.class);
                startActivity(intent);
            }
        });
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
        Bundle bundle = new Bundle();
        bundle.putString("sessionId",sessionId);

        yingTuiJian = new YingTuiJian();
        yingTuiJian.setArguments(bundle);


        yingFuJin = new YingFuJin();
        yingFuJin.setArguments(bundle);


        yingAction = new YingAction();
        yingAction.setArguments(bundle);

        fl.add(yingTuiJian);
        fl.add(yingFuJin);
        fl.add(yingAction);
    }

    private void inis() {
        sl.add("推荐影院");
        sl.add("附近影院");
        sl.add("海淀区︾");
    }

    @Override
    protected void iniview(View view) {
        yingedit=getActivity().findViewById(R.id.yingedit);
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
