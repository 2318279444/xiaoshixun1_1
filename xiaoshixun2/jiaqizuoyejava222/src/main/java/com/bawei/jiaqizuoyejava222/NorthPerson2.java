package com.bawei.jiaqizuoyejava222;

/*
 *@auther:邓先超
 *@Date: 2020/1/20
 *@Time:12:20
 *@Description:
 **/
public class NorthPerson2 extends Person2{
    String name;
    int age;

    public NorthPerson2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public NorthPerson2() {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "NorthPerson2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    public void eat(){
        System.out.println("北方人吃面");
    }




}
