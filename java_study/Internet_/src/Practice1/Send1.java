package Practice1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Send1 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        int destination_port = 10086;
        InetAddress my_ip = InetAddress.getByName("127.0.0.1");
        Scanner sc = new Scanner(System.in);
        String say = new String();
        byte[] B1;
        while(true){
            say = sc.next();
            B1 = say.getBytes();
            DatagramPacket dp = new DatagramPacket(B1, B1.length, my_ip, destination_port);
            ds.send(dp);
            if(say.equals("886")){
                break;
            }
        }
        ds.close();






    }
}
