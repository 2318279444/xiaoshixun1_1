package base;

/*
 *@auther:邓先超
 *@Date: 2020/3/7
 *@Time:13:01
 *@Description:
 **/
public class BasePresenter<V extends BaseFragment> {
    public V v;

    public void attach(V v){
        this.v=v;
    }

    public void unattach(){
        if(v!=null){
            v=null;
        }
    }
}
