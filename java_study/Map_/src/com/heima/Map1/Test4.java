package com.heima.Map1;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Test4 {
    public static void main(String[] args){
        TreeMap<Stu, Integer> m = new TreeMap<>(new Comparator<Stu>() {
            @Override
            public int compare(Stu a, Stu b){
                return a.age - b.age;
            }
        });
        m.put(new Stu("1号", 10), 1);
        m.put(new Stu("2号", 20), 2);
        m.put(new Stu("3号", 1), 0);
        m.put(new Stu("4号", -99), -888);
        m.put(new Stu("1号", 10), 99999999);

        for(Map.Entry<Stu, Integer> e : m.entrySet()) {
            System.out.println(" name = " + e.getKey().name + "     age = " + e.getKey().age + "         int = " + e.getValue());
        }
        for(Integer s : m.values()){
            System.out.println("  value  = " + s);
        }
        Map.ofEntries(m.entrySet().toArray(new Entry[0]));

        Set<Map.Entry<Stu, Integer>> s1 = m.entrySet();
        Map.Entry<Stu, Integer>[] me1 = s1.toArray(new Entry[0]);





    }
}
