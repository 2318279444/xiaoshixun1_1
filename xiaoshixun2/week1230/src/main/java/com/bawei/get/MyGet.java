package com.bawei.get;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2019/12/30
 *@Time:10:25
 *@Description:
 **/
public interface MyGet {
    @GET
    Observable<ResponseBody> toshop(@Url String url, @QueryMap Map<String,Object> map);
}
