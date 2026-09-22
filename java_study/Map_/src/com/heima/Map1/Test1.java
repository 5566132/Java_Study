package com.heima.Map1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test1 {
    public static void main(String[] args){
        Map<String, String> m = new HashMap<>();
        m.put("9号", "( 1 )号");

        m.put("2号", "( 2 )号");
        m.put("3号", "( 3 )号");
        for(Map.Entry<String, String> s1 : m.entrySet()){
            System.out.println("key = " + s1.getKey() + "         value = " + s1.getValue());
        }










    }
}
