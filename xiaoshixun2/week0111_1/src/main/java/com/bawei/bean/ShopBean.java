package com.bawei.bean;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/11
 *@Time:13:48
 *@Description:
 **/
public class ShopBean {


    private String message;
    private String status;
    private List<ResultBean> result;
    private boolean Stadus;

    public boolean isStadus() {
        return Stadus;
    }

    public void setStadus(boolean stadus) {
        Stadus = stadus;
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
        private boolean stadus;

        public boolean isStadus() {
            return stadus;
        }

        public void setStadus(boolean stadus) {
            this.stadus = stadus;
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

            private boolean stadus;

            public boolean isStadus() {
                return stadus;
            }

            public void setStadus(boolean stadus) {
                this.stadus = stadus;
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
