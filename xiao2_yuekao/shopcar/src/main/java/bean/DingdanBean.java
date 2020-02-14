package bean;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/2/13
 *@Time:15:28
 *@Description:
 **/
public class DingdanBean {

    /**
     * orderList : [{"detailList":[{"commentStatus":1,"commodityCount":3,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg","commodityPrice":39,"orderDetailId":12991},{"commentStatus":1,"commodityCount":4,"commodityId":3,"commodityName":"Lara style女神的魔盒全套彩妆","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/3.jpg","commodityPrice":3499,"orderDetailId":12992}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020021017113975727818","orderStatus":1,"orderTime":1581325900000,"payAmount":14113,"payMethod":1,"userId":27818},{"detailList":[{"commentStatus":1,"commodityCount":3,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg","commodityPrice":39,"orderDetailId":12978},{"commentStatus":1,"commodityCount":4,"commodityId":3,"commodityName":"Lara style女神的魔盒全套彩妆","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/3.jpg","commodityPrice":3499,"orderDetailId":12979}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020021017070165627818","orderStatus":2,"orderTime":1581325622000,"payAmount":14113,"payMethod":1,"userId":27818},{"detailList":[{"commentStatus":2,"commodityCount":4,"commodityId":19,"commodityName":"环球 时尚拼色街拍百搭小白鞋 韩版原宿ulzzang板鞋 女休闲鞋","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/2.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/3.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/4.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/5.jpg","commodityPrice":78,"orderDetailId":12976},{"commentStatus":2,"commodityCount":4,"commodityId":32,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/nx/fbx/1/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/fbx/1/2.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/fbx/1/3.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/fbx/1/4.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/fbx/1/5.jpg","commodityPrice":88,"orderDetailId":12977}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020021017022643227818","orderStatus":9,"orderTime":1581325346000,"payAmount":664,"payMethod":1,"userId":27818},{"detailList":[{"commentStatus":2,"commodityCount":3,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg","commodityPrice":39,"orderDetailId":12962},{"commentStatus":2,"commodityCount":4,"commodityId":25,"commodityName":"秋冬季真皮兔毛女鞋韩版休闲平底毛毛鞋软底百搭浅口水钻加绒棉鞋毛毛鞋潮鞋","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/nx/ddx/1/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/ddx/1/2.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/ddx/1/3.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/ddx/1/4.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/ddx/1/5.jpg","commodityPrice":158,"orderDetailId":12963}],"expressCompName":"京东快递","expressSn":"1001","orderId":"2020021016251691627818","orderStatus":9,"orderTime":1581323117000,"payAmount":749,"payMethod":1,"userId":27818}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<OrderListBean> orderList;

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

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * detailList : [{"commentStatus":1,"commodityCount":3,"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg","commodityPrice":39,"orderDetailId":12991},{"commentStatus":1,"commodityCount":4,"commodityId":3,"commodityName":"Lara style女神的魔盒全套彩妆","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/3.jpg","commodityPrice":3499,"orderDetailId":12992}]
         * expressCompName : 京东快递
         * expressSn : 1001
         * orderId : 2020021017113975727818
         * orderStatus : 1
         * orderTime : 1581325900000
         * payAmount : 14113
         * payMethod : 1
         * userId : 27818
         */

        private String expressCompName;
        private String expressSn;
        private String orderId;
        private int orderStatus;
        private long orderTime;
        private int payAmount;
        private int payMethod;
        private int userId;
        private List<DetailListBean> detailList;

        public String getExpressCompName() {
            return expressCompName;
        }

        public void setExpressCompName(String expressCompName) {
            this.expressCompName = expressCompName;
        }

        public String getExpressSn() {
            return expressSn;
        }

        public void setExpressSn(String expressSn) {
            this.expressSn = expressSn;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public long getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(long orderTime) {
            this.orderTime = orderTime;
        }

        public int getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(int payAmount) {
            this.payAmount = payAmount;
        }

        public int getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(int payMethod) {
            this.payMethod = payMethod;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListBean {
            /**
             * commentStatus : 1
             * commodityCount : 3
             * commodityId : 6
             * commodityName : 轻柔系自然裸妆假睫毛
             * commodityPic : http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/5.jpg
             * commodityPrice : 39
             * orderDetailId : 12991
             */

            private int commentStatus;
            private int commodityCount;
            private int commodityId;
            private String commodityName;
            private String commodityPic;
            private int commodityPrice;
            private int orderDetailId;

            public int getCommentStatus() {
                return commentStatus;
            }

            public void setCommentStatus(int commentStatus) {
                this.commentStatus = commentStatus;
            }

            public int getCommodityCount() {
                return commodityCount;
            }

            public void setCommodityCount(int commodityCount) {
                this.commodityCount = commodityCount;
            }

            public int getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(int commodityId) {
                this.commodityId = commodityId;
            }

            public String getCommodityName() {
                return commodityName;
            }

            public void setCommodityName(String commodityName) {
                this.commodityName = commodityName;
            }

            public String getCommodityPic() {
                return commodityPic;
            }

            public void setCommodityPic(String commodityPic) {
                this.commodityPic = commodityPic;
            }

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public int getOrderDetailId() {
                return orderDetailId;
            }

            public void setOrderDetailId(int orderDetailId) {
                this.orderDetailId = orderDetailId;
            }
        }
    }
}
