package com.Demo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class myReflect2 {
    static void main() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c1 = Stu.class;
        Constructor[] con1 = c1.getConstructors();
        for(Constructor temp : con1){
            System.out.println(temp);
        }
        Constructor con2 = c1.getConstructor();
        Constructor con3 = c1.getConstructor(String.class);
        System.out.println(con2);
        System.out.println(con3);
        System.out.println("\n\n---------------");
        Constructor[] con4 = c1.getDeclaredConstructors();
        for(Constructor temp : con4){
            System.out.println(temp);
        }
        System.out.println("\n\n--------------------\n\n");
        Constructor con5 = c1.getDeclaredConstructor(String.class, int.class);
        int mo = con5.getModifiers();
        System.out.println(mo);

        for(Parameter pa : con5.getParameters()){
            System.out.println("-------");
            System.out.println(pa);
            System.out.println(pa.getName());
            System.out.println("-------");
        }

        Stu s1 = (Stu)con2.newInstance();
        con5.setAccessible(true);
        Stu s2 = (Stu)con5.newInstance("iii", 99);




        //Constructor con6 = c1.getConstructor(String.class);
    }
}
