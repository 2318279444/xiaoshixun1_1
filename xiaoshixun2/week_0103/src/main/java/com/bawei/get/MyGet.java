package com.bawei.get;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
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
    Observable<RequestBody> toFenlei(@Url String url);

    @GET
    Observable<RequestBody> toXiangqing(@Url String url, @HeaderMap Map<String,Object> map);
}
