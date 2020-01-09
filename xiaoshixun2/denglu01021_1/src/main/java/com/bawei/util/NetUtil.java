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
 *@Date: 2020/1/2
 *@Time:16:57
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
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();


        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(MyUrl.BASE)
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
                        toCall.success(responseBody.string());
                    }
                });
    }



    public void toZhuce(String url,Class cls,Map<String,Object> map,Icontract.ToCall toCall){
        myGet.tozhuce(url,map).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toCall.success(responseBody.string());
                    }
                });
    }



    public void netShop(String url,Class cls,Map<String,Object> map,Icontract.ToShopCall toShopCall){
        myGet.toShop(url,map).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toShopCall.success(responseBody.string());
                    }
                });
    }

}
