package com.bw.dengxianchao2020_03_02;


import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * date:2020/3/27
 * author:易宸锋(dell)
 * function:自定义缓存拦截器:如果服务器没有给文件在响应头中添加缓存的标签,那么我们
 * 在拦截器中手动的给响应头加上标签
 * 1.自定义一个类,实现Interceptor
 * 2.在intercept方法中写自己的逻辑
 */
public class CacheInterecepter implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        //有网络时,设置缓存超时时间一个小时
        int maxAge = 60 * 60;
        //无网络时,设置超时为4周
        int maxStale = 60 * 60 * 24 * 28;

        //拿到Requst对象,进行重新构造
        Request request = chain.request();
        //有网络时,只从网络获取
        if (NetWork.isNetworkReachable(App.getAPPContext())) {
            request = request.newBuilder()
                    //让请求只能请求网络
                    .cacheControl(CacheControl.FORCE_NETWORK)
                    .build();
        } else {
            //无网络时,只从缓存中读取
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }

        //拿到Response对象,进行重构,重写http协议里面的规则,之所以这样做,是因为服务器有可能
        ///不支持缓存,我们手动添加缓存的请求头
        //以下代码是固定格式,即使你的服务器支持咱们的缓存,你也要加上,有备无患,代码直接复制不用做修改
        Response response = chain.proceed(request);
        if (NetWork.isNetworkReachable(App.getAPPContext())) {
            //设置缓存多长时间是可用的
            response = response.newBuilder()
                    //移除pragma参数,因为服务器不支持,pragma的字段会干扰我们的缓存
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build();
        } else {
            response = response.newBuilder()
                    //移除pragma参数,因为服务器不支持,pragma的字段会干扰我们的缓存
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale="
                            + maxStale)
                    .build();
        }
        return response;
    }
}
