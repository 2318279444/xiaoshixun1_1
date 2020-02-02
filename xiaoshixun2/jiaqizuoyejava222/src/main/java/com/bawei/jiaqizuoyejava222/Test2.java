package com.bawei.jiaqizuoyejava222;

/*
 *@auther:邓先超
 *@Date: 2020/1/20
 *@Time:12:27
 *@Description:
 **/
public class Test2 {
    public static void main(String[] args) {
        SouthPerson2 southPerson = new SouthPerson2();
        SouthPerson2 southPerson1 = new SouthPerson2("张三",20);
        SouthPerson2 southPerson2 = new SouthPerson2("张三",20);
        SouthPerson2 southPerson3 = new SouthPerson2("张三",20);

        NorthPerson2 northPerson = new NorthPerson2();
        NorthPerson2 northPerson1 = new NorthPerson2("李四",19);
        NorthPerson2 northPerson2 = new NorthPerson2("李四",19);
        NorthPerson2 northPerson3 = new NorthPerson2("李四",19);


        System.out.println(northPerson1);
        System.out.println(northPerson1);
        System.out.println(northPerson1);
        System.out.println(southPerson1);
        System.out.println(southPerson1);
        System.out.println(southPerson1);


        southPerson.eat();

        northPerson.eat();
    }
}
