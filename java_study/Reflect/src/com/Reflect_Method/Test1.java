package com.Reflect_Method;

import com.Demo1.Stu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Test1 {
    static void main() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Stu s1 = new Stu();
        Class c1 = s1.getClass();
        Method m1 = c1.getDeclaredMethod("eat", String.class, int.class);

        //
        int modifier1 = m1.getModifiers();
        Class<?> r1 = m1.getReturnType();
        String name1 = m1.getName();
        Parameter[] p1 = m1.getParameters();
        Class<?>[] e1 = m1.getExceptionTypes();
        System.out.print(modifier1 + "  " + r1 + "  " +  name1 + "  ");
        for(Parameter temp : p1){
            System.out.print(temp + "  ");
        }
        for(Class temp : e1){
            System.out.print(temp + "  ");
        }
        System.out.println();

        m1.invoke(s1, "答辩", 100000000);










    }
}
