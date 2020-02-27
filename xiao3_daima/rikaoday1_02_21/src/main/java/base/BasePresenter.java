package base;

/*
 *@auther:邓先超
 *@Date: 2020/2/26
 *@Time:16:28
 *@Description:
 **/
public class BasePresenter<V extends BaseFragment> {
    public V v;

    public void attach(V v){
        this.v=v;
    }

    //解决内存泄漏
    public void unattach(){
        if(v!=null){
            v=null;
        }
    }
}
