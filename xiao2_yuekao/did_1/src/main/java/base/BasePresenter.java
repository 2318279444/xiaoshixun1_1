package base;

/*
 *@auther:邓先超
 *@Date: 2020/2/17
 *@Time:13:47
 *@Description:
 **/
public abstract class BasePresenter<V extends BaseFragment> {
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
