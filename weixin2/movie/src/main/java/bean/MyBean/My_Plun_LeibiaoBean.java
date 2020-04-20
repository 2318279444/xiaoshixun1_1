package bean.MyBean;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/4/2
 *@Time:20:27
 *@Description:
 **/
public class My_Plun_LeibiaoBean {

    /**
     * result : [{"commentTime":1585816704000,"director":"韩延","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/dwsj/dwsj1.jpg","movieId":10,"movieName":"动物世界","movieScore":0,"myCommentContent":"好看啊","myCommentScore":10,"starring":"李易峰,迈克尔·道格拉斯,周冬雨"},{"commentTime":1585816606000,"director":"\r\n李仁港","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/pdz/pdz1.jpg","movieId":25,"movieName":"攀登者","movieScore":0,"myCommentContent":"很好看","myCommentScore":9,"starring":"吴京,章子怡,井柏然,胡歌"},{"commentTime":1585812225000,"director":"姜文","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/xbyz/xbyz1.jpg","movieId":5,"movieName":"邪不压正","movieScore":0,"myCommentContent":"12312312","myCommentScore":9,"starring":"姜文,彭于晏,廖凡,许晴,周韵"},{"commentTime":1585811876000,"director":"克里斯托弗·麦奎里","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/dzd6qmwj/dzd6qmwj1.jpg","movieId":16,"movieName":"碟中谍6：全面瓦解","movieScore":0,"myCommentContent":"1","myCommentScore":5,"starring":"汤姆·克鲁斯,亨利·卡维尔,丽贝卡·弗格森,西蒙·佩吉"},{"commentTime":1585479793000,"director":"\r\n刘伟强","imageUrl":"http://mobile.bwstudent.com/images/movie/stills/zgjz/zgjz1.jpg","movieId":24,"movieName":"中国机长","movieScore":0,"myCommentContent":"好看\n","myCommentScore":4.5,"starring":"张涵予,欧豪,袁泉,张天爱,李沁"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * commentTime : 1585816704000
         * director : 韩延
         * imageUrl : http://mobile.bwstudent.com/images/movie/stills/dwsj/dwsj1.jpg
         * movieId : 10
         * movieName : 动物世界
         * movieScore : 0
         * myCommentContent : 好看啊
         * myCommentScore : 10
         * starring : 李易峰,迈克尔·道格拉斯,周冬雨
         */

        private long commentTime;
        private String director;
        private String imageUrl;
        private int movieId;
        private String movieName;
        private int movieScore;
        private String myCommentContent;
        private int myCommentScore;
        private String starring;

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public int getMovieScore() {
            return movieScore;
        }

        public void setMovieScore(int movieScore) {
            this.movieScore = movieScore;
        }

        public String getMyCommentContent() {
            return myCommentContent;
        }

        public void setMyCommentContent(String myCommentContent) {
            this.myCommentContent = myCommentContent;
        }

        public int getMyCommentScore() {
            return myCommentScore;
        }

        public void setMyCommentScore(int myCommentScore) {
            this.myCommentScore = myCommentScore;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }
    }
}
