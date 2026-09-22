package myThread1;

public class MyThread extends Thread{
    MyThread(){
        super();
    }
    MyThread(String name){
        super(name);
    }

    static int ALL = 0;
    @Override
    public void run(){
        int i;
        int sum = 0;
        for(i=0;i<10;i++){
            sum += i;
            ALL += i;
            System.out.println(Thread.currentThread().getName() + " @ " + i);
        }
        //System.out.println(Thread.currentThread().getName() + "    sum = " + sum);
        //System.out.println(Thread.currentThread().getName() + "    ALL = " + ALL);
    }
}
