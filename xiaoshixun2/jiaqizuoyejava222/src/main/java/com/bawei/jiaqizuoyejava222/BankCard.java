package com.bawei.jiaqizuoyejava222;

/*
 *@auther:邓先超
 *@Date: 2020/1/20
 *@Time:12:14
 *@Description:
 **/
public class BankCard {
    String name;
    int carId;
    int yue;

    public BankCard(String name, int carId, int yue) {
        this.name = name;
        this.carId = carId;
        this.yue = yue;
    }

    public BankCard() {
        this.name = name;
        this.carId = carId;
        this.yue = yue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getYue() {
        return yue;
    }

    public void setYue(int yue) {
        this.yue = yue;
    }

    public void show(){
        System.out.println("name:"+name+"carId:"+carId+"yue:"+yue);
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "name='" + name + '\'' +
                ", carId=" + carId +
                ", yue=" + yue +
                '}';
    }
}
