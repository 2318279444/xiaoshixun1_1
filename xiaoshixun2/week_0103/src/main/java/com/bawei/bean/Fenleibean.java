package com.bawei.bean;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/3
 *@Time:10:45
 *@Description:
 **/
public class Fenleibean {

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


        private String id;
        private String name;
        private List<SecondCategoryVoBean> secondCategoryVo;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SecondCategoryVoBean> getSecondCategoryVo() {
            return secondCategoryVo;
        }

        public void setSecondCategoryVo(List<SecondCategoryVoBean> secondCategoryVo) {
            this.secondCategoryVo = secondCategoryVo;
        }

        public static class SecondCategoryVoBean {

            private String id;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
