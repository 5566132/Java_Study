package com.Demo1;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Get_Member_Variable {
    static void main() throws NoSuchFieldException, IllegalAccessException {
        Stu s1 = new Stu("zhangsan", 999);
        Class c1 = s1.getClass();
        Field age = c1.getDeclaredField("age");
        System.out.println(age);

        Class<?> cc = age.getType();
        System.out.println(cc);




        age.setAccessible(true);

        int a1 = (int) age.get(s1);
        String member_name = age.getName();
        //System.out.println(a1 + " " + member_name);

        int modifier = age.getModifiers();
        age.set(s1, 8888888);
        a1 = (int)age.get(s1);
        System.out.println("权限是: " + modifier + "    类型是: " + cc + "     名字是: " + member_name + "      值是: " + a1);












        




    }
}
