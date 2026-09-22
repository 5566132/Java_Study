package ARR;
import java.util.Scanner;
public class T1 {
    public static void main(String[] args){
        int arr[] = new int[]{3,2,1,0};
        System.out.println(arr);
        int i;
        for(i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        for(;i<10;i++){
            arr[i] = i+3;
        }


    }
}
