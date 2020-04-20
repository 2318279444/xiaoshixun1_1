package com.bw.okhttp_huancun3;

import android.os.Handler;
import android.os.Looper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * date:2016/11/20
 * author:易宸锋(dell)
 * function:对OKhttp的简单封装工具类,实现两个功能,从服务端下载数据;从客户端提交数据-------- -----doGet,doPost
 * 更好的OKhttp封装工具类,可以使用这个:https://github.com/angcyo/OkHttpUtils/blob/master/README.md
 * <p>
 * 1.okhttp代码太冗余,使用不方便  ----简化okhttp请求网络的冗余步骤
 * 2.每次使用okhttp,都要创建okhttpClient对和handler对象------节约内存,使所有的网络请求都用一个OKhttpC李net对象和handler对象
 * 3.okhttp异步请求,自己封装子线程,数据默认在子线程我们还要进行线程间的通讯,逻辑过于复杂了----
 * ---网络成功后,拿到的数据通过接口回调放到主线程去
 * 4.咱们在项目中,有公共参数,每次请求都要加上公共参数的字段,很麻烦  ---->请求中自动就加上了功能参数,okhttp的拦截器
 * 提示,我们拼接功能参数,注意了GET请求和Post拼接是不一样的,在GET里面我们是拼接到网址后面  ,Post我们是拼接Body请求体中,所以要if判断
 * 5.每次网络请求都要设置连接超时时间,读取超时时间等一下网络初始化的逻辑,我们也封装到工具类
 * <p>
 * 封装用到了哪些知识点?
 * 1.handler , 单例模式 , 接口 ,okhttp
 * 单例双重锁:http://www.blogjava.net/kenzhh/archive/2013/03/15/357824.html
 */
public class OkhtttpUtils {

    ////////////////////////////////////////单例及拦截器和初始化的设置//////////////////////////////////
    private static OkhtttpUtils mOkhtttpUtils;
    private OkHttpClient mOkHttpClien;
    private final Handler mHandler;

    //构造方法私有
    private OkhtttpUtils() {
        //B.okhttp添加公共参数到拦截器中
        Map<String, String> map = new HashMap<>();
        map.put("source", "android");
        PublicParamInterceptor publicParamInterceptor = new PublicParamInterceptor(map);
        File chachefile = new File(App.getAppContext().getCacheDir().getAbsolutePath());

        Cache cache = new Cache(chachefile, 1024 * 1024 * 10);

        //创建一个主线程的handler,项目中网络框架的封装,要涉及handler源码技术,一个线程池的封装也会涉及
        mHandler = new Handler(Looper.getMainLooper());

        mOkHttpClien = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                //B.添加okhttp的拦截器
                .cache(cache)
                .addInterceptor(new CacheInterecepter())
                .build();
    }

    //单例模式
    public static OkhtttpUtils getInstance() {
        if (mOkhtttpUtils == null) {
            synchronized (OkhtttpUtils.class) {
                if (mOkhtttpUtils == null) {
                    return mOkhtttpUtils = new OkhtttpUtils();
                }
            }
        }
        return mOkhtttpUtils;
    }

    //////////////////////////////////////////////////////接口////////////////////////////////
    public interface OkCallback {
        void onFailure(Exception e);

        void onResponse(String json);
    }

    ////////////////////////////////////////////okhttp与handler///////////////////////////
    //封装doGEt的网络封装,参数定义两个,一个是URL网址   一个实现接口的对象
    public void doGet(String url, final OkCallback ycfOkhttpCallback) {
        //创建FormBody对象,把表单添加到FormBody
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        final Call call = mOkHttpClien.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                if (ycfOkhttpCallback != null) {
                    //切换到主线程
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            ycfOkhttpCallback.onFailure(e);
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response != null && response.isSuccessful()) {
                    final String json = response.body().string();
                    if (ycfOkhttpCallback != null) {
                        //切换到主线程
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ycfOkhttpCallback.onResponse(json);
                            }
                        });
                    }
                }
            }
        });
    }

    //封装doPost的逻辑代码
    public void doPost(String url, Map<String, String> map, final OkCallback ycfOkCallback) {
        //创建FormBody的对象,把表单添加到formBody中
        FormBody.Builder builder = new FormBody.Builder();
        //集合对象不为null的情况下
        if (map != null) {
            for (String key : map.keySet()) {
                builder.add(key, map.get(key));
            }
        }
        FormBody formBody = builder.build();

        //创建Request对象
        Request request = new Request.Builder()
                .post(formBody)
                .url(url)
                .build();
        //创建Call对象
        final Call call = mOkHttpClien.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                if (ycfOkCallback != null) {
                    //切换到主线程
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            ycfOkCallback.onFailure(e);
                        }
                    });
                }
            }
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response != null && response.isSuccessful()) {
                    final String json = response.body().string();
                    if (ycfOkCallback != null) {
                        //切换到主线程
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ycfOkCallback.onResponse(json);
                            }
                        });
                    }
                }
                else if (ycfOkCallback != null) {
                    ycfOkCallback.onFailure(new Exception("服务器异常"));
                }
            }
        });
    }

}


