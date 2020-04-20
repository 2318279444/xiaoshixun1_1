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

    String BASE_Jijiang_Movie="movieApi/movie/v2/findComingSoonMovieList";

    String BASE_Shouye_Movie_XQ="movieApi/movie/v2/findMoviesDetail";


    String BASE_YING_PAIQI="movieApi/cinema/v2/findCinemaScheduleList";


    String BASE_JUZHAO="movieApi/movie/v2/findMoviesDetail";


    String BASE_Shouye_SOUSUO="movieApi/movie/v2/findMovieByKeyword";

    String BASE_WODE_GUANZHU="movieApi/user/v2/verify/findUserFollowMovieList";

    String BASE_WODE_YUYUE="movieApi/user/v2/verify/findUserReserve";

    String BASE_Guanzhu_Movie="movieApi/movie/v1/verify/followMovie";

    String BASE_Guanzhu_False_Movie="movieApi/movie/v1/verify/cancelFollowMovie";

    String BASE_Yuyuetrue="movieApi/movie/v2/verify/reserve";

    String BASE_GouPiaoJiLu="movieApi/user/v2/verify/findUserBuyTicketRecord";

    String BASE_Plun="movieApi/movie/v1/verify/movieComment";

    String BASE_Plun_Liebiao="movieApi/user/v2/verify/findMyMovieCommentList";

    String BASE_Fankui="movieApi/tool/v1/verify/recordFeedBack";

    String Base_WX="movieApi/user/v1/weChatBindingLogin";

    //根据电影ID和影院ID查询电影排期
    String PAIQIURL = "movieApi/movie/v2/findMovieSchedule";

    //查询座位信息
    String ZUOWEIURL = "movieApi/movie/v2/findSeatInfo";

    //购票下单
    String XIADANURL = "movieApi/movie/v2/verify/buyMovieTickets";

    //支付
    String ZHIFUURL = "movieApi/movie/v2/verify/pay";

    //换头像
    String BASE_huan_Ima="movieApi/user/v1/verify/uploadHeadPic";
}
