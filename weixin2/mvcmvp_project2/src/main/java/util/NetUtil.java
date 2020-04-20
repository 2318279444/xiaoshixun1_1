package util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.bw.mvcmvp_project2.MyApp;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import contract.Icontract;
import get.MyGet;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import url.MyUrl;

public class NetUtil {

    OkHttpClient okHttpClient;
    HttpLoggingInterceptor interceptor;
    private final MyGet myGet;


    private SharedPreferences yan;
    private String userId;
    private String sessionId;

    public NetUtil(){
        interceptor=new HttpLoggingInterceptor();
        okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        yan = MyApp.context.getSharedPreferences("yan", Context.MODE_PRIVATE);
                        userId = yan.getString("userId", "");
                        sessionId = yan.getString("sessionId", "");
                        if(TextUtils.isEmpty(userId)||TextUtils.isEmpty(sessionId)){
                            return chain.proceed(chain.request());
                        }
                        Request request = chain.request().newBuilder()
                                .addHeader("userId", userId)
                                .addHeader("sessionId", sessionId)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();

        Retrofit retrofit=new Retrofit.Builder()
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

    public void Net_Login(String url, Class cls, Map<String,Object> map, final Icontract.ToCall toCall){
        myGet.to_Login(url, map).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        toCall.success(responseBody.string());
                    }
                });
    }


}
