package com.heima.Map1;

import java.util.Objects;

public class Stu implements Comparable<Stu>{
    public String name;
    public int age;

    Stu() {
        this(null, 0);
    }

    Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object a) {
        Stu temp = (Stu) a;
        if (temp.name.equals(this.name) && temp.age == this.age) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.age);
    }

    @Override
    public int compareTo(Stu a){
        return this.age - a.age;
    }


}
