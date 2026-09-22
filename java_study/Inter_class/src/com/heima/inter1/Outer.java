package com.heima.inter1;

public class Outer {
    private int age;

    Outer() {
        Outer.this.age = 0;

    }

    Outer(int age) {
        this.age = age;
    }

    public class Inter1 {
        public String name;

        public void show() {
            System.out.println(name);
        }
    }

    //私有的内部类
    private class Inter2 implements Interface_show {
        public String name;

        Inter2() {
            name = "空";
        }

        Inter2(String name) {
            this.name = name;
        }

        @Override
        public void show() {
            System.out.println(name);
        }
    }

    //无参创建私有内部类
    public Inter2 createInter2() {
        return new Inter2();
    }

    public Inter2 createInter2(String name) {
        return new Inter2(name);
    }


}
