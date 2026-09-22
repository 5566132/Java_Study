package com.itheima;

public class Test3 {
    public static void main(String[] args){
        int i;
        Stu[] s = new Stu[3];
        s[0] = new Stu("111");
        s[1] = new Stu("222");
        s[2] = new Stu("333");
        Per[] p = new Per[3];
        System.arraycopy(s,0, p, 0, 3);
        s[0].name = "9jdjiwdwan";

        for(i=0;i<s.length;i++){
            System.out.println(s[i].name);
        }
        for(i=0;i<p.length;i++){
            Per temp = p[i];
            System.out.println(p[i].name);
        }
        for(i=0;i<p.length;i++){
            Stu temp = (Stu)p[i];
            System.out.println(temp.name);
        }






    }
}
