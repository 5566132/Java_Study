package Practice1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive1 {
    public static void main(String[] args) throws IOException {
        int receive_port = 10086;
        DatagramSocket ds = new DatagramSocket(receive_port);
        byte[] b1 = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b1, b1.length);
        byte[] packet;
        int len;
        String out;
        while(true){
            //建立接收通道, 或者说是接收
            ds.receive(dp);
            //信息都存储在dp内部了
            packet = dp.getData();
            len = dp.getLength();
            out = new String(packet, 0, len);
            if(out.equals("886")){
                System.out.println(" 结束了 ");
                break;
            }else{
                System.out.println(out);
            }
        }


        ds.close();




    }
}
