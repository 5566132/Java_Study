package Interface2;

import java.lang.annotation.Target;

public class Main {
    static void main() {
        Integer a = new Integer(1);
        System.out.println(System.identityHashCode(a));
        a = 1;
        System.out.println(System.identityHashCode(a));
        a = 9999;
        System.out.println(System.identityHashCode(a));
        a = 9999;
        System.out.println(System.identityHashCode(a));

        System.out.println(a);

        System.identityHashCode(a);
        System.out.println("\n\n\n");
        System.out.println("传递之前地址是: " + System.identityHashCode(a));
        work1(a);



    }

    public static void work1(Integer a){
        System.out.println("以下作为参数传递, 看地址是什么");
        System.out.println(System.identityHashCode(a));
        a = 878;
        System.out.println("给a重新赋值, 看看地址是什么: " + System.identityHashCode(a));
    }
}
