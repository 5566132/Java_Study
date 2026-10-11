package com.atguige;

public class User {
    private String name;
    private Integer age;
    public User(){
        this(null, null);
        System.out.println("无参构造");
    }
    public User(String name,  Integer age){
        this.name = name;
        this.age = age;
        System.out.println("有参构造");
    }
    public void setName(String name){
        this.name = name;
        System.out.println("set Name");
    }
    public void setAge(Integer age){
        this.age = age;
        System.out.println("set Age");
    }
    public String getName(){
        return name;
    }
    public Integer getAge(){
        return age;
    }



    public void run() {
        System.out.println("run.......");
    }

}
