package get;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2020/2/26
 *@Time:16:29
 *@Description:
 **/
public interface MyGet {
    @POST
    Observable<ResponseBody> toZhuce(@Url String url,@QueryMap Map<String,Object> map);

    @POST
    Observable<ResponseBody> toDenglu(@Url String url,@QueryMap Map<String,Object> map);
}
