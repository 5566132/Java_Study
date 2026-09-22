package com.heima.Arrays_Demo1;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Random;
public class Sort_Demo1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int n = r.nextInt(2,7);
        String[] arr = new String[n];
        String add;
        int i;
        int length;

        System.out.println("  n = " + n);

        for(i=0;i<n;i++){
            length = r.nextInt(1,10);
            add = new String();
            int j;
            StringBuilder sb = new StringBuilder();
            for(j=0;j<length;j++){
                sb.append('a');
            }
            add = sb.toString();
            arr[i] = add;
        }

        System.out.println("开始的时候, 字符串数组是: " + Arrays.toString(arr));

        show(arr);

        //Lambda升序排列
        Arrays.sort(arr, (com1, com2)->{return com1.length() - com2.length();});
        System.out.println("升序排列, 字符串数组是: ");
        show(arr);
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String com1, String com2){
                return (com2.length() - com1.length());
            }
        });
        System.out.println("降序排完, 字符串数组是: ");
        show(arr);






    }
    public static void show(String[] a){
        System.out.println();
        int i;
        for(i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        System.out.println();
    }
}
