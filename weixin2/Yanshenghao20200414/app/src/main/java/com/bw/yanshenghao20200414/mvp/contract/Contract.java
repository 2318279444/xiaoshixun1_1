package com.bw.yanshenghao20200414.mvp.contract;

import java.util.Map;


public interface Contract {

    interface IModel{
        void getInfo(String url, Class cls, ModelCallBack callBack);
        void getInfoHava(String url, Class cls, Map<String, Object> map, ModelCallBack callBack);
        void postInfoHava(String url, Class cls, Map<String, Object> map, ModelCallBack callBack);
    }
    interface IView<T>{
        void onSuccess(T t);
        void onError(String error);
    }
    interface IPresenter{
        void startgetInfo(String url, Class cls);
        void startgetInofHava(String url, Class cls, Map<String, Object> map);
        void startpostInfoHava(String url, Class cls, Map<String, Object> map);
    }
    interface ModelCallBack<T>{
        void onSuccess(T t);
        void onError(String error);
    }

}
