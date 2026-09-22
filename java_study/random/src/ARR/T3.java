package ARR;

import java.util.Random;
import java.util.Scanner;
public class T3 {
    public static int abb;


    public static void main(String[] args){
        int a[] = new int[]{0,1,2,3,4,5,6,7,8,9};
        Scanner sc = new Scanner(System.in);
        int begin, end;
        begin = sc.nextInt();
        end = sc.nextInt();
        int b[] = newarr(a,begin, end);
        int i;
        for(int it : b){
            System.out.print(it + " ");
        }
        System.out.print('\n');





    }
    public static int[] newarr(int[] a, int begin, int end){
        int ret[] = new int[end - begin + 1];
        int i;
        for(i=begin;i<=end;i++) {
            ret[i - begin] = a[i];
        }
        return ret;
    }






}
