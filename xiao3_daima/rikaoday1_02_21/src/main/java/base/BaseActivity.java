package base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/*
 *@auther:邓先超
 *@Date: 2020/2/26
 *@Time:16:28
 *@Description:
 **/
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(inilayout());
        iniview();
        inidata();
    }

    protected abstract void iniview();

    protected abstract void inidata();


    protected abstract int inilayout();
}