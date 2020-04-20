package bean;

import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/3/7
 *@Time:14:15
 *@Description:
 **/
public class MovieBean {


    /**
     * code : 200
     * message : 成功!
     * category : [{"title":"正在上映","childs":[{"title":"哪吒之魔童降世"},{"title":"银河补习班"},{"title":"烈火英雄"},{"title":"鼠胆英雄"},{"title":"掌上明珠"}]},{"title":"即将上映","childs":[{"title":"复仇者联盟4"},{"title":"好莱坞往事"},{"title":"疾速备战"},{"title":"千与千寻"},{"title":"魔女"}]},{"title":"Top250","childs":[{"title":"何以为家"},{"title":"我不是药神"},{"title":"白蛇:缘起"},{"title":"流浪地球"},{"title":"探险旅行"}]},{"title":"口碑榜","childs":[{"title":"绝杀慕尼黑"},{"title":"大护法"},{"title":"企鹅公路"},{"title":"绿皮书"},{"title":"海蒂和爷爷"}]},{"title":"北美票房榜","childs":[{"title":"学生的妈妈2"},{"title":"疾速特攻"},{"title":"蜘蛛侠:英雄远征"},{"title":"陈翔六点半之重楼别"},{"title":"命运之夜\u2014\u2014天之杯:恶兆之花"}]},{"title":"新片榜","childs":[{"title":"犯罪都市"},{"title":"逃出绝命镇"},{"title":"浪矢解忧杂货店"},{"title":"妈阁是座城"},{"title":"小丑回魂"}]}]
     */

    private int code;
    private String message;
    private List<CategoryBean> category;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CategoryBean> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryBean> category) {
        this.category = category;
    }

    public static class CategoryBean {
        /**
         * title : 正在上映
         * childs : [{"title":"哪吒之魔童降世"},{"title":"银河补习班"},{"title":"烈火英雄"},{"title":"鼠胆英雄"},{"title":"掌上明珠"}]
         */

        private String title;
        private List<ChildsBean> childs;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ChildsBean> getChilds() {
            return childs;
        }

        public void setChilds(List<ChildsBean> childs) {
            this.childs = childs;
        }

        public static class ChildsBean {
            /**
             * title : 哪吒之魔童降世
             */

            private String title;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
