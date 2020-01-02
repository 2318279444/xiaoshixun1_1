package com.bawei.day1231;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei.bean.Mybean;
import com.bawei.database.MybeanDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.insert)
    Button insert;
    @BindView(R.id.del)
    Button del;
    @BindView(R.id.update)
    Button update;
    @BindView(R.id.selecte)
    Button selecte;
    @BindView(R.id.text)
    TextView text;
    private MybeanDao mybeanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mybeanDao = MyApp.getDaosession().getMybeanDao();

    }

    @OnClick({R.id.insert, R.id.del, R.id.update, R.id.selecte})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.insert:
                List<Mybean> list=new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    Mybean st = new Mybean("小刘", "男");
                    list.add(st);
                }
                mybeanDao.insertInTx(list);

                break;
            case R.id.del:
                mybeanDao.deleteByKey((long) 2);
                break;
            case R.id.update:
                Mybean load = mybeanDao.load((long) 3);
                load.setName("小刘刘");
                load.setSex("女");
                mybeanDao.update(load);

                break;
            case R.id.selecte:
                text.setText(mybeanDao.loadAll().toString());
                break;
        }
    }
}
