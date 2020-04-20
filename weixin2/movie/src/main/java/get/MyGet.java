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
    Observable<ResponseBody> toDenglu(@Url String url, @FieldMap Map<String, Object> map);


    //获取验证码
    @FormUrlEncoded
    @POST
    Observable<ResponseBody> toYanZM(@Url String url, @FieldMap Map<String, Object> map);


    //注册
    @FormUrlEncoded
    @POST
    Observable<ResponseBody> toZhuCe(@Url String url, @FieldMap Map<String, Object> map);


    @GET
    Observable<ResponseBody> toBanner(@Url String url);


    @GET
    Observable<ResponseBody> toreCommendMove(@Url String url, @HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map1);


    @GET
    Observable<ResponseBody> toFujinMovie(@Url String url, @HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map1);

    @GET
    Observable<ResponseBody> toXqLeft(@Url String url, @HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map1);


    @GET
    Observable<ResponseBody> toPLRight(@Url String url, @HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map1);


    @GET
    Observable<ResponseBody> toLocation_Left(@Url String url);

    @GET
    Observable<ResponseBody> toLocation_Right(@Url String url, @QueryMap Map<String, Object> map);

    @GET
    Observable<ResponseBody> toShouyeMoview(@Url String url, @QueryMap Map<String, Object> map);

    @GET
    Observable<ResponseBody> toRemenMoview(@Url String url, @QueryMap Map<String, Object> map);


    @GET
    Observable<ResponseBody> toJijiang_Movie(@Url String url, @HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map1);


    @GET
    Observable<ResponseBody> toShouye_Movie_XQ(@Url String url, @HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map1);


    @GET
    Observable<ResponseBody> to_YING_PAIQI(@Url String url, @QueryMap Map<String, Object> map);



    @GET
    Observable<ResponseBody> to_Juzhao(@Url String url,@HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map1);




    @GET
    Observable<ResponseBody> to_Shoutye_Sousuo(@Url String url,@QueryMap Map<String, Object> map);

    @GET
    Observable<ResponseBody> to_Guanzhu(@Url String url,@HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map1);



    @GET
    Observable<ResponseBody> to_Yuyue(@Url String url,@HeaderMap Map<String, Object> map);


    @GET
    Observable<ResponseBody> to_Guanzhu_Movie(@Url String url,@HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map1);

    @GET
    Observable<ResponseBody> to_Guanzhu_False_Movie(@Url String url,@HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map1);


    @POST
    Observable<ResponseBody> to_Yuyuetrue(@Url String url,@HeaderMap Map<String, Object> map, @FieldMap Map<String, Object> map1);


    @GET
    Observable<ResponseBody> to_GouPiaoJiLu(@Url String url,@HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map1);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> to_Movie_Plun(@Url String url,@HeaderMap Map<String, Object> map, @FieldMap Map<String, Object> map1);


    @GET
    Observable<ResponseBody> to_Plun_Liebiao(@Url String url,@HeaderMap Map<String, Object> map, @QueryMap Map<String, Object> map1);


    @FormUrlEncoded
    @POST
    Observable<ResponseBody> to_Fankui(@Url String url,@HeaderMap Map<String, Object> map, @FieldMap Map<String, Object> map1);


    @FormUrlEncoded
    @POST
    Observable<ResponseBody> to_WX(@Url String url,@FieldMap Map<String, Object> map);


    @GET
    Observable<ResponseBody> to_MOVIE_PAIQI(@Url String url,@QueryMap Map<String, Object> map);

    @GET
    Observable<ResponseBody> to_YingTing(@Url String url,@QueryMap Map<String, Object> map);


    @FormUrlEncoded
    @POST
    Observable<ResponseBody> to_Xiadan(@Url String url,@HeaderMap Map<String,Object> map,@FieldMap Map<String, Object> map1);


    @FormUrlEncoded
    @POST
    Observable<ResponseBody> to_Pal(@Url String url,@HeaderMap Map<String,Object> map,@FieldMap Map<String, Object> map1);


    @FormUrlEncoded
    @POST
    Observable<ResponseBody> to_Huan_Ima(@Url String url,@HeaderMap Map<String,Object> map,@FieldMap Map<String, Object> map1);


}
