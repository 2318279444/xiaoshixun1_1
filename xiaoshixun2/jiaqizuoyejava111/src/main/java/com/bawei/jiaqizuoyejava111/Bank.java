package com.bawei.jiaqizuoyejava111;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/*
 *@auther:邓先超
 *@Date: 2020/1/17
 *@Time:20:28
 *@Description:
 **/
public class Bank extends Acount{
    Double sum=0.00;

    List<String> list=new ArrayList<>();




    public void openAccount(){

        Acount acount1 = new Acount();
        acount1.savemoney();


        Acount acount = new Acount(1001,"张三",1000);
        Acount acount2 = new Acount(1002,"李四",6001);
        System.out.println(acount);
        System.out.println(acount2);

    }



    public void openAccount2(){

        Acount acount1 = new Acount();
        acount1.savemoney();
        Acount acount = new Acount(1001,"张三",2000);
        Acount acount2 = new Acount(1002,"李四",7001);
        System.out.println(acount);
        System.out.println(acount2);

    }

    public void openAccount3(){

        Acount acount1 = new Acount();
        acount1.savemoney();


        Acount acount = new Acount(1001,"张三",5000);
        Acount acount2 = new Acount(1002,"李四",5501);
        System.out.println(acount);
        System.out.println(acount2);

    }


}
