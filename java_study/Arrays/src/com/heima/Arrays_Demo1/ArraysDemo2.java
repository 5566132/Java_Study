package com.heima.Arrays_Demo1;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysDemo2 {
    public static void main(String[] args){
        Integer[] a = new Integer[]{1,3,7,10,99,13};
        Integer[] b = Arrays.copyOf(a,a.length);
        b[0] = 999999;
        System.out.println(Arrays.toString(a));
        //Integer[] c = Arrays.copyOf(a, 10);
        Stu[] s1 = new Stu[5];
        s1[0] = new Stu(3,10);
        s1[1] = new Stu(3,2);
        s1[2] = new Stu(6,20);
        s1[3] = new Stu(6, 10);
        s1[4] = new Stu(1, 5);
        //System.out.println(Arrays.toString(s1));

        Arrays.sort(b,(A,B)->{return A - B;});
        System.out.println(Arrays.toString(b));
        show(s1);
        //Lamdba表达式书写sort
        Arrays.sort(s1,(c1,c2)->{
            if(c1.getId() == c2.getId()){
                return c1.getAge() - c2.getAge();
            }
            return c1.getId() - c2.getId();
        });
        //匿名内部类
        Arrays.sort(s1, new Comparator<Stu>(){
            @Override
            public int compare(Stu a, Stu b){
                if(a.getId() == b.getId()){
                    return b.getAge() - a.getAge();
                }
                return b.getId() - a.getId();
            }
        });



        show(s1);
        //copy是浅拷贝
        Stu[] s2 = Arrays.copyOf(s1,s1.length);
        s2[0].setId(999);
        show(s1);








    }
    public static void show(Stu[] a){
        System.out.println();
        int i;
        for(i=0;i<a.length;i++){
            a[i].show();
        }
    }
}
