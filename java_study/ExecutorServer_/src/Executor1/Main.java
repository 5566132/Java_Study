package Executor1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        T1();
    }

    static void T1() throws InterruptedException {
        //ExecutorService sb = Executors.newCachedThreadPool();
        ExecutorService sb = Executors.newFixedThreadPool(2);
        //Thread t1 = new Thread(new myThread());
        //t1.setName("线程1");

        sb.submit(new myThread());
        //Thread.sleep(10);
        sb.submit(new myThread());
        //Thread.sleep(10);
        sb.submit(new myThread());
        //Thread.sleep(10);
        sb.submit(new myThread());






    }
}













