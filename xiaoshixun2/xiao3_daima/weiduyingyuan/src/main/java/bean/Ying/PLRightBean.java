package bean.Ying;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/3/4
 *@Time:13:15
 *@Description:
 **/
public class PLRightBean {

    /**
     * result : [{"commentContent":"nice5961","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-04/20200304113458.png","commentId":190,"commentTime":1583282457000,"commentUserId":13731,"commentUserName":"林家铭1232456","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"海星","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-04/20200304113324.jpg","commentId":186,"commentTime":1583250316000,"commentUserId":13770,"commentUserName":"I啦啦啦I","greatHeadPic":[],"greatNum":1,"hotComment":0,"isGreat":0},{"commentContent":"耐思","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-04/20200304113058.png","commentId":109,"commentTime":1583199480000,"commentUserId":13774,"commentUserName":"nice","greatHeadPic":[],"greatNum":2,"hotComment":0,"isGreat":0},{"commentContent":"很好","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-04/20200304112813.png","commentId":95,"commentTime":1583157405000,"commentUserId":13744,"commentUserName":"nisss","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0},{"commentContent":"很好","commentHeadPic":"http://mobile.bwstudent.com/images/movie/head_pic/2020-03-03/20200303235123.jpg","commentId":83,"commentTime":1583156417000,"commentUserId":13789,"commentUserName":"好不好腌","greatHeadPic":[],"greatNum":0,"hotComment":0,"isGreat":0}]
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
         * commentContent : nice5961
         * commentHeadPic : http://mobile.bwstudent.com/images/movie/head_pic/2020-03-04/20200304113458.png
         * commentId : 190
         * commentTime : 1583282457000
         * commentUserId : 13731
         * commentUserName : 林家铭1232456
         * greatHeadPic : []
         * greatNum : 0
         * hotComment : 0
         * isGreat : 0
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int hotComment;
        private int isGreat;
        private List<?> greatHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getHotComment() {
            return hotComment;
        }

        public void setHotComment(int hotComment) {
            this.hotComment = hotComment;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public List<?> getGreatHeadPic() {
            return greatHeadPic;
        }

        public void setGreatHeadPic(List<?> greatHeadPic) {
            this.greatHeadPic = greatHeadPic;
        }
    }
}
