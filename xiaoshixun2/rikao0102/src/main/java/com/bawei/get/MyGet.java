package com.bawei.get;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2020/1/2
 *@Time:8:46
 *@Description:
 **/
public interface MyGet {
    @GET
    Observable<ResponseBody> toShouye(@Url String url);

    @GET
    Observable<ResponseBody> tobanner(@Url String url);
}
