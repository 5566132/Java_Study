package com.heima.Generic_;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class Test1 {
    public static void main(String[] args){
        Collection<Integer> arr = new ArrayList<>();
        Iterator<Integer> it = arr.iterator();






        BigInteger b1 = BigInteger.valueOf(1);
        b1 = b1.add(b1);
        b1 = b1.multiply(b1);
        b1 = b1.subtract(BigInteger.ONE);
        b1 = b1.pow(2);
        b1.pow(3);
        b1 = b1.mod(BigInteger.TEN);
        System.out.println(b1);


        HSk h1 = new HSk("哈士奇 1 号 ", 99);
        HSk h2 = new HSk("哈士奇 2 号 ", 10);
        HSk h3 = new HSk("哈士奇 3 号 ", 9999);
        BScat b11 = new BScat("波斯猫 1 号 ", 1);
        BScat b2 = new BScat("波斯猫 2 号 ", 1111111);
        BScat b3 = new BScat("波斯猫 3 号 ", 33333);
        ArrayList<Animal> a1 = new ArrayList<>();
        a1.add(h1);
        a1.add(h2);
        a1.add(b11);
        a1.add(b2);
        ArrayList<Cat> a2 = new ArrayList<>();
        a2.add(b11);
        a2.add(b2);
        a2.add(b3);
        ArrayList<Dog> a3 = new ArrayList<>();
        a3.add(h1);
        a3.add(h2);
        a3.add(h3);
        keepAnimal(a1);
        //keepCat(a1);
        keepDog(a3);
        keepCat(a2);




    }

    //所有动物
    public static void keepAnimal(ArrayList<? extends Animal> arr){
        int i;
        ListIterator it = arr.listIterator();
        System.out.println(" 查看所有动物  ");
        while(it.hasNext()){
            Animal temp = (Animal)it.next();
            temp.eat();
        }
        System.out.println(" 结束 \n" );
    }


    //只能猫
    public static void keepCat(ArrayList<? extends Cat> arr){
        int i;
        System.out.println("  查看所有小猫  ");
        for(Cat c : arr){
            c.eat();
        }
        System.out.println("   结束   \n");


    }

    //只能狗
    public static void keepDog(ArrayList<? extends Dog> arr){
        int i;
        System.out.println("  遍历所有狗  ");
        for(i=0;i<arr.size();i++){
            arr.get(i).eat();
        }
        System.out.println("  结数  \n");



    }

    public static void keep(An1<Animal> arr){

    }



}
