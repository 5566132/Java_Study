package com.class1;

import com.class1.Son.Emp;
import com.class1.Son_map.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    @Test
    public void run(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Emp e1 = (Emp)context.getBean("emp1");
        e1.work();
        //System.out.println(e1.getDept().getName());


    }

    @Test
    public void run_map(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_map.xml");
        Student s1 = (Student)context.getBean("student1");
        s1.work();


    }

    @Test
    public void Map_List(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_map_util.xml");
        Student s1 = (Student)context.getBean("stu1");
        s1.work();
    }

    @Test
    public void Map_List_util_p(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_map_util_p.xml");
        Student s1 = (Student)context.getBean("stu2");
        s1.work();
    }


}
