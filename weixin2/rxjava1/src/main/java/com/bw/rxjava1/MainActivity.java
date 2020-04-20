package com.bw.rxjava1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity {

    private Subscriber<String> mSubscriber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RxAndroid的基本使用
//        RxAndroidBase();
        //RxAndroid接收一个集合对象,对其中数据一个一个观察
        RxAndroidFrmo();
        //RxAndroid接收一个集合对象,对整个集合进行操作
        RxAndroidJust();
        //RxAndroid接收一个集合对象,对其中数据进行过滤
        RxAndroidFilterStream();
        //RxAndroid接收一个集合对象,对其中数据进行转换
        RxAndroidMapStream();
        //RxAndroid把拿到的数个集合,进行拆分观察
        RxAndroidFlatMap();

    }




    private void RxAndroidBase() {
        //创建被观察者,注意:这里不要用成java包下的,而是要用rx包下的类
        //参数是一个对象,泛型代表了要发送(观察)的数据类型
        Observable<String> stringObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override//这里的subscriber ,就是你在下面注册的subscriber对象
            public void call(Subscriber<? super String> subscriber) {
                //开始发送的事件,执行的逻辑相当于上一个例子Account中的setMoney方法
                subscriber.onNext("易宸锋");
                //当被观察者,观察结束时,回调的方法
//                subscriber.onCompleted();
                subscriber.onNext("yichenfeng");
                subscriber.onNext("易天嚎");
                //当被观察者有异常时,调用的方法
                subscriber.onError(new Throwable());
                subscriber.onNext("ycf");
            }
        });

        //创建观察者
        mSubscriber = new Subscriber<String>() {
            //该方法在所有事件开始时回调,可用可不用
            @Override
            public void onStart() {
                super.onStart();
            }

            //该方法在被观察者发送变化时回调
            @Override
            public void onNext(String s) {
                System.out.println("onNext : " + s + "脸皮乃天下第一防御型神器");
            }

            //该方法有异常回调
            //注意:一旦这个方法执行了,就代表观察出现问题,其他两个回调方法,及时在下面还有调用,也不会执行了
            @Override
            public void onError(Throwable e) {
                System.out.println("onError : " + e);
            }

            //当所有事件观察完毕的,回调,事件序列结束标记
            //注意:一旦这个方法执行了,就代表观察结束,其他两个回调方法,及时在下面还有调用,也不会执行了
            @Override
            public void onCompleted() {
                System.out.println("onCompleted : ");
            }
        };
        //把观察者注册到被观察身上,只要一有这段代码,Observable.create下的call方法就会执行
        stringObservable.subscribe(mSubscriber);

    }

    private void RxAndroidFrmo() {
        //创建一个集合,并装上数据
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        //创建被观察者,注意:这里不要用成java包下的,而是要用rx包下的类
        //参数是一个集合,使用这种方式,会根据集合的数量调用对应次数的subscriber.onNext方法,把集合中的数据一个一个输出
        Observable.from(integers)
                //被观察者一创建就指定了观察者,如此就不用在后面进行注册绑定了
                //如果用不到onError,onCompleted方法,就创建Action1 ,其中的call == onNext
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println("onNext : " + integer);
                    }
                });
    }

    //RxAndroid接收一个集合对象,对整个集合进行操作
    private void RxAndroidJust() {
        //创建一个集合,并装上数据
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        //创建被观察者,注意:这里不要用成java包下的,而是要用rx包下的类
        //参数是一个集合,使用这种方式,会把这个集合整个输出一次
        Observable.just(integers)
                //被观察者一创建就指定了观察者,如此就不用在后面进行注册绑定了
                //如果用不到onError,onCompleted方法,就创建Action1 ,其中的call == onNext
                .subscribe(new Action1<List<Integer>>() {
                    @Override
                    public void call(List<Integer> integers) {
                        System.out.println(integers);
                    }
                });
    }

    private void RxAndroidFilterStream() {
        //创建一个集合,并装上数据
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        //创建被观察者,注意:这里不要用成java包下的,而是要用rx包下的类
        //参数是一个集合,使用这种方式,会根据集合的数量调用对应次数的subscriber.onNext方法,把集合中的数据一个一个输出
        Observable.from(integers)
                //对集合数据进行过滤,只发送符合条件的事件
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        return integer < 4;
                    }
                })
                //如果用不到onError,onCompleted方法,就创建Action1 ,其中的call == onNext
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println("onNext : " + integer);
                    }
                });
    }


    private void RxAndroidMapStream() {
        //创建一个集合,并装上数据
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        //创建被观察者,注意:这里不要用成java包下的,而是要用rx包下的类
        //参数是一个集合,使用这种方式,会根据集合的数量调用对应次数的subscriber.onNext方法,把集合中的数据一个一个输出
        Observable.from(integers)
                //对集合数据进行转换,参数 1.代表了原数据类型(转换前)  2.代表了要转换最终结果的数据类型(转换后)
                //提示:可以把流转换成bitmap,文件,String...    把String字符串或数据库Cursor转换为Bean类等
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return integer.toString();
                    }
                })
                //如果用不到onError,onCompleted方法,就创建Action1 ,其中的call == onNext
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }

    //把拿到的集合,进行拆分观察
    private void RxAndroidFlatMap() {
        //创建一个集合,并装上数据
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> integers1 = Arrays.asList(6, 7, 8);
        List<Integer> integers2 = Arrays.asList(9, 10);
        //创建被观察者,注意:这里不要用成java包下的,而是要用rx包下的类
        //参数是一个集合,使用这种方式,会把这个集合整个输出一次
        Observable.just(integers, integers1, integers2)//这里会输出3次,但经过修改要他发送10次
                //这样使用,以后可以减少双层for循环
                .flatMap(new Func1<List<Integer>, Observable<?>>() {
                    //将一个数据再转变为一个观察者
                    @Override
                    public Observable<?> call(List<Integer> integers) {
                        return Observable.from(integers);
                    }
                })
/*              .subscribe(new Action1<List<Integer>>() {
                    @Override
                    public void call(List<Integer> integers) {
                        System.out.println(integers);
                    }
                });*/
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        System.out.println(o);
                    }
                });
    }

    @Override
    protected void onStop() {
        super.onStop();
        //当观察者对象不为空,且处于正在观察的状态中,可以解除观察
//        if(mSubscriber != null && !mSubscriber.isUnsubscribed())
//            mSubscriber.unsubscribe();
    }


    public void scheduler(View view) {
    }
}

