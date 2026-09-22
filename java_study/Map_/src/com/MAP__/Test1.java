package com.MAP__;

import java.util.*;

public class Test1 {
    public static void main(String[] args){
        HashMap<String, String> map = new HashMap<>();
        map.put("1号", "111");
        map.put("9号", "999");
        map.put("2号", "222");
        map.put("8号", "888");
        map.put("6号", "666");
        Set<Map.Entry<String, String>> en = map.entrySet();
        int i;
        for(Map.Entry<String, String> temp : en){
            System.out.println(" Key = " + temp.getKey() + "     Value = " + temp.getValue());
        }
        System.out.println();

        Map.Entry<String, String>[] m_en = en.toArray(new Map.Entry[0]);
        System.out.println();
        for(i=0;i<m_en.length;i++){
            System.out.println(" Key = " + m_en[i].getKey() + "     Value = " + m_en[i].getValue());
        }
        System.out.println();
        System.out.println();

        Map<String, String> can_change = Map.ofEntries(m_en);
        for(Map.Entry<String, String> temp : can_change.entrySet()){
            System.out.println(" Key = " + temp.getKey() + "     Value = " + temp.getValue());
        }










    }
}
