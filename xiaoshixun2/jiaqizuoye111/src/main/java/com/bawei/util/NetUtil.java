package com.bawei.util;

import com.bawei.contract.Icontract;
import com.bawei.get.MyGet;
import com.bawei.jiaqizuoye111.R;
import com.bawei.url.MyUrl;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@auther:邓先超
 *@Date: 2020/1/14
 *@Time:19:53
 *@Description:
 **/
public class NetUtil {

    OkHttpClient okHttpClient;
    HttpLoggingInterceptor interceptor;
    private final MyGet myGet;

    public NetUtil(){
        interceptor=new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
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

    public void toDenglu(String url, Class cls, Map<String,Object> map, Icontract.ToCall toCall){
        myGet.toDenglu(url,map).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toCall.seccess(responseBody.string());
                    }
                });
    }

    public void toShop(String url, Class cls, Map<String,Object> map, Icontract.ToCall toCall){
        myGet.toGWC(url,map).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toCall.seccess(responseBody.string());
                    }
                });
    }

}
