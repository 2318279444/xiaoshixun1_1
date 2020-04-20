package base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/*
 *@auther:邓先超
 *@Date: 2020/3/7
 *@Time:13:01
 *@Description:
 **/
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
//    public P p;
//    //是否已经加载过数据
//    private  boolean isHaveData;
//
//    //表示数据是否已经请求完毕
//    private boolean isLoadFinidh;
//
//    //表示控件是否初始化完毕,,给控件设置数据避免空指针
//   private boolean isInflateFinish;
//
//
//    //Fragment的XML布局转换为Java对象
//    private View view;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        if (view!=null){
//            return view;
//        }
//
//
//        view = inirootview(inflater, container, savedInstanceState);
//
//
//        iniview(view);
//
//        isInflateFinish=true;
//        return view;
//    }
//
//    protected abstract void iniview(View view);
//
//    protected abstract View inirootview(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
//
//    protected abstract void loadeDatastart();
//    protected abstract P Ipresenter();
//
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if(!isLoadFinidh  &&  isVisibleToUser){
//            loadeDatastart();
//            isHaveData=true;
//        }
//    }


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
