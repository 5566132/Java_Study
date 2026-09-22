package myThread1;
//用Rannable接口实现
public class Sum2 implements Runnable {
    @Override
    public void run(){
        int sum = 0;
        int i;
        for(i=0;i<100;i++){
            sum+=i;
        }
        System.out.println(Thread.currentThread().getName() + "     sum = " + sum);
    }
}
