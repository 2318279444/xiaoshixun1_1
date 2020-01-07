package com.bawei.get;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2020/1/6
 *@Time:16:59
 *@Description:
 **/
public interface MyGet {
    @GET
    Observable<ResponseBody> toShop(@Url String url, @HeaderMap Map<String,Object> map);
}
