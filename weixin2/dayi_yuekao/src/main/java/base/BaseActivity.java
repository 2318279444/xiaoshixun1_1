package base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public P p;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(inilayout());
        p=Ipresenter();
        if(p!=null){
            p.attach(this);
        }

        iniview();

        inidata();


    }

    protected abstract int inilayout();
    protected abstract P Ipresenter();

    protected abstract void inidata();

    protected abstract void iniview();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(p!=null){
            p.unattach();
            p=null;
        }
    }
}
