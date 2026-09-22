package Lock_;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread_Lock3 extends Thread{
    static int SUM = 0;
    MyThread_Lock3(String name){
        super(name);
    }

    static Lock l = new ReentrantLock();
    @Override
    public void run(){
        while(true){
            l.lock();
            try{
                if(SUM < 100){
                    Thread.sleep(10);
                    SUM++;
                    System.out.println(Thread.currentThread().getName() + "    SUM = " + SUM);
                }else{
                    break;
                }
            }catch(InterruptedException e){

            }finally{
                l.unlock();
            }
        }


    }
}
