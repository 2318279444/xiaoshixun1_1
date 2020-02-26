package url;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/*
 *@auther:邓先超
 *@Date: 2020/2/18
 *@Time:9:20
 *@Description:
 **/
public interface MyUrl {
    String BASE="http://mobile.bwstudent.com/small/";

    String BASESHOUYE="commodity/v1/findCommodityByKeyword";

    String BASEDENGLU="user/v1/login";

    String BASEDINGDAN="order/verify/v1/findOrderListByStatus";
}
