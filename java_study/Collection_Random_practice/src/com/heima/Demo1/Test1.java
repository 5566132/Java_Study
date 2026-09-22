package com.heima.Demo1;

import java.util.ArrayList;
import java.util.Collections;

public class Test1 {
    public static void main(String[] args){
        ArrayList<String> arr = new ArrayList<>();
        Collections.addAll(arr, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        int cnt = 0;
        while(cnt++ <= 10){
            System.out.println("===========================");
            System.out.println("  第 " + cnt + " 次");
            ArrayList<String> temp = new ArrayList<>();
            Collections.shuffle(arr);
            while(!arr.isEmpty()){
                System.out.println(arr.getFirst());
                temp.add(arr.getFirst());
                arr.removeFirst();
            }
            arr.addAll(temp);
        }





    }


}
