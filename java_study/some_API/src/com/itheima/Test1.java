package com.itheima;
import java.util.ArrayList;

public class Test1{
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(9);
        arr.add(8);
        arr.add(7);
        ArrayList<Integer> arr2 = new ArrayList<>(3);
        int[] a = new int[]{9,8,7};
        int[] b = new int[3];
        System.arraycopy(a, 1, b, 0, 2);
        int i;
        for(i=0;i<b.length;i++){
            System.out.println(b[i] + " ");
        }

    }

}
