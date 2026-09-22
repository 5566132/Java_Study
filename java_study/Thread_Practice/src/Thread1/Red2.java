package Thread1;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Red2 extends Thread {
    static int num = 100;
    static Lock l = new ReentrantLock();
    Random r = new Random();

    static int count = 3;
    Red2() {
        super();
    }
    Red2(int num, String name) {
        super(name);
        this.num = num;
    }

    @Override
    public void run() {
            try {
                l.lock();
                if (num > 0) {
                    int n;
                    if(count > 1){
                        count--;
                        n = r.nextInt(1, num + 1);
                    }else{
                        n = num;
                    }
                    num -= n;
                    System.out.println(Thread.currentThread().getName() + " 抢了: " + n + " 元       还剩: " + num + " 元");
                } else {
                    System.out.println(Thread.currentThread().getName() + " 没抢到");
                }
            }finally {
                l.unlock();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
    }


}
