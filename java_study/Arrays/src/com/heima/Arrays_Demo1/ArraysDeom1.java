package com.heima.Arrays_Demo1;
import java.util.Arrays;
import java.util.Comparator;

public class ArraysDeom1 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 20, 30};
        System.out.println(Arrays.toString(arr));
        System.out.println("---------------  ");
        int n = Arrays.binarySearch(arr, 10);
        System.out.println(n);
        int[] newarr = new int[]{1, 2, 9, 0, 1};
        System.out.println(Arrays.toString(newarr));
        Arrays.fill(newarr, 0);
        System.out.println(Arrays.toString(newarr));


        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new CMP());
        System.out.println(Arrays.toString(arr));


    }

    static class CMP implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }



}
