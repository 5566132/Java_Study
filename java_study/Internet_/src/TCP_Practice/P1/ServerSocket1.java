package TCP_Practice.P1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ServerSocket1 {
    public static void main(String[]args) throws IOException {
        int port = 10000;
        ServerSocket ss = new ServerSocket(port);
        Socket socket = ss.accept();
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        int len;
        String name = UUID.randomUUID().toString().replace("-", "");

        File f = new File("D:\\A_java\\java_study\\Internet_\\src\\TCP_Practice\\P1\\" + name + ".png");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
        while((len = bis.read()) != -1){
            bos.write(len);
        }
        bis.close();
        bos.flush();
        bos.close();
        socket.close();





    }
}
