package Socket_;

import java.io.IOException;
import java.net.*;

public class Send1 {
    public static void main(String[] a) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        String se = "这都是什么呀?";
        byte[] b1 = se.getBytes();
        int port = 10086;
        InetAddress ip = InetAddress.getByName("127.0.0.1");

        //           字节数据  数据长度    发送到的ip   发送到的端口号
        //这一步相当于把要发送的数据打包
        DatagramPacket dp = new DatagramPacket(b1, b1.length, ip, port);


        ds.send(dp);
        ds.close();





    }


}
