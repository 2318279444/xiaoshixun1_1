package com.bw.yanshenghao20200414.mvp.api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


public interface ApiService {
    @GET
    Observable<ResponseBody>getInfo(@Url String url);
    @GET//get有参数 QueryParam 对应注解 @QueryMap
    Observable<ResponseBody>getInfoHava(@Url String url, @QueryMap Map<String, Object> map);

    @FormUrlEncoded
    @POST//post参数 FormParam 对应的注解@FieldMap
    Observable<ResponseBody>postInfoHava(@Url String url, @FieldMap Map<String, Object> map);
}
