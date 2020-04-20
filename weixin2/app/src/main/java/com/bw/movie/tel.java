package com.bw.movie;

public class tel {
    public static void main(String[] args) {
        int[] arr=new int[]{8,2,1,0,3};
        int[] index =new int []{2,0,3,2,4,0,1,3,2,3,3};

        String tel="";

        for(int i:index){
            tel+=arr[i];
        }

        System.out.println("电话:"+tel);



        int[] arrmp={1,3,2,6,5,4,9,8,7};
        System.out.print("冒泡排序:");

        for (int i = 0; i < arrmp.length ; i++) {
            for (int j = 0; j < arrmp.length - i; j++) {
                if(arrmp[j]>arrmp[j+1]){
                    int temp=arrmp[j];
                    arrmp[j]=arrmp[j+1];
                    arrmp[j+1]=temp;
                }
            }
            System.out.print(+arrmp[i]+",");
        }





    }

}
