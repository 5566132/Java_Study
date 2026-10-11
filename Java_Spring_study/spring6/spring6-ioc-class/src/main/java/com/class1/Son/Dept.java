package com.class1.Son;

import java.util.List;

public class Dept {
    private String name;
    private Emp[] emp_array;
    private List<Emp> emp_list;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("调用了Dept的设置name方法, name = " + name);
    }

    public Emp[] getEmp_array() {
        return emp_array;
    }

    public void setEmp_array(Emp[] emp_array) {
        this.emp_array = emp_array;
    }

    public List<Emp> getEmp_list() {
        return emp_list;
    }

    public void setEmp_list(List<Emp> emp_list) {
        this.emp_list = emp_list;
    }

    public void info() {
        System.out.println("调用了Dept的info方法");
        System.out.println("部门名称: " + name);
        //System.out.println(emp_array.toString());
        int i;
        if(emp_array != null){
            for(i=0;i<emp_array.length;i++){
                System.out.println(emp_array[i]);
            }
        }
        //System.out.println(emp_list.toString());
    }

}
