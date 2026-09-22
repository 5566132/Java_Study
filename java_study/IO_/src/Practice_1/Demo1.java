package Practice_1;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\A_java\\java_study\\IO_\\src\\Practice_1\\record.txt");
        if(!f1.exists()){
            System.out.println("  文件不存在  ");
            f1.createNewFile();
        }
        FileInputStream fis = new FileInputStream(f1);

        int len = 0;
        int cnt = 0;
        System.out.println("------------");
        while((len = fis.read()) != -1){
            System.out.println(" len = " + len);
            cnt = len;
        }
        System.out.println(" cnt = " + cnt );
        if(cnt != 0){
            cnt = cnt - '0';
        }
        System.out.println(" cnt = " + cnt );
        if(cnt < 3){
            System.out.println("这是第 " + (cnt + 1) + " 次使用");
        }else{
            System.out.println("只能免费使用3次, 所以现在不能用了");
        }
        FileOutputStream fos = new FileOutputStream(f1);
        cnt++;
        fos.write(('0' + cnt));
        fos.close();
        fis.close();






    }
}
