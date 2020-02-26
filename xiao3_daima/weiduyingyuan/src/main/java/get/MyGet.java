package get;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.POST;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2020/2/26
 *@Time:14:22
 *@Description:
 **/
public interface MyGet {
    @POST
    Observable<ResponseBody> toDenglu(@Url String url, Map<String,Object> map);
}
