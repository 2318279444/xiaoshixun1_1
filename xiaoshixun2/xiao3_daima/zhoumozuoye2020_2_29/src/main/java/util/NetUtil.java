package util;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import contract.Icontract;
import get.MyGet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import url.MyUrl;

/*
 *@auther:邓先超
 *@Date: 2020/2/29
 *@Time:13:16
 *@Description:
 **/
public class NetUtil {

    private OkHttpClient okHttpClient;
    private HttpLoggingInterceptor interceptor;
    private final MyGet myGet;
    private final MyGet myGet2;


    public NetUtil(){
        interceptor=new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        okHttpClient=new OkHttpClient.Builder()
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(MyUrl.BASE)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Retrofit retrofit2=new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(MyUrl.BASEBOOK)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myGet = retrofit.create(MyGet.class);

        myGet2 = retrofit2.create(MyGet.class);

    }

    public static class NetHttp{
        public static final NetUtil util=new NetUtil();
    }

    public static NetUtil getInstance(){
        return NetHttp.util;
    }

    public void NetZhuce(String url, Class cls, Map<String,Object> map, final Icontract.ToCall toCall){
        myGet.toZhuce(url, map).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toCall.success(responseBody.string());
                    }
                });
    }


    public void NEtDenglu(String url, Class cls, Map<String,Object> map, final Icontract.ToCall toCall){
        myGet.toDenglu(url, map).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toCall.success(responseBody.string());
                    }
                });
    }


    public void NetBook(String url, Class cls,final Icontract.ToCall toCall){
        myGet2.toBook(url).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toCall.success(responseBody.string());
                    }
                });
    }




}
