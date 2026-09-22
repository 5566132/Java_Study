package com.heima.inter1;

public class Test1 {
    public static void main(String[] args){
        Outer o = new Outer(9999);
        Outer.Inter1 i1 = o.new Inter1();
        i1.name = "public内部类的姓名展示";
        i1.show();
        //o.Inter1 i11 = o.new Inter1();

       // o.createInter2().name = "ddddd";
    Interface_show obj = o.createInter2("private内部类的姓名展示");
    obj.show();
    obj.t1();

    }
}
