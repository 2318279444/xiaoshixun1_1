package base;
/*
 * 时间2020.4.14
 * name:邓先超
 * 功能:
 *
 * */
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
