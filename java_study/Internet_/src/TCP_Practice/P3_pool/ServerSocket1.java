package TCP_Practice.P3_pool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.*;

public class ServerSocket1 {
    public static void main(String[]args) throws IOException, InterruptedException {
        int port = 10000;
        ServerSocket ss = new ServerSocket(port);
        Socket socket;
        int cnt = 1;
        String name = "线程";
        int i;
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
            3,
            6,
            60,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
        );

        while(true){
            String temp = new String(name);
            for(i=0;i<cnt;i++){
                temp += ("" + cnt);
            }
            socket = ss.accept();
            Thread t1 = new Thread(new SST(socket));
            t1.setName(temp);
            pool.submit(t1);
        }









    }
}
