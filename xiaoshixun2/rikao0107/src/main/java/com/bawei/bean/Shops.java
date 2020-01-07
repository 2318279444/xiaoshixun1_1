package com.bawei.bean;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/7
 *@Time:8:50
 *@Description:
 **/
public class Shops {



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
