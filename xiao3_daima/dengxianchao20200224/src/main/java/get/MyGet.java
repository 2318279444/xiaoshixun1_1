package get;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2020/2/24
 *@Time:13:17
 *@Description:
 **/
public interface MyGet {
    @GET
    Observable<ResponseBody> toLiWu(@Url String url, @HeaderMap Map<String,Object> map, @QueryMap Map<String,Object> map1);
}
