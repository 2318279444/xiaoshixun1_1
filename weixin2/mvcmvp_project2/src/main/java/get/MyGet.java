package get;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface MyGet {
    @POST
    Observable<ResponseBody> to_Login(@Url String url, @QueryMap Map<String,Object> map);
}
