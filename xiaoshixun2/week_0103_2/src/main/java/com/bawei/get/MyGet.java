package com.bawei.get;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2020/1/3
 *@Time:9:58
 *@Description:
 **/
public interface MyGet {
    @GET
    Observable<ResponseBody> toFenlei(@Url String url);

    @GET
    Observable<ResponseBody> toXiangqing(@Url String url, @QueryMap Map<String, Object> map);
}
