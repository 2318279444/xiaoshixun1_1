package get;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2020/2/26
 *@Time:14:22
 *@Description:
 **/
public interface MyGet {
    //登录
    @FormUrlEncoded
    @POST
    Observable<ResponseBody> toDenglu(@Url String url, @FieldMap Map<String,Object> map);


    //获取验证码
    @FormUrlEncoded
    @POST
    Observable<ResponseBody> toYanZM(@Url String url,@FieldMap Map<String,Object> map);


    //注册
    @FormUrlEncoded
    @POST
    Observable<ResponseBody> toZhuCe(@Url String url,@FieldMap Map<String,Object> map);


    @GET
    Observable<ResponseBody> toBanner(@Url String url);


    @GET
    Observable<ResponseBody> toreCommendMove(@Url String url, @HeaderMap Map<String,Object> map, @QueryMap Map<String,Object> map1);


    @GET
    Observable<ResponseBody> toFujinMovie(@Url String url,@HeaderMap Map<String,Object> map,@QueryMap Map<String,Object> map1);

    @GET
    Observable<ResponseBody> toXqLeft(@Url String url,@HeaderMap Map<String,Object> map,@QueryMap Map<String,Object> map1);


    @GET
    Observable<ResponseBody> toPLRight(@Url String url,@HeaderMap Map<String,Object> map,@QueryMap Map<String,Object> map1);




}
