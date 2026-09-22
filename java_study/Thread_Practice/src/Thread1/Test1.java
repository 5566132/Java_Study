package Thread1;

import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        //T1();
        T2();
        Random r = new Random();
        double n = r.nextDouble(100);
        double temp = Math.round(n*100)/100.0;
        System.out.printf("%f    %f    %.2f\n", n, temp, n);


    }

    static void T1() {
        Red r1 = new Red(100, "线程1");
        Red r2 = new Red(30, "线程22");
        r1.start();
        r2.start();
    }
    static void T2(){
        Red2 r1 = new Red2(100, "线程1");
        Red2 r2 = new Red2(30, "线程22");
        Red2 r3 = new Red2(100, "线程333");
        Red2 r4 = new Red2(30, "线程4444");
        Red2 r5 = new Red2(30, "线程55555");
        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r5.start();

    }
}
