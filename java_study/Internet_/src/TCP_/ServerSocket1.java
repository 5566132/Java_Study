package TCP_;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket1 {
    public static void main(String[] aa) throws IOException {
        int port = 10086;
        ServerSocket ss = new ServerSocket(port);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        byte[] data = new byte[4];
        String str;
        while(true){
            int len = is.read(data);
            str = new String(data, 0, len);
            System.out.println(str);
            if(str.equals("886")){
                break;
            }
        }

        is.close();
        socket.close();





    }
}
