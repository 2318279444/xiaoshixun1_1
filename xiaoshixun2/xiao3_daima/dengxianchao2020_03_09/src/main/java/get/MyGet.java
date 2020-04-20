package get;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2020/3/9
 *@Time:13:35
 *@Description:
 **/
public interface MyGet {
    @GET
    Observable<ResponseBody> toNow(@Url String url, @QueryMap Map<String,Object> map);

    @GET
    Observable<ResponseBody> toHot(@Url String url, @QueryMap Map<String,Object> map);

}
