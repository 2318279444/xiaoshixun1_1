package com.bawei.get;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2020/1/4
 *@Time:9:34
 *@Description:
 **/
public interface MyGet {
    @GET
    Observable<ResponseBody> tofenlei(@Url String url);

    @GET
    Observable<ResponseBody> toXiangqing(@Url String url, @QueryMap Map<String,Object> map);
}
