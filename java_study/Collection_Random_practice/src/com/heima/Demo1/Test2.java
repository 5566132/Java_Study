package com.heima.Demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class Test2 {
    public static void main(String[] args){
        HashMap<String, ArrayList<String>> m = new HashMap<>();
        int i;
        Random r = new Random();
        String[][] s1 = new String[3][];
        for(i=0;i<3;i++){
            int n = r.nextInt(1, 8);
            int j;
            s1[i] = new String[n];
            ArrayList<String> temp = new ArrayList<>();
            for(j=1;j<=n;j++){
                s1[i][j - 1] = ("" + ((i + 1)*10 + j));
                temp.add(s1[i][j - 1]);
            }
            m.put((i + 1) + "", temp);
        }


        for(Map.Entry<String, ArrayList<String>> en : m.entrySet()){
            System.out.print(en.getKey() + ":  ");
            for(i=0;i<en.getValue().size();i++){
                System.out.print(en.getValue().get(i) + " ");
            }
            System.out.println();
        }




    }
}
