package base;

/*
 *@auther:邓先超
 *@Date: 2020/3/16
 *@Time:8:37
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
