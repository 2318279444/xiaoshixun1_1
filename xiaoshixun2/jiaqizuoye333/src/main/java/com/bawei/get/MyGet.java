package com.bawei.get;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2020/1/11
 *@Time:9:01
 *@Description:
 **/
public interface MyGet {
    @GET
    Observable<ResponseBody> toDingDan(@Url String url, @HeaderMap Map<String,Object> map , @QueryMap Map<String,Object> map1);

    @GET
    Observable<ResponseBody> toDingDan2(@Url String url, @HeaderMap Map<String,Object> map , @QueryMap Map<String,Object> map1);
}
