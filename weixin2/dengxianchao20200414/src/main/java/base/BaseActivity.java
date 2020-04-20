package base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
* 时间2020.4.14
* name:邓先超
* 功能:
*
* */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(inilayout());

        iniview();

        inidata();

    }

    protected abstract void inidata();


    protected abstract void iniview();


    protected abstract int inilayout();

}
