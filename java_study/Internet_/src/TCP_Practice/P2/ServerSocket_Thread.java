package TCP_Practice.P2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ServerSocket_Thread extends Thread implements Runnable{
    Socket socket;
    ServerSocket_Thread(){
        super();
    }
    ServerSocket_Thread(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + "  开始复制");
        int port = 10000;
        String name = UUID.randomUUID().toString().replace("-", "");
        File f = new File("D:\\A_java\\java_study\\Internet_\\src\\TCP_Practice\\P2\\photo\\" + name + ".png");
        InputStream is;
        try {
            is =  socket.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedInputStream bis = new BufferedInputStream(is);
        //创建输入流, 复制照片
        FileOutputStream fis;
        try {
            fis = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedOutputStream bos = new BufferedOutputStream(fis);

        byte[] by = new byte[1024];
        int len;
        while (true) {
            try {
                if ((len = bis.read(by)) != -1){
                    bos.write(by, 0, len);
                }else{
                    System.out.println(Thread.currentThread().getName() + "    结束复制");
                    bos.close();
                    socket.close();
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }

}
