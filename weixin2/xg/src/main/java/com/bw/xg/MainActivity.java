package com.bw.xg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * 同步:A调用B,B处理直到获得结果,才返回给A
 * 需要调用者一直等待和确认调用结果是否返回,然后继续往下执行
 * 异步:A调用B,无需等待结果,B通过状态通知A回调函授来处理,滴啊用具结果返回时,会议回调的形式通知调用者
 *
 * 同步交互:指发送一个请求,需要等待返回,然后才能够发送下一个请求,有一个等待过程
 * 异步交互:指发送一个请求,不需要等待返回的结果,随时可以在发送下一个请求
 * 一运行,就点击按钮,result的值是多少 , 74.2.74的我就不面试了,他们从哪里来回哪里去?
 *
 * 接口回调可以解决这个问题,RxJava也可以解决这个问题,而且处理起来更加的方便
 * 因为RXjava采用的是观察者的设计模式,具备三大功能:观察者,操作符对数据进行过滤,线程的切换
 * 你们做过购物车
 */
public class MainActivity extends AppCompatActivity {
    CalcService calcService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.创建计算工具类对象
        calcService = new CalcService();
    }

    public void clickListener(View view){
//        getResult();

        //异步回调的方法
        getResultAsync();

    }

    private void getResultAsync() {
        calcService.calcAsync(1780, 24, new CalcService.OnResultListener() {
            @Override
            public void onSuccess(int result) {
                System.out.println("每个人分"+result+"西瓜");
            }

            @Override
            public void onFail() {
            }
        });
    }

    private void getResult() {
        int result = calcService.calcSynchronization(1780, 24);
        System.out.println("每个人分"+result+"西瓜");

    }
}
