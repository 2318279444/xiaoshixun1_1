package fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.weiduyingyuan.R;

import base.BaseFragment;
import base.BasePresenter;

public class YingYuan extends BaseFragment {



    @Override
    protected void inidata(Bundle savedInstanceState) {

    }

    @Override
    protected void iniview(View view) {

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
