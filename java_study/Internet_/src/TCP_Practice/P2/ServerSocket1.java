package TCP_Practice.P2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ServerSocket1 {
    public static void main(String[]args) throws IOException, InterruptedException {
        int port = 10000;
        ServerSocket ss = new ServerSocket(port);
        Socket socket;
        int cnt = 1;
        String name = "线程";
        int i;
        while(true){
            String temp = new String(name);
            for(i=0;i<cnt;i++){
                temp += (cnt + "");
            }
            Thread.sleep(9000);


            ServerSocket_Thread sst = new ServerSocket_Thread(temp);
            sst.socket = ss.accept();
            sst.start();
            cnt++;
        }





    }
}
