package com.bw.okhttp_huancun3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * date:2019/9/28
 * author:易宸锋(dell)
 * function: 自定义一个拦截器，封装公共请求参数
 * 1.创建一个类实现okhttp拦截器
 * 2.构造方法里面定义个Map集合接受外界传过来要平接的公共参数(注意这个公共参数各个公司是不一样的所以我们有可能要用Map也有可能用其他形式
 * 不过一般情况下我们的公共参数都是键值对的形式类型也都是String字符串,所以一般也不用修改)
 * 3.拿到原来的请求对象(REquest对象),拿到请求的网址和请求方式
 * 4.判断我们的请求方式是GET还是post,因为不同的请求方式,参数的拼接是不一样的,我们GET是拼接字符串,Post是请求头,无论哪种拼接,拼接完后
 * 都要生成新的请求对象,然后返回出去即可
 */
public class PublicParamInterceptor implements Interceptor {
        //初始化Map对象
        Map<String, String> paramMap;
        public PublicParamInterceptor(Map<String, String> paramMap) {
            this.paramMap = paramMap;
        }

        @Override

        public Response intercept(Chain chain) throws IOException {
            //拿到原来的request
            Request oldRequest = chain.request();
            //拿到请求的url
            String url = oldRequest.url().toString();
            //判断是GET还是POST请求
            if (oldRequest.method().equalsIgnoreCase("GET")) {
                if (paramMap != null && paramMap.size() > 0) {
                    StringBuilder urlBuilder = new StringBuilder(url);
                    //拼接公共请求参数
                    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                        urlBuilder.append("&" + entry.getKey() + "=" + entry.getValue());
                    }
                    url = urlBuilder.toString();
                    //如果之前的url没有？号，我们需要手动给他添加一个？号
                    if (!url.contains("?")) {
                        url = url.replaceFirst("&", "?");
                    }

                    //依据原来的request构造一个新的request,
                    Request request = oldRequest.newBuilder()
                            .url(url)
                            .build();
                    return chain.proceed(request);
                }
            } else {
                if (paramMap != null && paramMap.size() > 0) {
                    RequestBody body = oldRequest.body();
                    if (body != null && body instanceof FormBody) {
                        FormBody formBody = (FormBody) body;
                        //1.把原来的的body里面的参数添加到新的body中
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
                        //依据原来的request构造一个新的request,
                        Request newRequest = oldRequest.newBuilder()
                                .post(newFormBody)
                                .build();
                        return chain.proceed(newRequest);
                    }
                }
            }
            return chain.proceed(oldRequest);
        }
    }