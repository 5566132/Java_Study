package Lock_;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ManyThread();
        Have_Lock();
        Have_Lock2();
        Have_Lock3();


    }
    //多线程竞争共有变量问题
    static void ManyThread() throws InterruptedException {
        MyThread mt1 = new MyThread("线程1");
        MyThread mt2 = new MyThread("线程22");
        Lock l1 = new ReentrantLock();
        mt1.start();
        mt2.start();
        mt1.join();
        mt2.join();
        System.out.println(MyThread.SUM);
    }
    //加锁
    static void Have_Lock() throws InterruptedException {
        MyThread_Lock m1 = new MyThread_Lock("线程1");
        MyThread_Lock m2 = new MyThread_Lock("线程2");
        m1.start();
        m2.start();
        m1.join();
        m2.join();
        System.out.println(MyThread_Lock.SUM);
    }
    //加锁
    static void Have_Lock2() throws InterruptedException {
        MyThread_Lock2 m1 = new MyThread_Lock2("线程1");
        MyThread_Lock2 m2 = new MyThread_Lock2("线程2");
        m1.start();
        m2.start();
        m1.join();
        m2.join();
        System.out.println(MyThread_Lock2.SUM);
    }
    static void Have_Lock3() throws InterruptedException {
        MyThread_Lock3 m1 = new MyThread_Lock3("线程1");
        MyThread_Lock3 m2 = new MyThread_Lock3("线程22");
        MyThread_Lock3 m3 = new MyThread_Lock3("线程333");

        m1.start();
        m2.start();
        m3.start();
        m1.join();
        m2.join();
        m3.join();
        System.out.println(MyThread_Lock3.SUM);
    }

}
