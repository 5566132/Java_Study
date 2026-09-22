package TCP_;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.UUID;

public class Socket1 {
    public static void main(String[] a) throws IOException {
        InetAddress my_ip = InetAddress.getByName("127.0.0.1");
        int port = 10086;
        Socket socket = new Socket(my_ip, port);
        OutputStream os = socket.getOutputStream();
        Scanner sc = new Scanner(System.in);
        String str = new String();
        while(true){
            str = sc.next();
            os.write(str.getBytes());
            if(str.equals("886")){
                break;
            }
        }
        os.close();





    }
}
