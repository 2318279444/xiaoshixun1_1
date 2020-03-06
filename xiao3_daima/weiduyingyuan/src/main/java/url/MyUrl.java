package url;

/*
 *@auther:邓先超
 *@Date: 2020/2/26
 *@Time:14:22
 *@Description:
 **/
public interface MyUrl {
    String BASE="http://mobile.bwstudent.com/";

    String BASEDengLu="movieApi/user/v2/login";

    String BASEYOUXIANG="movieApi/user/v2/sendOutEmailCode";

    String BASEZHUCE="movieApi/user/v2/register";

    String BASEBANNER="movieApi/tool/v2/banner";

    String BASERecommendMove="movieApi/cinema/v1/findRecommendCinemas";

    String BASEYING_FUJIN="movieApi/cinema/v1/findNearbyCinemas";


    String BASEYING_XQ_LEFT="movieApi/cinema/v1/findCinemaInfo";

    String BASEYING_PL_RIGHT="movieApi/cinema/v1/findAllCinemaComment";

    String BASE_Location_left="movieApi/tool/v2/findRegionList";


    String BASE_Location_Right="movieApi/cinema/v2/findCinemaByRegion";

    String BASE_ZhengZai_Shangying="movieApi/movie/v2/findReleaseMovieList";

    String BASE_Remen_Movie="movieApi/movie/v2/findHotMovieList";
}
