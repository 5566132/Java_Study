package com.heima.Map1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Test2 {
    public static void main(String[] args){
        Map<Stu, String> m = new HashMap<>();

        m.put(new Stu("9号", 11), "河北");
        m.put(new Stu("2号", 22), "记得外单位");
        m.put(new Stu("3号", 33), "急急急急急急急急急");
        m.put(new Stu("9号", 11), " 八卦 ");

        for(Map.Entry<Stu, String> s1 : m.entrySet()){
            System.out.println(" name = " + s1.getKey().name + "      age = " + s1.getKey().age + "           籍贯 = " + s1.getValue());
        }

        for(Stu key : m.keySet()){
            System.out.println(key.name + "    " + key.age);
        }

        m.forEach(new BiConsumer<Stu, String>(){
            @Override
            public void accept(Stu a, String b){
                System.out.println(" name = " + a.name + "      age = " + a.age + "           籍贯 = " + b);
            }
        });










    }
}
