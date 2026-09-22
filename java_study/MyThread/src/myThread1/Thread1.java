package myThread1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Thread1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //try_Sum1();
        //try_Sum2();
        //try_Sum3();
        //Thread_Method();
        //Thread t1 = Thread.currentThread();
        //System.out.println(t1.getName());
        MyThread mt = new MyThread("土豆 ");
        mt.start();
        mt.join();
        int i;





        for(i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + " @ " + i);
        }



    }
    static void try_Sum1(){
        MyThread s1 = new MyThread();
        s1.setName("线程1");
        MyThread s2 = new MyThread();
        s2.setName("线程22");

        s1.start();
        s2.start();
    }
    static void try_Sum2(){
        Sum2 s1 = new Sum2();
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s1);
        t1.setName("线程333");
        t2.setName("线程4444");
        t1.start();
        t2.start();
        Thread t3 = new Thread(new Sum2(){
            @Override
            public void run(){
                System.out.println("用匿名内部类去重写run以便生态更丰富");
            }
        });
        t3.start();


    }
    static void try_Sum3() throws ExecutionException, InterruptedException {
        Sum3 s1 = new Sum3();
        FutureTask<Integer> f1 = new FutureTask<>(s1);
        Thread t1 = new Thread(f1);
        t1.start();
        System.out.println("这里的: " + f1.get());
    }
    static void Thread_Method(){
        MyThread t1 = new MyThread("飞机");
        t1.start();

    }




}
