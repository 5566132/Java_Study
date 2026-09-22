package Socket_;

import java.io.IOException;
import java.net.*;

public class Receive1 {
    public static void main(String[] a) throws IOException {

        DatagramSocket ds = new DatagramSocket(10086);
        byte[] b1 = new byte[1024];
        int len;
        int port = 10086;
        InetAddress ip = InetAddress.getByName("127.0.0.1");

        DatagramPacket dp = new DatagramPacket(b1, b1.length);
        ds.receive(dp);

        //解包
        byte[] data = dp.getData();
        len = dp.getLength();
        String str = new String(data, 0, len);
        ip = dp.getAddress();
        port = dp.getPort();


        System.out.println("接收到数据: " + str);
        System.out.println("从ip: " + ip + "     发送端从这个端口发送:" + port);

        ds.close();





    }
}
