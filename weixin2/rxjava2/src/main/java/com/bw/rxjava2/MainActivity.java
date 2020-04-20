package com.bw.rxjava2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private android.widget.ImageView ImageView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView =  findViewById(R.id.imageView);
        mButton = (Button) findViewById(R.id.button);

        //使用RxAndroid做线程间的通讯,线程调度器
        RxAndroidThread();

        //RxAndroid防止按钮短时间内被重复点击多次,进行限制
        RxAndroidClick();
    }

    private void RxAndroidThread() {
        //注意:这里用到了SD卡,记得加一下权限
        Observable.just(Environment.getExternalStorageDirectory().getAbsolutePath() + "/1576035899720.jpg")
                //加载的是字符串,转换为Bitmp对象
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String s) {
                        //打印线程所在名称
                        String Threadname = Thread.currentThread().getName();
                        System.out.println("Func1的call所在线程名称 : " + Threadname);

                        Bitmap bitmap = BitmapFactory.decodeFile(s);
                        return bitmap;
                    }
                })
                //该方法决定了Func1的call方法(被观察者执行逻辑)运行在哪个线程
                // IO:线程名称RxIoScheduler-2(子线程,内部用到了一个线程池)
                .subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())//可以执行多次,对不同数据,在不同的线程中调用
                //该方法决定了 Action1的call方法(观察者执行逻辑)运行在哪个线程  mainThread:主线程
                .observeOn(AndroidSchedulers.mainThread())//只能执行一次,多次调用,以第一次为基准
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                        //打印线程所在名称
                        String Threadname = Thread.currentThread().getName();
                        System.out.println("Action1的call所在线程名称 : " + Threadname);
                        ImageView.setImageBitmap(bitmap);
                    }
                });
    }

    private void RxAndroidClick() {
/*        mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("我被点击了");
                }
            });*/

        //设置按钮规定时间内,有效的点击
        Observable.create(new MyOnSubscribe(mButton))
                //参数:1.设置规定时间的int型数字  2.设置时间的单位值,这里是秒
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(new Action1<View>() {
                    @Override
                    public void call(View view) {
                        //当点击有效的业务逻辑
                        System.out.println("我在call方法中,我被点击了,有反应了");
                    }
                });
    }

    //创建View的接口形式
    class MyOnSubscribe implements Observable.OnSubscribe<View> {

        public MyOnSubscribe(View view) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("我被狂点中...");

                    //发布通知
                    mSubscriber.onNext(view);

                }
            });
        }

        private Subscriber mSubscriber;

        @Override
        public void call(Subscriber<? super View> subscriber) {
            mSubscriber = subscriber;
        }
    }

}
