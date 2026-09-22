package Executor1;

public class myThread implements Runnable{
    @Override
    public void run(){
        int i = 0;

        //for(i=0;i<1;i++){
            System.out.println("   ====  " + Thread.currentThread().getName() + "  ========  " + i);
        //}
    }
}
