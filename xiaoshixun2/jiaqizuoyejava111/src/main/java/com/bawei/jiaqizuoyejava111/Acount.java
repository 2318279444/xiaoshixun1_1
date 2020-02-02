package com.bawei.jiaqizuoyejava111;

/*
 *@auther:邓先超
 *@Date: 2020/1/17
 *@Time:20:05
 *@Description:
 **/
public class Acount {
    int id;
    String name;
    int money;

    public Acount(int id, String name, int money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public Acount() {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void savemoney(){
        money+=1000;
    }

    public void withDrawMoney(){
        money-=500;

    }

    @Override
    public String toString() {
        return "Acount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
