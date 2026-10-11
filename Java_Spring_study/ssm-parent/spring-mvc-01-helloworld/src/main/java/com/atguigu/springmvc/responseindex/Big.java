package com.atguigu.springmvc.responseindex;

import java.util.Arrays;

public class Big {
    private String username;
    private Integer age;
    private boolean isStudent;
    private Integer[] arr;
    private Te cl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setisStudent(boolean student) {
        isStudent = student;
    }

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    public Te getCl() {
        return cl;
    }

    public void setCl(Te cl) {
        this.cl = cl;
    }

    @Override
    public String toString() {
        return "Big{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", isStudent=" + isStudent +
                ", arr=" + Arrays.toString(arr) +
                ", cl=" + cl +
                '}';
    }
}

//{
//        "username":"你好",
//        "age":20,
//        "isStudent":true,
//        "arr":["12", 13],
//        "cl":{
//        "age":"12",
//        "name":"小子"
//        }
//        }