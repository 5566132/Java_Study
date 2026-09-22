package Thread1;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Red extends Thread{
    static int num = 100;
    static Lock l = new ReentrantLock();
    Random r = new Random();
    Red(){
        super();
    }
    Red(int num, String name){
        super(name);
        this.num = num;
    }
    @Override
    public void run(){
        while(true){

            try{
                l.lock();
                if(num > 0){
                    Thread.sleep(10);
                    //int n = r.nextInt(1, num + 1);
                    int n = 1;
                    num -= n;
                    System.out.println(Thread.currentThread().getName() + " 抢了: " + n + " 元       还剩: " + num + " 元");
                }else{
                    break;
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally{
                l.unlock();
            }
        }



    }




}
