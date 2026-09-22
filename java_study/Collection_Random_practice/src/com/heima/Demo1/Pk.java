package com.heima.Demo1;

import java.util.*;

public class Pk {
    static HashMap<String, Integer> m;
    static ArrayList<String> pai;
    public static void init(){
        m = new HashMap<String, Integer>();
        pai = new ArrayList<String>();
        String[] h = new String[]{"♥", "♠", "♦", "♣"};
        String[] num = new String[]{"A", "2", "3", "4","5", "6", "7", "8","9", "10", "J", "Q","K"};
        int i;

        for(i=0;i<num.length;i++){
            int j;
            for(j=0;j<h.length;j++){
                m.put(h[j] + num[i], i*4 + j + 1);
            }
        }
        m.put("Small-Joker", 53);
        m.put("Big-Joker", 54);
    }

    static void initpai(){
        pai.clear();
        for(Map.Entry<String, Integer> e : m.entrySet()){
            pai.add(e.getKey());
        }
        Collections.shuffle(pai);
    }




}
