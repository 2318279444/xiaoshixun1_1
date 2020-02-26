package get;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2020/2/22
 *@Time:15:45
 *@Description:
 **/
public interface MyGet {
    @GET
    Observable<ResponseBody> toZhengzai(@Url String url);

    @GET
    Observable<ResponseBody> toJijang(@Url String url);
}
