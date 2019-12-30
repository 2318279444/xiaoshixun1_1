package com.bawei.util;

import com.bawei.contract.Icontract;
import com.bawei.get.MyGet;
import com.bawei.url.MyUrl;
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
 *@Date: 2019/12/30
 *@Time:10:22
 *@Description:
 **/
public class NetUtil {

    private OkHttpClient okHttpClient;
    private HttpLoggingInterceptor interceptor;
    private final Retrofit retrofit;
    private final MyGet myGet;


    public NetUtil(){
        interceptor=new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(MyUrl.BASE)
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

    public void toGit(String url, Map<String,Object> map, Class cls, Icontract.ToCall toCall){
        myGet.toshop(url,map).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toCall.success(responseBody.string());
                    }
                });
    }




}
