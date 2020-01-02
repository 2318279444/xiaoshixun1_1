package com.bawei.shujuku1_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei.shujuku1_3.database.MybeanDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.insert)
    Button insert;
    @BindView(R.id.delete)
    Button delete;
    @BindView(R.id.update)
    Button update;
    @BindView(R.id.selete)
    Button selete;
    @BindView(R.id.text)
    TextView text;
    private MybeanDao mybeanDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mybeanDao = MyApp.getQwe().getMybeanDao();
    }

    @OnClick({R.id.insert, R.id.delete, R.id.update, R.id.selete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.insert:
                Mybean mybean = new Mybean(1l, "小米", "男");
                mybeanDao.insert(mybean);
                break;
            case R.id.delete:

                break;
            case R.id.update:


                break;
            case R.id.selete:

                List<Mybean> list=mybeanDao.queryBuilder().list();

                for (int i = 0; i < list.size(); i++) {
                    Toast.makeText(this,list.get(i).name+list.get(i).sex,Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
