package util;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.bw.dengxianchao2020_03_02.App;
import com.bw.dengxianchao2020_03_02.CacheInterecepter;
import com.bw.dengxianchao2020_03_02.NetWork;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import contract.Icontract;
import get.MyGet;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import url.MyUrl;

/*
 *@auther:邓先超
 *@Date: 2020/3/2
 *@Time:13:08
 *@Description:
 **/
public class NetUtil {

    OkHttpClient okHttpClient;
    HttpLoggingInterceptor interceptor;
    private final Retrofit retrofit;
    private final MyGet myGet;






    //C.我们缓存拦截器咱们用,缓存路径
    File chacheFile = new File(App.getAPPContext().getCacheDir().getAbsolutePath(), "HttpCache");

    //缓存文件大小,缓存文件为10M
    Cache cache = new Cache(chacheFile, 1024 * 1024 * 10);

    public NetUtil(){


        interceptor=new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        okHttpClient=new OkHttpClient.Builder()
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                //C.添加缓存的路径文件及拦截器,设置我们什么时候拿缓存数据
                .addInterceptor(new CacheInterecepter())
                //设置我们的数据如何缓存
                .cache(cache)
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(MyUrl.BASE)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myGet = retrofit.create(MyGet.class);

    }

    public static class NetHttp{
        public static final NetUtil util=new NetUtil();
    }

    public static NetUtil getInstance(){
        return NetHttp.util;
    }





    public void NetShop(String url, Class cls, final Icontract.ToCall toCall){


        myGet.toShop(url).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toCall.success(responseBody.string());
                    }
                });
    }

    public void NetZhuce(String url, Class cls, Map<String,Object> map, final Icontract.ToCall toCall){
        myGet.toZhuce(url,map).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toCall.success(responseBody.string());
                    }
                });
    }

    public void NetDenglu(String url, Class cls, Map<String,Object> map, final Icontract.ToCall toCall){
        myGet.toDenglu(url, map).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toCall.success(responseBody.string());
                    }
                });
    }










}
