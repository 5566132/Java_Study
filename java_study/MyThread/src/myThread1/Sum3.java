package myThread1;

import java.util.concurrent.Callable;

public class Sum3 implements Callable<Integer> {
    @Override
    public Integer call(){
        int i;
        int sum = 0;
        for(i=0;i<10;i++){
            sum += i;
        }
        return sum;
    }
}
