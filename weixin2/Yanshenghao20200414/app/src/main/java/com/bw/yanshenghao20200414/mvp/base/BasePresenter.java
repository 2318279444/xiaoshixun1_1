package com.bw.yanshenghao20200414.mvp.base;



import com.bw.yanshenghao20200414.mvp.contract.Contract;

import java.lang.ref.WeakReference;

public abstract class BasePresenter <V extends Contract.IView>implements Contract.IPresenter{

    private WeakReference<V> vWeakReference;

    public BasePresenter(){
        initModel();
    }

    protected abstract void initModel();

    public void Attch(V iView){
        vWeakReference = new WeakReference<>(iView);
    }
    public void onEnd(){
        if (vWeakReference != null) {
            vWeakReference.clear();
            vWeakReference=null;
        }
    }
    public V getView(){
        return vWeakReference.get();
    }


}
