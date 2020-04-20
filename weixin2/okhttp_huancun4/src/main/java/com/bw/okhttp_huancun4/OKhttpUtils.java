package com.bw.okhttp_huancun4;

import android.os.Handler;
import android.os.Looper;

import java.io.File;
import java.io.IOException;
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
 * date:2020/3/26
 * author:易宸锋(dell)
 * function:对okhttp的第一版封装,实现两个功能,从服务器下载数据,从客户端提交数据
 * <p>
 * 1.okhttp请求网络步骤繁琐,代码冗余,导致代码阅读性和开发效率低下      ---->   把逻辑进行一下封装,封装到我们的方法里面就可以
 * 2.每次我们用okhttp都要去处理线程之间通讯的问题,会使我们开发效率变慢  ------->handler解决这个问题
 * <p>
 * <p>
 * 3.okhttpClinet和handler对象创建过多,导致内存资源消耗巨大我们要做封装解决这个问题
 * 4.我们使用我们的网络请求,要求有公共参数,每次手动添加过于麻烦
 * 解决方式就是通过我们的拦截器和单例模式进行解决
 * <p>
 * 话术的总结:做笔记,代码结合王老师你可以看看
 * 1000元的工资加成
 * <p>
 * 1.你要先说你项目中okhttp的缺点
 * 2.通过网络工具,你是怎么解决这些缺点
 * <p>
 * 能够说清楚,实际上如果是敲代码,到专高五我们的代码的运营就已经达到了企业级的标准,只不过还没有在项目中运用
 * 那么我们之前学过的东西,不仅仅我们的代码要用,我们的话术一定要能够说清楚
 */
public class OKhttpUtils {

    ///////////////////////////////单例及拦截器解决对象创建过多及我们公共参数设置的问题/////////////////////////
    private static OKhttpUtils mOkhtttpUtils;
    private OkHttpClient mOkHttpClien;
    private final Handler mHandler;

    //构造方法私有
    private OKhttpUtils() {
        //B.okhttp添加公共参数到拦截器中
//        Map<String, String> map = new HashMap<>();
//        map.put("source", "android");
//        PublicParamInterceptor publicParamInterceptor = new PublicParamInterceptor(map);

        //C.我们缓存拦截器咱们用,缓存路径
        File chacheFile = new File(App.getAPPContext().getCacheDir().getAbsolutePath(), "HttpCache");

        //缓存文件大小,缓存文件为10M
        Cache cache = new Cache(chacheFile, 1024 * 1024 * 10);


        //创建一个主线程的handler,项目中网络框架的封装,要涉及handler源码技术,一个线程池的封装也会涉及
        mHandler = new Handler(Looper.getMainLooper());
        mOkHttpClien = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                //B.添加okhttp的拦截器
//                .addInterceptor(publicParamInterceptor)
                //C.添加缓存的路径文件及拦截器,设置我们什么时候拿缓存数据
                .addInterceptor(new CacheInterecepter())
                //设置我们的数据如何缓存
                .cache(cache)
                .build();
    }

    //单例模式
    public static OKhttpUtils getInstance() {
        if (mOkhtttpUtils == null) {
            synchronized (OKhttpUtils.class) {
                if (mOkhtttpUtils == null) {
                    return mOkhtttpUtils = new OKhttpUtils();
                }
            }
        }
        return mOkhtttpUtils;
    }
////////////////////////////////////接口及handler我们来解决这个问题/////////////////////////////////////////

    public interface okCallback {
        void onFailure(Exception e);

        void onResponse(String json);
    }
///////////////////////////////////////////okhttp的代码/////////////////////////////////////////////////

    public void doGet(String url, final okCallback ycfokhttpCallback) {
        //创建FormBody对象,把表单添加到FormBody
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        final Call call = mOkHttpClien.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                if (ycfokhttpCallback != null) {

                    //做了线程的切换操作
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            //这里代码是运行在什么线程上,运行到主线程
                            ycfokhttpCallback.onFailure(e);
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null && response.isSuccessful()) {
                    final String json = response.body().string();
                    if (ycfokhttpCallback != null) {
                        //切换到主线程

                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                ycfokhttpCallback.onResponse(json);
                            }
                        });
                    }
                }
            }
        });
    }

    //封装Post的逻辑代码
    public void doPost(String url, Map<String, String> map, final okCallback ycfOkCallback) {
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
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            ycfOkCallback.onFailure(e);
                        }
                    });
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
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
            }
        });

    }


}
