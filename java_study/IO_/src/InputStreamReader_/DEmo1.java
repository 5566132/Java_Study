package InputStreamReader_;

import java.io.*;
import java.nio.charset.Charset;

public class DEmo1 {
    public static void main(String[] args) throws IOException {
        //我先用字节流使用UFT-8读看能读到什么
        File f = new File("D:\\A_java\\java_study\\IO_\\src\\This_it_GBK.txt");
        File f2 = new File("D:\\A_java\\java_study\\IO_\\src\\This_is_GBK_Destination.txt");
        FileInputStream fis = new FileInputStream(f);
        FileOutputStream fos = new FileOutputStream(f2);
        int len;
        while((len = fis.read()) != -1){
            fos.write(len);
        }
        fos.close();
        fis.close();
        //发现都正常, 因为字节流本身就只负责搬运, 真的就只是把一堆字节移动到另外一堆里面

        //尝试用字符流读 GBK 的文本
        FileReader fr = new FileReader(f, Charset.forName("UTF-8"));
        FileWriter fw = new FileWriter(f2, Charset.forName("UTF-8"));
        while((len = fr.read()) != -1){
            //System.out.println(len);
            fw.write(len);
        }
        fw.close();
        fr.close();


        FileInputStream fis2 = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(fis2, "GBK");
        String str;
        BufferedReader br1 = new BufferedReader(isr);

        while((str = br1.readLine()) != null){
            System.out.println(str);
        }
        while((len = isr.read()) != -1){
            System.out.println((char)len);
        }
        fis2.close();





    }

}
