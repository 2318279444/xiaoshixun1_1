package bean;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/3/16
 *@Time:8:39
 *@Description:
 **/
public class ShopBean {


    private int code;
    private List<OrderDataBean> orderData;
    boolean zhuangtai;

    public boolean isZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(boolean zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<OrderDataBean> getOrderData() {
        return orderData;
    }

    public void setOrderData(List<OrderDataBean> orderData) {
        this.orderData = orderData;
    }

    public static class OrderDataBean {


        private int shopId;
        private String shopName;
        private List<CartlistBean> cartlist;



        boolean zhuanttai;

        public boolean isZhuanttai() {
            return zhuanttai;
        }

        public void setZhuanttai(boolean zhuanttai) {
            this.zhuanttai = zhuanttai;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public List<CartlistBean> getCartlist() {
            return cartlist;
        }

        public void setCartlist(List<CartlistBean> cartlist) {
            this.cartlist = cartlist;
        }

        public static class CartlistBean {


            private int id;
            private int shopId;
            private String shopName;
            private String defaultPic;
            private int productId;
            private String productName;
            private String color;
            private int price;
            private int count;
            boolean zhuangtai;

            public boolean isZhuangtai() {
                return zhuangtai;
            }

            public void setZhuangtai(boolean zhuangtai) {
                this.zhuangtai = zhuangtai;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getDefaultPic() {
                return defaultPic;
            }

            public void setDefaultPic(String defaultPic) {
                this.defaultPic = defaultPic;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }
        }
    }
}
