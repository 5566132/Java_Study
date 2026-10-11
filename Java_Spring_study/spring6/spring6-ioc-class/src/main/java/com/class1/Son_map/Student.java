package com.class1.Son_map;

import org.springframework.aop.scope.ScopedProxyUtils;

import java.util.List;
import java.util.Map;

public class Student {
    private String name;
    private int age;
    Map<String, Teacher> m;
    List<Teacher> l;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Teacher> getM() {
        return m;
    }

    public void setM(Map<String, Teacher> m) {
        this.m = m;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Teacher> getL() {
        System.out.println("调用了对List的get");
        return l;
    }

    public void setL(List<Teacher> l) {
        System.out.println("调用了对List的set");
        this.l = l;
    }

    public void work(){
        System.out.println("name = " + name + "    age = " + age);
        System.out.println("展示map");
        if(m == null){
            System.out.println("Map是null");
        }else{
            for(Map.Entry<String, Teacher> temp : m.entrySet()){
                System.out.println("key = " + temp.getKey() + "        name = " + temp.getValue().getName() + "          age = " + temp.getValue().getAge());
            }
        }

        System.out.println("展示list");
        if(l == null){
            System.out.println("List是null");
        }else{
            for(int i = 0;i<l.size();i++){
                System.out.println(l.get(i).getName() + "  " + l.get(i).getAge());
            }
        }

        System.out.println();


    }



}
