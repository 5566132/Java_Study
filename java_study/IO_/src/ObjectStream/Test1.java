package ObjectStream;

import java.io.*;

public class Test1 {
    public static void main(String[] args) throws IOException {
        Stu s1 = new Stu("你好123ccc", 99);
        File f1 = new File("D:\\A_java\\java_study\\IO_\\src\\ObjectStream\\IO1.txt");
        FileOutputStream fos = new FileOutputStream(f1);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.close();







    }
}
