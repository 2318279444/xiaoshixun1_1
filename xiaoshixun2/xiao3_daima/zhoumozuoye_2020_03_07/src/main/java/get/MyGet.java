package get;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2020/3/7
 *@Time:14:13
 *@Description:
 **/
public interface MyGet {
    @GET
    Observable<ResponseBody> toMovie(@Url String url);
}
