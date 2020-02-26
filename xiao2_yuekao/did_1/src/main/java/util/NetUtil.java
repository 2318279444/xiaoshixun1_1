package util;

import com.bawei.did_1.R;
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
 *@Date: 2020/2/17
 *@Time:13:42
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
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
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

    public void NetZhuce(String url, Class cla, Map<String,Object> map, Icontract.ToCall toCall){
        myGet.toZhuce(url,map).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toCall.success(responseBody.string());
                    }
                });
    }

    public void NetDenglu(String url, Class cla, Map<String,Object> map, Icontract.ToCall toCall){
        myGet.toDenglu(url,map).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toCall.success(responseBody.string());
                    }
                });
    }

    public void NetDd(String url,Class cls,Map<String,Object> map,Map<String,Object> map1,Icontract.ToCall toCall){
        myGet.toDingdan(url,map,map1).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toCall.success(responseBody.string());
                    }
                });
    }
}
