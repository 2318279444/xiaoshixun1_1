package com.bawei.bean;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/6
 *@Time:17:01
 *@Description:
 **/
public class ShopBean {

    /**
     * result : [{"categoryName":"女鞋","shoppingCartList":[{"commodityId":23,"commodityName":"小白鞋 女款 时尚百搭休闲板鞋","count":3,"pic":"http://172.17.8.100/images/small/commodity/nx/bx/6/1.jpg","price":139},{"commodityId":27,"commodityName":"休闲马衔扣保暖绒里棉鞋懒人鞋毛毛鞋平底女雪地靴女短靴子豆豆鞋女鞋","count":3,"pic":"http://172.17.8.100/images/small/commodity/nx/ddx/3/1.jpg","price":139},{"commodityId":32,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋","count":6,"pic":"http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg","price":88}]},{"categoryName":"美妆护肤","shoppingCartList":[{"commodityId":5,"commodityName":"双头两用修容笔","count":1,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/3/1.jpg","price":39},{"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","count":6,"pic":"http://172.17.8.100/images/small/commodity/mzhf/cz/4/1.jpg","price":39},{"commodityId":11,"commodityName":"盒装葫芦粉扑美妆蛋化妆海绵","count":2,"pic":"http://172.17.8.100/images/small/commodity/mzhf/mzgj/1/1.jpg","price":9}]}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;


    private boolean stats;

    public boolean isStats() {
        return stats;
    }

    public void setStats(boolean stats) {
        this.stats = stats;
    }

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
         * categoryName : 女鞋
         * shoppingCartList : [{"commodityId":23,"commodityName":"小白鞋 女款 时尚百搭休闲板鞋","count":3,"pic":"http://172.17.8.100/images/small/commodity/nx/bx/6/1.jpg","price":139},{"commodityId":27,"commodityName":"休闲马衔扣保暖绒里棉鞋懒人鞋毛毛鞋平底女雪地靴女短靴子豆豆鞋女鞋","count":3,"pic":"http://172.17.8.100/images/small/commodity/nx/ddx/3/1.jpg","price":139},{"commodityId":32,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋","count":6,"pic":"http://172.17.8.100/images/small/commodity/nx/fbx/1/1.jpg","price":88}]
         */

        private String categoryName;
        private List<ShoppingCartListBean> shoppingCartList;
        private boolean stats;

        public boolean isStats() {
            return stats;
        }

        public void setStats(boolean stats) {
            this.stats = stats;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public List<ShoppingCartListBean> getShoppingCartList() {
            return shoppingCartList;
        }

        public void setShoppingCartList(List<ShoppingCartListBean> shoppingCartList) {
            this.shoppingCartList = shoppingCartList;
        }

        public static class ShoppingCartListBean {
            /**
             * commodityId : 23
             * commodityName : 小白鞋 女款 时尚百搭休闲板鞋
             * count : 3
             * pic : http://172.17.8.100/images/small/commodity/nx/bx/6/1.jpg
             * price : 139
             */

            private int commodityId;
            private String commodityName;
            private int count;
            private String pic;
            private int price;
            private boolean stats;

            public boolean isStats() {
                return stats;
            }

            public void setStats(boolean stats) {
                this.stats = stats;
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

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }
        }
    }
}
