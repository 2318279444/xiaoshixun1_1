package adapter.ShouyeAdapter;

/*
 *@auther:邓先超
 *@Date: 2020/3/14
 *@Time:15:08
 *@Description:
 **/
public class m {
    public static void main(String[] args) {
        int [] arr={1,3,2,6};

        for (int i = 0; i <arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j+1]>arr[j]){
                    int t=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=t;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }
    }
}
