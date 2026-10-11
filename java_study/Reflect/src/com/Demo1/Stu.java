package com.Demo1;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Stu {
    public String name;
    private int age;


    public Stu() {
        name = null;
        age = 0;
    }
    public Stu(String name) {
        this.name = name;
    }

    private Stu(int age) {
        this.age = age;
    }

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sum(int... a) {
        int i;
        int sum = 0;
        for (i = 0; i < a.length; i++) {
            sum += a[i];
        }
    }

    public void eat(String name){
        System.out.println("吃 : " + name);
    }
    public void eat(String name, int time) throws IOException, InterruptedException {
        System.out.println("--------");
        LocalDateTime ldt1 = LocalDateTime.now();
        int sum  = 0;
        for(int i = 0; i < time ; i++){
          if(i%2==0){
              sum += i;
          }else{
              sum-=i;
          }
        }
        System.out.println("sum = " + sum);
        //Thread.sleep(1000);
        LocalDateTime ldt2 = LocalDateTime.now();
        System.out.println("吃 " + time + " 次 " + name + " 用时: " + ChronoUnit.MILLIS.between(ldt1, ldt2));
    }

    private String eat(int time){
        System.out.println("这个是私有的, 有一个参数的构造, 返回 SHIT");
        return "SHIT";
    }

    private String eat() throws IOException {
        System.out.println(" 这个是私有的空参的方法, 会抛出IO异常,  返回字符串  666");
        return "666";
    }











}
