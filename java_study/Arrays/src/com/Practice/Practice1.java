package com.Practice;
import java.util.*;
public class Practice1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int n = r.nextInt(4,10);
        System.out.println(" n = " + n);
        int i;
        char[] st = new char[26];
        for(i=0;i<st.length;i++){
            st[i] = (char)('a' + i);
        }
        Girl[] arr = new Girl[n];
        for(i=0;i<n;i++){
            Girl temp = new Girl();
            arr[i] = temp;
        }
        //先随机age
        for(i=0;i<n;i++){
            int age = r.nextInt(1,5);
            arr[i].age = age;
        }
        //随机身高
        for(i=0;i<n;i++){
            int height = r.nextInt(1,5);
            arr[i].height = height;
        }
        //随机姓名
        for(i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            int len = r.nextInt(1,7);
            int j;
            for(j=0;j<len;j++){
                int se = r.nextInt(0,st.length);
                sb.append(st[se]);
            }
            arr[i].name = sb.toString();
        }
        System.out.println("初始化完成, 展示: ");
        show(arr);

        //自定义排序规则
        //Lambda 升序
        Arrays.sort(arr, (com1, com2)->{
            if(com1.age == com2.age){
                if(com1.height == com2.height){
                    int j;
                    for(j=0;j<Math.min(com1.name.length(), com2.name.length());j++){
                        char c1 = com1.name.charAt(j);
                        char c2 = com2.name.charAt(j);
                        if(c1 != c2){
                            return c1 - c2;
                        }
                    }
                    return 0;
                }
                return com1.height - com2.height;
            }
            return com1.age - com2.age;
        });
        System.out.println("  升序完成, 输出: ");
        show(arr);










    }
    public static void show(Girl[] a){
        System.out.println();
        int i;
        for(i=0;i<a.length;i++){
            System.out.println(" age = " + a[i].age + "       height = " + a[i].height + "           name = " + a[i].name);
        }
        System.out.println();
    }

}
