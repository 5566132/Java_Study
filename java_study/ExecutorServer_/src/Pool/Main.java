package Pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] a) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,
                6,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        int i;
        for(i=0;i<20;i++){
            //Thread t = new Thread(new myThread());
            //pool.submit(t);
            pool.submit(new myThread());
            Thread.sleep(100);
        }



    }
}
