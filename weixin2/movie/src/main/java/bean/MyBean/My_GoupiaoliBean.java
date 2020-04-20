package bean.MyBean;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/4/2
 *@Time:15:01
 *@Description:
 **/
public class My_GoupiaoliBean {

    /**
     * result : [{"amount":1,"createTime":1584704730000,"id":1775,"imageUrl":"http://mobile.bwstudent.com/images/movie/stills/zgjz/zgjz1.jpg","movieName":"中国机长","orderId":"20200320194530211","price":0.01}]
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
         * amount : 1
         * createTime : 1584704730000
         * id : 1775
         * imageUrl : http://mobile.bwstudent.com/images/movie/stills/zgjz/zgjz1.jpg
         * movieName : 中国机长
         * orderId : 20200320194530211
         * price : 0.01
         */

        private int amount;
        private long createTime;
        private int id;
        private String imageUrl;
        private String movieName;
        private String orderId;
        private double price;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
