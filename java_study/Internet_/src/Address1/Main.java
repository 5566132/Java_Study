package Address1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("LAPTOP-G5UR8BLG");
        System.out.println(address);
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());


    }
}
