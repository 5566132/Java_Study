package ARR;
import java.util.Scanner;
import java.util.Random;
public class T2 {
    public static void main(String[] args){
        int arr[] = new int[]{1,2,3,4,5,6};
        int i;
        Random r = new Random();

        for(i=0;i<arr.length;i++){
            int sign = r.nextInt(0,arr.length);
            int temp = arr[i];
            arr[i] = arr[sign];
            arr[sign] = temp;
        }
        for(i=0;i<arr.length;i++){
            System.out.println(arr);
        }





    }
}
