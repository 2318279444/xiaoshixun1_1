package util;

import com.bw.okhttp_huancun.App;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/*
 *@auther:邓先超
 *@Date: 2020/3/27
 *@Time:10:24
 *@Description:
 **/
public class CacheIntercepter implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        //有网络时,设置缓存超时时间一个小时
        int maxAge=60*60;
        //无网络时,设置超时为4周
        int maxstale=60*60*24*28;


        //拿到request对象,进行重新构造;
        Request request=chain.request();

        //有网络时,只从网络获取
        if(NetUtil.isNetWork(App.getAppContext())){
            request=request.newBuilder()
                    .cacheControl(CacheControl.FORCE_NETWORK)
                    .build();
        }else {
            //无网络时,只从缓存中读取
            request=request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }



        //拿到Response对象,进行重构,重写http协议里面的规则,之所以这样做,
        // 是因为服务器有可能
        ///不支持缓存,我们手动添加缓存的请求头
        //以下代码是固定格式,即使你的服务器支持咱们的缓存,你也要加上,
        // 有备无患,代码直接复制不用做修改
        Response response=chain.proceed(request);
        if(NetUtil.isNetWork(App.getAppContext())){
            //设置多长时间事可用的
            response.newBuilder()
                    //移除pragma参数,因为服务器不支持,pragma的字段会干扰我们的缓存
                    .removeHeader("Pragma")
                    .header("Cache","public,maxAge"+maxAge)
                    .build();
        }else {
            response.newBuilder()
                    //移除pragma参数,因为服务器不支持,pragma的字段会干扰我们的缓存
                    .removeHeader("Pragma")
                    .header("Cache","public,maxAge"+maxstale)
                    .build();
        }

        return response;
    }
}
