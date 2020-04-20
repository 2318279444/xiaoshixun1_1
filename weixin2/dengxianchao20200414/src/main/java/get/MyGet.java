package get;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface MyGet {
    @POST
    Observable<ResponseBody> to_Zc(@Url String url, @QueryMap Map<String,Object> map);

    @POST
    Observable<ResponseBody> to_Dl(@Url String url, @QueryMap Map<String,Object> map);

    @GET
    Observable<ResponseBody> to_Gwc(@Url String url);
}
