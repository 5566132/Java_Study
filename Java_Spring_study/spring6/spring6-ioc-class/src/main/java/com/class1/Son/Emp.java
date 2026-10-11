package com.class1.Son;

public class Emp {
    private String name;
    private int age;
    private Dept dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void work() {
        System.out.println();
        System.out.println("开始调用Emp的work方法");
        System.out.println("此员工的Dept = " + dept.getName());
        System.out.println("emp... work");
        dept.info();
        System.out.println("结束调用work方法");
        System.out.println();
    }






    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("姓名是: " + name + "   年龄是: " + age + "    部门是: " + dept.getName());
        return sb.toString();
    }

}
