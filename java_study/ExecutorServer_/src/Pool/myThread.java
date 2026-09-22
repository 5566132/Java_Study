package Pool;

public class myThread implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());


    }
}
