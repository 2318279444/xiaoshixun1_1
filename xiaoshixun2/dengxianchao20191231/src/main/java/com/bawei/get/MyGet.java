package com.bawei.get;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2019/12/31
 *@Time:8:58
 *@Description:
 **/
public interface MyGet {
    @GET
    Observable<ResponseBody> toXinxi(@Url String url);
}
