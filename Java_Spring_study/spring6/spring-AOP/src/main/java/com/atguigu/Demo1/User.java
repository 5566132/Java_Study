package com.atguigu.Demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("u1")
public class User {

    @Value("10000")
    private int age;

    public void run1(){
        System.out.println();
        System.out.println("User内部的run1方法");
    }

    public int run2(){
        System.out.println();
        System.out.println("run2执行, 这个会有返回值");
        return age;
    }

    protected void run3(){
        System.out.println();
        System.out.println("run3 保护, void 方法");
    }
    private int run4(){
        System.out.println();
        System.out.println("run4 私有, int返回值, age = " + age);
        return age;
    }

    public void run5_exception(){
        System.out.println();
        System.out.println("run5 接下来我要用0当除数计算了");
        System.out.println(2/0);
    }

    public int run6_exception(){
        System.out.println();
        System.out.println("run6 接下来我要用0当除数计算了");
        System.out.println(2/0);
        return age;
    }


}
