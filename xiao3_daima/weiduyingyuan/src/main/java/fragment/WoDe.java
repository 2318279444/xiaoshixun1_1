package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bawei.weiduyingyuan.R;
import com.bawei.weiduyingyuan.wo_fragment.Wode_xxi;

import base.BaseFragment;
import base.BasePresenter;

public class WoDe extends BaseFragment {
    ImageView imageView;


    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String sessionId = arguments.getString("sessionId");
        Log.e("aaa","wode:sessionId:"+sessionId);

        //信息跳转
        inixxi();


    }



    @Override
    protected void iniview(View view) {
        imageView=getActivity().findViewById(R.id.wode_xinxi_ima);

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
