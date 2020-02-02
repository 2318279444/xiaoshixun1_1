package com.bawei.bean;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/14
 *@Time:19:54
 *@Description:
 **/
public class Shops {

    /**
     * result : [{"categoryName":"美妆护肤","shoppingCartList":[{"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","count":3,"pic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg","price":39},{"commodityId":3,"commodityName":"Lara style女神的魔盒全套彩妆","count":4,"pic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/1.jpg","price":3499},{"commodityId":5,"commodityName":"双头两用修容笔","count":4,"pic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/1.jpg","price":39}]},{"categoryName":"女鞋","shoppingCartList":[{"commodityId":32,"commodityName":"唐狮女鞋冬季女鞋休闲鞋子女士女鞋百搭帆布鞋女士休闲鞋子女款板鞋休闲女鞋帆布鞋","count":4,"pic":"http://mobile.bwstudent.com/images/small/commodity/nx/fbx/1/1.jpg","price":88},{"commodityId":25,"commodityName":"秋冬季真皮兔毛女鞋韩版休闲平底毛毛鞋软底百搭浅口水钻加绒棉鞋毛毛鞋潮鞋","count":4,"pic":"http://mobile.bwstudent.com/images/small/commodity/nx/ddx/1/1.jpg","price":158},{"commodityId":19,"commodityName":"环球 时尚拼色街拍百搭小白鞋 韩版原宿ulzzang板鞋 女休闲鞋","count":4,"pic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/2/1.jpg","price":78}]}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;
    private boolean stau=false;

    public boolean isStau() {
        return stau;
    }

    public void setStau(boolean stau) {
        this.stau = stau;
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
         * categoryName : 美妆护肤
         * shoppingCartList : [{"commodityId":6,"commodityName":"轻柔系自然裸妆假睫毛","count":3,"pic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg","price":39},{"commodityId":3,"commodityName":"Lara style女神的魔盒全套彩妆","count":4,"pic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/1/1.jpg","price":3499},{"commodityId":5,"commodityName":"双头两用修容笔","count":4,"pic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/3/1.jpg","price":39}]
         */

        private String categoryName;
        private List<ShoppingCartListBean> shoppingCartList;
        private Boolean stau=false;

        public Boolean getStau() {
            return stau;
        }

        public void setStau(Boolean stau) {
            this.stau = stau;
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
             * commodityId : 6
             * commodityName : 轻柔系自然裸妆假睫毛
             * count : 3
             * pic : http://mobile.bwstudent.com/images/small/commodity/mzhf/cz/4/1.jpg
             * price : 39
             */

            private int commodityId;
            private String commodityName;
            private int count;
            private String pic;
            private int price;

            private Boolean stau=false;

            public Boolean getStau() {
                return stau;
            }

            public void setStau(Boolean stau) {
                this.stau = stau;
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
