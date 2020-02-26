package contract;

import com.bawei.dengxianchao2020218.dao.MyDao;

import bean.DingdanBean;

/*
 *@auther:邓先超
 *@Date: 2020/2/18
 *@Time:9:20
 *@Description:
 **/
public interface Icontract {
    public interface ToCall{
        void success(String stra);
    }

    public interface Toreg{
        void success();
    }

    public interface ToPic{
        void success(DingdanBean dingdanBean);
    }
}
