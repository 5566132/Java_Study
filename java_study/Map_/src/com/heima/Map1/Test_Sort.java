package com.heima.Map1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Test_Sort {
    public static void main(String[] args){
        ArrayList<Stu> arr = new ArrayList<>();
        arr.add(new Stu("3号", 10));
        arr.add(new Stu("1号", 1));
        arr.add(new Stu("9号", 99));
        arr.add(new Stu("0号", -888));
        arr.add(new Stu("333号", 10000000));
        arr.add(new Stu("3号", 10));
        arr.sort(new Comparator<Stu>(){
            @Override
            public int compare(Stu a, Stu b){
                return a.age - b.age;
            }
        });
        for(Stu s : arr){
            System.out.println("name = " + s.name + "      age = " + s.age);
        }









    }
}
