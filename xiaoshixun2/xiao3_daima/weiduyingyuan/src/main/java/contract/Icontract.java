package contract;

/*
 *@auther:邓先超
 *@Date: 2020/2/26
 *@Time:14:21
 *@Description:
 **/
public interface Icontract {
    public interface ToCall{
        void success(String stra);
    }

    public interface ToBannerCall{
        void seccess(Object o);
    }
}
