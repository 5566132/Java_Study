package Lock_;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread_Lock2 extends Thread{
    static int SUM = 0;

    MyThread_Lock2(String name){
        super(name);
    }
    static Lock l = new ReentrantLock();
    @Override
    public void run(){
        int i;
        for(i=0;i<10000;i++){
            l.lock();
            SUM++;
            l.unlock();
        }
    }

}
