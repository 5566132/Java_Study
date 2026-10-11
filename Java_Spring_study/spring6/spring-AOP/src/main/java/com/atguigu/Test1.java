package com.atguigu;

import com.atguigu.Demo1.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ObjectInputFilter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test1 {

    @Test
    public void run() throws InvocationTargetException, IllegalAccessException {
        ApplicationContext con = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ccc =
        User temp = (User)con.getBean("u1");

        Class c1 = User.class;
        Method[] m1 = c1.getDeclaredMethods();
        int cnt = 1;
        for(Method te : m1){
            if(!te.getDeclaringClass().equals(User.class)){
                continue;
            }

            te.setAccessible(true);
            if(te.getParameterCount() == 0){
                System.out.println("\n\n\n cnt = " + cnt);
                System.out.println(te.getName());
                te.invoke(temp);
                cnt++;
            }
        }




    }
}
