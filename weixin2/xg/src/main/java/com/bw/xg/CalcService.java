package com.bw.xg;

import android.os.SystemClock;

/*
 *@auther:邓先超
 *@Date: 2020/3/30
 *@Time:10:03
 *@Description:
 **/
public class CalcService {
    //默认值
    int result;

    /**
     * 计算每个人能分多少个西瓜
     * total:西瓜的数量  200
     * pCount:人的数量   10
     * result:每个人分多少个西瓜  20个西瓜
     */
    public int calc(final int total,final int pCount){
        //如果是一个非常复杂的算法,那么是一个耗时的操作,那么我要放到子线程去处理
        //开了一个子线程
        new Thread(){
            public void run() {
                //让这个子线程睡了两秒钟
                SystemClock.sleep(2000);
                //okhttp或者Retrofit都已经封装好了,所以我不用管
                //数据库的大量查询,大文件的读取,复杂的计算公式
                //那一个数字除以另一个数字,把值赋给了Result
                result = total / pCount;
            };
        }.start();
        return result;
    }

    public int calcSynchronization(final int total,final int pCount){
        new Thread(){
            public void run() {
                //让这个子线程睡了两秒钟
                SystemClock.sleep(2000);
                //okhttp或者Retrofit都已经封装好了,所以我不用管
                //数据库的大量查询,大文件的读取,复杂的计算公式
                //那一个数字除以另一个数字,把值赋给了Result
                result = total / pCount;
            };
        }.run();
        return result;
    }

    public void calcAsync(final int total, final int pCount, final OnResultListener object){
        new Thread(){
            public void run() {
                //让这个子线程睡了两秒钟
                SystemClock.sleep(2000);
                //那一个数字除以另一个数字,把值赋给了Result
                result = total / pCount;
                //进行接口的回调
                object.onSuccess(result);
            };
        }.start();
    }

    public interface OnResultListener{
        void onSuccess(int result);

        void onFail();
    }
}
