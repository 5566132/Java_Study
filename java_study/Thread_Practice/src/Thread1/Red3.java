package Thread1;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Red3 extends Thread {
    static int num = 100;
    static Lock l = new ReentrantLock();
    Random r = new Random();

    static int count = 3;
    Red3() {
        super();
    }
    Red3(int num, String name) {
        super(name);
        this.num = num;
    }

    @Override
    public void run() {
        while(true){
            l.lock();
            if(num > 0){
                num--;
            }else{
                l.unlock();
                break;
            }
            l.unlock();
        }


    }


}
