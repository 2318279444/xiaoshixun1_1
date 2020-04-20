package com.bw.okhttp_huancun4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * date:2020/3/26
 * author:易宸锋(dell)
 * function:自定义的拦截器,封装公共请求参数
 * 1.创建一个类实现okhttp拦截器
 * 2.构造方法里面定义Map集合接受外界传来要拼接的公共参数(注意这个公共参数各公司定义是不一样
 * 所以我们可能用到map也可能用到其他的形式,不过一般情况下我们的公共参数都是键值对的形式,所以一般不用修改)
 * 3.拿到原来的请求对象,拿到请求的网址和请求方式
 * 4.判断我们的请求方式是GET还是post,因为不同的请求方式,参数拼接也是不一样的,我们GET拼接是字符串
 * Post拼接,是请求头,无论哪种拼接,拼接完后,都要生成新的请求对象,然后返回出去即可
 * 提示:请求方式不一样,我们拼接请求头的代码也是不同
 */
public class PublicParamInterceptor implements Interceptor {

    //从外界得到要拼接的请求头参数,做初始化
    Map<String, String> paramMap;

    public PublicParamInterceptor(Map<String, String> paramMap) {
        this.paramMap = paramMap;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        //拿到原理的Request对象
        Request oldRequest = chain.request();
        //拿到原来的请求URL网址
        String url = oldRequest.url().toString();
        //拿到这次请求的请求方式,判断是GEt还是post
        if (oldRequest.method().equalsIgnoreCase("GET")) {
            if (paramMap != null && paramMap.size() > 0) {
                StringBuilder urlBuilder = new StringBuilder(url);
                //拼接公共请求参数
                for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                    urlBuilder.append("&" + entry.getKey() + "=" + entry.getValue());
                }
                url = urlBuilder.toString();
                //如果之前的url没有?号,我们手动添加一个?号
                if (!url.contains("?")) {
                    url.replaceFirst("&", "?");
                }
                //重新构造request对象,返回出去即可
                Request request = oldRequest.newBuilder()
                        .url(url)
                        .build();
                return chain.proceed(request);
            }
        } else {//Post请求就麻烦一些
            if (paramMap != null && paramMap.size() > 0){
                RequestBody body = oldRequest.body();
                if (body !=null &&body instanceof FormBody){
                    FormBody formBody = (FormBody) body;
                    //把原来的body里面的参数添加到新的body中
                    FormBody.Builder builder = new FormBody.Builder();
                    //为了防止重复添加相同的key和value
                    Map<String, String> temMap = new HashMap<>();
                    for (int i = 0; i < formBody.size(); i++) {
                        builder.add(formBody.encodedName(i), formBody.encodedValue(i));
                        temMap.put(formBody.encodedName(i), formBody.encodedValue(i));
                    }
                    //2.把公共请求参数添加到新的body中
                    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                        if(!temMap.containsKey(entry.getKey())){
                            builder.add(entry.getKey(), entry.getValue());
                        }
                    }
                    FormBody newFormBody = builder.build();
                    //依据原来的Request构造一个新的Request对象
                    Request newRequst = oldRequest.newBuilder()
                            .post(newFormBody)
                            .build();
                    return chain.proceed(newRequst);

                }

            }
        }
        return chain.proceed(oldRequest);
    }
}
