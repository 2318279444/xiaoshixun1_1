package fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.weiduyingyuan.R;

import base.BaseFragment;
import base.BasePresenter;

public class WoDe extends BaseFragment {


    @Override
    protected void inidata(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        String sessionId = arguments.getString("sessionId");
        Log.e("aaa","wode:sessionId:"+sessionId);
    }

    @Override
    protected void iniview(View view) {

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
