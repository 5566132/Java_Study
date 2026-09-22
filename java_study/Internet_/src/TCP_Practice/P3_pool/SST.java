package TCP_Practice.P3_pool;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

import static java.lang.System.*;

public class SST implements Runnable{
    Socket socket;
    SST(){
        super();
    }
    SST(Socket s){
        super();
        socket = s;
    }

    @Override
    public void run(){

        try {
            out.println(Thread.currentThread().getName() + "  开始复制");
            int port = 10000;
            String name = UUID.randomUUID().toString().replace("-", "");
            File f = new File("D:\\A_java\\java_study\\Internet_\\src\\TCP_Practice\\P2\\photo\\" + name + ".png");
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            //创建输入流, 复制照片
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));

            byte[] by = new byte[1024];
            int len;
            while ((len = bis.read(by)) != -1){
                bos.write(by, 0, len);
            }
            out.println(Thread.currentThread().getName() + "    结束复制");
            bos.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
