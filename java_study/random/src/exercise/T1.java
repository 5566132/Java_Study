package exercise;
import java.util.Scanner;
public class T1 {
    public static void main(String[]args){
        int se;
        Scanner sc = new Scanner(System.in);
        se = sc.nextInt();
        int a[] = get(se);
        encryption(a);
        int i;
        for(i=0;i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.print("\n");
        reget(a);
        for(i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
        System.out.print('\n');



    }
    public static int[] get(int x){
        int temp = x;
        int cnt = 0;
        while(temp > 0){
            temp/=10;
            cnt++;
        }

        int ret[] = new int[cnt];

        while(x > 0){
            cnt--;
            int t = x%10;
            x/=10;
            ret[cnt] = t;
        }

        return ret;
    }
    public static void encryption(int a[]){
        int i;
        for(i=0;i<a.length;i++){
            a[i] = (a[i] + 5)%10;
        }
        for(i=0;i<a.length/2;i++) {
            int temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
    }
    public static void reget(int a[]){
        int i;
        for(i=0;i<a.length/2;i++){
            int temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
        for(i=0;i<a.length;i++){
            a[i] += 10;
            a[i] -=5;
            a[i] %=10;
        }
    }



}
