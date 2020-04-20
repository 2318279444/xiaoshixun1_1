package com.bw.yanshenghao20200414.mvp.presenter;



import com.bw.yanshenghao20200414.mvp.base.BasePresenter;
import com.bw.yanshenghao20200414.mvp.contract.Contract;
import com.bw.yanshenghao20200414.mvp.model.Model;

import java.util.Map;


public class PresenterImpl extends BasePresenter {

    public Contract.IModel model;
    @Override
    protected void initModel() {
        model=new Model();
    }

    @Override
    public void startgetInfo(String url, Class cls) {
        model.getInfo(url, cls, new Contract.ModelCallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }

    @Override
    public void startgetInofHava(String url, Class cls, Map<String, Object> map) {
        model.getInfoHava(url, cls, map, new Contract.ModelCallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }

    @Override
    public void startpostInfoHava(String url, Class cls, Map<String, Object> map) {
        model.postInfoHava(url, cls, map, new Contract.ModelCallBack() {
            @Override
            public void onSuccess(Object o) {
                getView().onSuccess(o);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}
