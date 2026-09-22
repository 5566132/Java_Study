package Test.Test1;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        File start = new File("D:\\A_java\\java_study\\IO_\\OriginalFile");
        File end = new File("D:\\A_java\\java_study\\IO_\\CopyDestination");
        copyFile(start, end);




    }
    private static void copyFile(File start , File end) throws IOException {
        end.mkdir();
        File[] all = start.listFiles();
        for(File temp : all){
            //如果temp是文件, 直接拷贝
            if(temp.isFile()){
                FileInputStream fis = new FileInputStream(temp);
                FileOutputStream fos = new FileOutputStream(new File(end, temp.getName()));
                byte[] by = new byte[1024];
                int len;
                while((len = fis.read(by)) != -1){
                    fos.write(by, 0, len);
                }
                fos.close();
                fis.close();
            }else{
                copyFile(temp, new File(end, temp.getName()));
            }

        }


    }



}
