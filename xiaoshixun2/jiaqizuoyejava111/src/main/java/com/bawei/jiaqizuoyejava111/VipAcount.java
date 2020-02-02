package com.bawei.jiaqizuoyejava111;

import android.util.Log;

/*
 *@auther:邓先超
 *@Date: 2020/1/17
 *@Time:20:16
 *@Description:
 **/
public class VipAcount extends Acount {
    public VipAcount(int id, String name, int money) {
        super(id, name, money);
    }


    public void bigWithDrawMoney(){
        Acount acount = new Acount();
        if(money>5000){
            Log.e("aaa",""+"取款成功");
        }else {
            Log.e("aaa",""+"余额不足");
        }
    }
}
