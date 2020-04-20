package base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
 *@auther:邓先超
 *@Date: 2020/2/24
 *@Time:13:14
 *@Description:
 **/
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(inilayout());

        iniview();

        indata();
    }

    protected abstract void indata();

    protected abstract void iniview();

    protected abstract int inilayout();
}
