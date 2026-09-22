package TCP_Practice.P2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Socket1 {
    public static void main(String[] args) throws IOException {
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        int port = 10000;
        Socket socket = new Socket(ip, port);
        File f = new File("D:\\A_java\\java_study\\Internet_\\src\\TCP_Practice\\P1\\屏幕截图 2026-09-15 084654.png");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
        OutputStream is = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(is);
        int len;
        while((len = bis.read()) != -1) {
            bos.write(len);
        }
        bis.close();
        socket.close();





    }
}
