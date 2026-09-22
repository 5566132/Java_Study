package Print_Stream;

import java.io.*;

public class Demo1 {
    public static void main(String[] args) throws FileNotFoundException {
        File f1 = new File("D:\\A_java\\java_study\\IO_\\src\\Print_Stream\\abc.txt");
        PrintStream ps = new PrintStream(new FileOutputStream(f1), true);
        ps.println("99单位i回答我dd");
        ps.close();
        PrintWriter ps2 = new PrintWriter(f1);
        ps2.println(123);
        ps2.println("ccc");
        ps2.println("温度对我很好");
        ps2.close();
        BufferedReader br = new BufferedReader(new FileReader(f1));
        //PrintWriter pw = new PrintWriter(br);



    }
}
