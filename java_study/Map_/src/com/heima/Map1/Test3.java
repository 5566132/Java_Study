package com.heima.Map1;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class Test3 {
    public static void main(String[] args){
        Random r = new Random();
        HashMap<Integer, Integer> m = new HashMap<>();
        int i;

        int cnt = 0;
        int[] a = new int[]{0,0,0,0,0};
        while(cnt < 80){
            int se = r.nextInt(1, 5);
            a[se]++;
            if(m.containsKey(se)){
                m.put(se, m.get(se) + 1);
            }else{
                m.put(se, 1);
            }
            cnt++;
        }

        System.out.println("------------  ");
        for(i=1;i<=4;i++){
            System.out.println("i = " + i + "     value = " + a[i]);
        }
        System.out.println("------------  ");
        for(Map.Entry<Integer, Integer> en : m.entrySet()){
            System.out.println(" key = " + en.getKey() + "          value = " + en.getValue());
        }



    }
}
