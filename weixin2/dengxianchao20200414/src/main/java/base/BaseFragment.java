package base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
/*
 * 时间2020.4.14
 * name:邓先超
 * 功能:
 *
 * */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    public P p;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        p=Ipresenter();
        if(p!=null){
            p.attach(this);
        }
        return inflater.inflate(inilayout(),container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iniview(view);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inidata(savedInstanceState);
    }

    protected abstract void inidata(Bundle savedInstanceState);

    protected abstract void iniview(View view);

    protected abstract int inilayout();
    protected abstract P Ipresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(p!=null){
            p.unattach();
            p=null;
        }
    }
}
