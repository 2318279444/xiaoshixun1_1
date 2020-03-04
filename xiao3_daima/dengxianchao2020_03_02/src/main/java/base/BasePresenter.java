package base;

/*
 *@auther:邓先超
 *@Date: 2020/3/2
 *@Time:13:07
 *@Description:
 **/
public class BasePresenter<V extends BaseAcitivity> {
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
