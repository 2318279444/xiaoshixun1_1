package com.bawei.jiaqizuoyejava222;

/*
 *@auther:邓先超
 *@Date: 2020/1/20
 *@Time:12:17
 *@Description:
 **/
public class BankCardmain {
    public static void main(String[] args) {
        BankCard bankCard = new BankCard("张三",1001,10000);
        BankCard bankCard2 = new BankCard("张三",1001,10000);
        BankCard bankCard3 = new BankCard("张三",1001,10000);

        System.out.println(bankCard);
        System.out.println(bankCard2);
        System.out.println(bankCard3);

    }
}
